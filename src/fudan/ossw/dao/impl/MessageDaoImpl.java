package fudan.ossw.dao.impl;

import fudan.ossw.dao.BaseDao;
import fudan.ossw.dao.MessageDao;
import fudan.ossw.entity.Message;

import java.sql.Date;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    private BaseDao<Message> dao = new JDBCDao<>();

    @Override
    public List<Message> getMessageBySender(int id) {
        String sql = "SELECT `messages`.`messageID`,\n" +
                "    `messages`.`senderID`,\n" +
                "    `messages`.`receiverID`,\n" +
                "    `messages`.`content`,\n" +
                "    `messages`.`sendTime`,\n" +
                "    `messages`.`isRead`\n" +
                "FROM `OnlineMuseum`.`messages`\n" +
                "WHERE senderID=?;";
        return dao.getForList(Message.class,sql,id);
    }

    @Override
    public List<Message> getReadMessage(int receiverID) {
        String sql = "SELECT `messages`.`messageID`,\n" +
                "    `messages`.`senderID`,\n" +
                "    `messages`.`receiverID`,\n" +
                "    `messages`.`content`,\n" +
                "    `messages`.`sendTime`,\n" +
                "    `messages`.`isRead`\n" +
                "FROM `OnlineMuseum`.`messages`\n" +
                "WHERE senderID=? AND isRead = ?;";
        return dao.getForList(Message.class,sql,receiverID, true);
    }

    @Override
    public List<Message> getUnreadMessage(int receiverID) {
        String sql = "SELECT `messages`.`messageID`,\n" +
                "    `messages`.`senderID`,\n" +
                "    `messages`.`receiverID`,\n" +
                "    `messages`.`content`,\n" +
                "    `messages`.`sendTime`,\n" +
                "    `messages`.`isRead`\n" +
                "FROM `OnlineMuseum`.`messages`\n" +
                "WHERE senderID=? AND isRead = ?;";
        return dao.getForList(Message.class,sql,receiverID, false);
    }

    @Override
    public List<Message> getMessageByReceiver(int id) {
        String sql = "SELECT `messages`.`messageID`,\n" +
                "    `messages`.`senderID`,\n" +
                "    `messages`.`receiverID`,\n" +
                "    `messages`.`content`,\n" +
                "    `messages`.`sendTime`,\n" +
                "    `messages`.`isRead`\n" +
                "FROM `OnlineMuseum`.`messages`\n" +
                "WHERE receiverID=?;";
        return dao.getForList(Message.class,sql,id);
    }

    @Override
    public boolean sendMessage(Message msg) {
        String sql = "INSERT INTO `OnlineMuseum`.`messages`\n" +
                "(`messageID`,\n" +
                "`senderID`,\n" +
                "`receiverID`,\n" +
                "`content`,\n" +
                "`sendTime`,\n" +
                "`isRead`)\n" +
                "VALUES\n" +
                "(NULL,?,?,?,?,?);\n";

        return dao.update(Message.class,
                sql,
                msg.getSenderID(),msg.getReceiverID(),msg.getContent(),new Date(new java.util.Date().getTime()),false);
    }

    @Override
    public boolean readMessage(int msgID) {
        String sql = "UPDATE `OnlineMuseum`.`messages`\n" +
                "SET\n" +
                "`isRead` = ?\n" +
                "WHERE `messageID` = ?;\n";
        return dao.update(Message.class,sql,true,msgID);
    }

    @Override
    public boolean deleteMessage(int msgID) {
        String sql = "DELETE FROM `OnlineMuseum`.`messages` WHERE `messageID`=?;";
        return dao.update(Message.class,sql,msgID);
    }
}
