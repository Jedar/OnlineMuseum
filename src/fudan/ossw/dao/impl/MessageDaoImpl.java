package fudan.ossw.dao.impl;

import fudan.ossw.dao.MessageDao;
import fudan.ossw.entity.Message;

import java.util.List;

public class MessageDaoImpl implements MessageDao {
    @Override
    public List<Message> getMessageBySender(int id) {
        return null;
    }

    @Override
    public List<Message> getMessageByReceiver(int id) {
        return null;
    }

    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void readMessage(Message msg) {

    }

    @Override
    public void deleteMessage(Message message) {

    }
}
