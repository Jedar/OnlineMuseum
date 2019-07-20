package fudan.ossw.service;
import fudan.ossw.entity.Message;

import java.util.List;

public interface MessageService  extends BaseService {
    List<Message> getReadMessageList(int userID);
    List<Message> getUnreadMessageList(int useID);
    List<Message> getReceivedMessage(int userID);
    boolean sendMessage(Message message);
    boolean readMessage(int messageID);
    boolean deleteMessage(int messageID);
}
