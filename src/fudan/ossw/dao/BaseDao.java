package fudan.ossw.dao;

import java.util.List;

public interface BaseDao<T>{
    List<T> getForList(Class<T> clazz, String sql, Object... args);

    T get(Class<T> clazz, String sql, Object... args);

    void update(Class<T> clazz, String sql, Object... args);

    void batch(Class<T> clazz, String sql, Object... args);
}