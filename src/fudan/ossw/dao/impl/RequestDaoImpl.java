package fudan.ossw.dao.impl;

import fudan.ossw.dao.RequestDao;
import fudan.ossw.entity.Request;

import java.util.List;

public class RequestDaoImpl implements RequestDao {
    @Override
    public boolean addRequest(Request request) {
        return false;
    }

    @Override
    public List<Request> getRequestList(int userID) {
        return null;
    }

    @Override
    public boolean deleteRequest(int requestID) {
        return false;
    }
}
