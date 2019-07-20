package fudan.ossw.service.impl;

import fudan.ossw.dao.DaoFactory;
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
        return DaoFactory.getInstance().getMessageDao().getReadMessage(userID);
    }

    @Override
    public List<Message> getUnreadMessageList(int userID) {
        return DaoFactory.getInstance().getMessageDao().getUnreadMessage(userID);
    }

    @Override
    public List<Message> getReceivedMessage(int userID) {
        return DaoFactory.getInstance().getMessageDao().getMessageByReceiver(userID);
    }

    @Override
    public boolean sendMessage(Message message) {
        return DaoFactory.getInstance().getMessageDao().sendMessage(message);
    }

    @Override
    public boolean readMessage(int messageID) {
        return DaoFactory.getInstance().getMessageDao().readMessage(messageID);
    }

    @Override
    public boolean deleteMessage(int messageID) {
        return DaoFactory.getInstance().getMessageDao().deleteMessage(messageID);
    }
}
