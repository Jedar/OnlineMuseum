package fudan.ossw.service;
import fudan.ossw.entity.Message;

import java.util.List;

public interface MessageService  extends BaseService {
    /*得到已阅读的信息列表*/
    List<Message> getReadMessageList(int userID);

    /*得到未阅读的信息列表*/
    List<Message> getUnreadMessageList(int useID);

    /*得到收到的信息列表*/
    List<Message> getReceivedMessage(int userID);

    /*得到发送的信息列表*/
    List<Message> getSendMessageList(int userID);

    /*发送信息*/
    boolean sendMessage(Message message);

    /*阅读信息*/
    boolean readMessage(int messageID);

    /*删除信息*/
    boolean deleteMessage(int messageID);
}
