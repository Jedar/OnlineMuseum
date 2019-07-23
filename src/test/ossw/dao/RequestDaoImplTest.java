package test.ossw.dao;

import fudan.ossw.dao.RequestDao;
import fudan.ossw.dao.impl.RequestDaoImpl;
import fudan.ossw.entity.Request;

import java.util.List;

public class RequestDaoImplTest {

    public static void main(String[] args) {
        RequestDao dao = new RequestDaoImpl();

        Request request = new Request(1,2,3,"Hello",new java.sql.Date(new java.util.Date().getTime()),false,false);

        dao.addRequest(request);

        List<Request> list;

        list = dao.getRequestList(3);

        System.out.println(list.size() == 1);

        dao.deleteRequest(list.get(0).getRequestID());

        list = dao.getRequestList(3);

        System.out.println(list.size() == 0);

        dao.readRequest(1, 29, true);
    }
}
