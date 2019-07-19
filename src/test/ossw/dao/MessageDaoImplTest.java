package test.ossw.dao;

import fudan.ossw.dao.MessageDao;
import fudan.ossw.dao.impl.MessageDaoImpl;
import fudan.ossw.entity.Message;

import java.util.List;

public class MessageDaoImplTest {
    public static void main(String[] args) {
        MessageDao dao = new MessageDaoImpl();

        Message message = new Message(3,1,2,"Hello",null,false);

        dao.sendMessage(message);

        List<Message> list;

        list = dao.getMessageByReceiver(2);

        System.out.println(list.size() == 1);

        dao.deleteMessage(list.get(0).getMessageID());

        list = dao.getMessageByReceiver(2);

        System.out.println(list.size() == 0);

    }
}
