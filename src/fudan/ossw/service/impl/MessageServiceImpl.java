package fudan.ossw.service.impl;

import fudan.ossw.dao.DaoFactory;
import fudan.ossw.dao.MessageDao;
import fudan.ossw.entity.Message;
import fudan.ossw.service.MessageService;

import java.util.List;

/**
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 23:04
 * @Version 1.0
 **/
public class MessageServiceImpl implements MessageService {
    MessageDao messageDao = DaoFactory.getInstance().getMessageDao();
    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public List<Message> getReadMessageList(int userID) {
        return messageDao.getReadMessage(userID);
    }

    @Override
    public List<Message> getUnreadMessageList(int userID) {
        return messageDao.getUnreadMessage(userID);
    }

    @Override
    public List<Message> getReceivedMessage(int userID) {
        return messageDao.getMessageByReceiver(userID);
    }

    @Override
    public List<Message> getSendMessageList(int userID) {
        return messageDao.getMessageBySender(userID);
    }

    @Override
    public boolean sendMessage(Message message) {
        return messageDao.sendMessage(message);
    }

    @Override
    public boolean readMessage(int messageID) {
        return messageDao.readMessage(messageID);
    }

    @Override
    public boolean deleteMessage(int messageID) {
        return messageDao.deleteMessage(messageID);
    }
}
