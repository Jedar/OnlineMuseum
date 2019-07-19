package service;

import fudan.ossw.entity.Message;

import java.util.List;

public interface MessageService {
    String getErrorMessage();
    List<Message> getMessageList(int userID);
    boolean sendMessage(Message message);
    boolean readMessage(int messageID);
    boolean deleteMessage(int messageID);
}
