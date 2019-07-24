package fudan.ossw.entity;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;


public class User {
    @JSONField(name="userID")
    private int userID;

    @JSONField(name="username")
    private String username;

    @JSONField(name="password", serialize = false)
    private String password;

    @JSONField(name="email")
    private String email;

    @JSONField(name="phone")
    private String phone;

    @JSONField(name="address")
    private String address;

    @JSONField(name="isDelete", serialize = false)
    private boolean isDelete;

    @JSONField(name="isManager", serialize = false)
    private boolean isManager;

    @JSONField(name="visible", serialize = false)
    private boolean visible;

    @JSONField(name="lastLogin", serialize = false)
    private Timestamp lastLogin;

    @JSONField(name="signature")
    private String signature;

    public User() {
    }

    public User(int userID, String username, String password, String email, String phone, String address) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.signature = "这个人很懒，什么都没有留下";
        this.lastLogin = new Timestamp(new java.util.Date().getTime());
        isDelete = false;
        isManager = false;
        visible = false;
    }

    public User(int userID, String username, String password, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = "12345678987";
        this.address = "China";
        this.signature = "这个人很懒，什么都没有留下";
        this.lastLogin = new Timestamp(new java.util.Date().getTime());
        isDelete = false;
        isManager = false;
        visible = false;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean manager) {
        isManager = manager;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return userID + " " + username + " " + password + " " + email + " " + phone + " " + address + " " +
                isManager + " " + visible + " " + isDelete + " " + lastLogin + " " + signature;
    }
}
