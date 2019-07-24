package fudan.ossw.dao.impl;

import fudan.ossw.dao.BaseDao;
import fudan.ossw.dao.RequestDao;
import fudan.ossw.entity.Request;

import java.util.List;

public class RequestDaoImpl implements RequestDao {
    private BaseDao<Request> dao = new JDBCDao<>();

    @Override
    public boolean readRequest(int requestID,boolean agree) {
        String sql = "UPDATE `OnlineMuseum`.`requests`\n" +
                "SET\n" +
                "`agree` = ?,\n" +
                "`isRead` = ?\n" +
                "WHERE `requestID`=? AND `isRead`=?;\n";
        return dao.update(Request.class,sql,agree,true,requestID,false);
    }

    @Override
    public boolean readRequest(int senderID, int receiverID, boolean agree) {
        String sql = "UPDATE requests SET agree = ?, isRead = ? WHERE senderID = ? AND receiverID = ?";
        return dao.update(Request.class, sql, agree, true, senderID, receiverID);
    }

    @Override
    public boolean addRequest(Request request) {
        String sql = "INSERT INTO `OnlineMuseum`.`requests`\n" +
                "(`requestID`,\n" +
                "`senderID`,\n" +
                "`receiverID`,\n" +
                "`content`,\n" +
                "`sendTime`,\n" +
                "`agree`,\n" +
                "`isRead`)\n" +
                "VALUES\n" +
                "(NULL,?,?,?,?,?,?);\n";
        return dao.update(Request.class,
                sql,
                request.getSenderID(),request.getReceiverID(),request.getContent(),request.getSendTime(),
                false,false);
    }

    @Override
    public List<Request> getRequestList(int userID) {
        /* query by receiver id */
        String sql = "SELECT `requests`.`requestID`,\n" +
                "    `requests`.`senderID`,\n" +
                "    `requests`.`receiverID`,\n" +
                "    `requests`.`content`,\n" +
                "    `requests`.`sendTime`,\n" +
                "    `requests`.`agree`,\n" +
                "    `requests`.`isRead`\n" +
                "FROM `OnlineMuseum`.`requests`\n" +
                "WHERE `receiverID`=? ORDER BY sendTime;\n";
        return dao.getForList(Request.class,sql,userID);
    }

    @Override
    public boolean deleteRequest(int requestID) {
        String sql = "DELETE FROM `requests` WHERE `requestID`=?;";
        return dao.update(Request.class,sql,requestID);
    }

    @Override
    public Request getRequest(int requestID) {
        String sql = "SELECT * FROM requests WHERE requestID = ?";
        return dao.get(Request.class, sql, requestID);
    }

    @Override
    public List<Request> getRequestList(int senderID, int receiverID) {
        String sql = "SELECT * FROM requests WHERE senderID = ? AND receiverID = ? and isRead = ?";
        return dao.getForList(Request.class, sql, senderID, receiverID, false);
    }
}
