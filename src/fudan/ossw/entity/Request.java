package fudan.ossw.entity;
import java.sql.Date;

/**
 * @ClassName dao.impl.RequestDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/17 10:33
 * @Version 1.0
 **/
public class Request {
    private int requestID;
    private int senderID;
    private int receiverID;
    private String content;
    private Date sendTime;
    private boolean agree;
    private boolean isRead;

    public Request() {
    }

    public Request(int requestID, int senderID, int receiverID, String content, Date sendTime, boolean agree, boolean isRead) {
        this.requestID = requestID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
        this.sendTime = sendTime;
        this.agree = agree;
        this.isRead = isRead;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public boolean getAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean read) {
        isRead = read;
    }
}
