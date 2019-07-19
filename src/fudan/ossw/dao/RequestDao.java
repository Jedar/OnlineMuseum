package fudan.ossw.dao;

import fudan.ossw.entity.Request;

import java.util.List;

public interface RequestDao {
    public boolean addRequest(Request request);

    public List<Request> getRequestList(int userID);

    public boolean deleteRequest(int requestID);
}
