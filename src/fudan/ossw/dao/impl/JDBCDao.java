package fudan.ossw.dao.impl;

import fudan.ossw.dao.Dao;
import fudan.ossw.util.PropertyRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.*;

public class JDBCDao<T> implements Dao<T> {
    private BasicDataSource dataSource = null;

    public JDBCDao(){
        Properties properties = PropertyRepository.getInstance().getJdbcProperties();
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);

        int initSize = Integer.parseInt(properties.getProperty("ds_init_size"));
        int minIdle = Integer.parseInt(properties.getProperty("ds_min_idle"));;
        int maxWait = Integer.parseInt(properties.getProperty("ds_max_wait"));
        int maxIdle = Integer.parseInt(properties.getProperty("ds_max_idle"));

        dataSource.setInitialSize(initSize);
        dataSource.setMaxWaitMillis(maxWait);
        dataSource.setMinIdle(minIdle);
    }

    @Override
    public List<T> getForList(Class<T> clazz, String sql, Object... args) {
        List<T> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);

            int idx = 1;
            for(Object object:args){
                ps.setObject(idx++,object);
            }
            resultSet = ps.executeQuery();
            Map<String,Object> map = new HashMap<>();
            T entity;
            while (resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int column = metaData.getColumnCount();
                for(int i = 0; i < column; i++){
                    String key = metaData.getColumnName(i+1);
                    Object value = resultSet.getObject(key);
                    map.put(key,value);
                }
                entity = clazz.newInstance();
                for(Map.Entry<String,Object> entry:map.entrySet()){
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    BeanUtils.setProperty(entity,name,value);
                }

                list.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(resultSet,ps,conn);
        }
        return list;
    }

    @Override
    public T get(Class<T> clazz, String sql, Object... args) {
        T entity = null;

        List<T> list = getForList(clazz,sql,args);

        if(!list.isEmpty()){
            return list.get(0);
        }

        return entity;
    }

    @Override
    public void update(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);

            int idx = 1;
            for(Object object:args){
                ps.setObject(idx++,object);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(null,ps,conn);
        }
    }

    @Override
    public void batch(Class<T> clazz, String sql, Object... args) {

    }

    private void release(ResultSet rs, Statement statement, Connection conn){
        if(rs != null){
            try {
                rs.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
