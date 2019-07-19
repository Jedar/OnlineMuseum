package fudan.ossw.dao;

import fudan.ossw.entity.Message;

import java.util.List;

public interface MessageDao {
    public List<Message> getMessageBySender(int id);

    public List<Message> getMessageByReceiver(int id);

    public boolean sendMessage(Message msg);

    public boolean readMessage(int msgID);

    public boolean deleteMessage(int msgID);
}
