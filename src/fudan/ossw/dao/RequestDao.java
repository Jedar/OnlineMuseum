package fudan.ossw.dao;

import fudan.ossw.entity.Request;

import java.util.List;

public interface RequestDao {
    public boolean readRequest(int requestID, boolean agree);

    public boolean readRequest(int senderID, int receiverID, boolean agree);

    public boolean addRequest(Request request);

    public List<Request> getRequestList(int userID);

    public List<Request> getRequestList(int senderID, int receiverID);

    public boolean deleteRequest(int requestID);

    public Request getRequest(int requestID);
}
