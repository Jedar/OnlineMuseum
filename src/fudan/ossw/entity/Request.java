package fudan.ossw.entity;


import java.sql.Timestamp;

public class Request {
    private int requestID;
    private int senderID;
    private int receiverID;
    private String content;
    private Timestamp sendTime;
    private boolean agree;
    private boolean isRead;

    public Request() {
    }

    public Request(int requestID, int senderID, int receiverID, String content, Timestamp sendTime, boolean agree, boolean isRead) {
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

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
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
