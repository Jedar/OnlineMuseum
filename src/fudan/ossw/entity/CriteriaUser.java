package fudan.ossw.entity;

import java.sql.Date;

/**
 * @ClassName CriteriaUser
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 20:58
 * @Version 1.0
 **/
public class CriteriaUser {
    String username;
    String address;
    public CriteriaUser() {

    }
    public CriteriaUser(String username, String address) {
        this.username = username;
        this.address = address;
    }
    public CriteriaUser(String username) {
        this.username = username;
    }
    public String getUsername() {
        if(username == null)
            return "%%";
        else
            return "%" + username + "%";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        if(address == null)
            return "%%";
        else
            return "%" + address + "%";
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
