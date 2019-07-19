package fudan.ossw.dao;

import fudan.ossw.entity.Message;

import java.util.List;

public interface MessageDao {
    public List<Message> getMessageBySender(int id);

    public List<Message> getMessageByReceiver(int id);

    public void sendMessage(Message msg);

    public void readMessage(Message msg);

    public void deleteMessage(Message message);
}
