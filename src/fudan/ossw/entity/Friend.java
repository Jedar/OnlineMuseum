package fudan.ossw.entity;

/**
 * @ClassName Friend
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/17 10:29
 * @Version 1.0
 **/
public class Friend {
    private int friendID;
    private int partyAID;
    private int partyBID;
    private boolean favoritesVisible;

    public Friend() {
    }

    public Friend(int partyAID, int partyBID, boolean favoritesVisible) {
        this.friendID = 0;
        this.partyAID = partyAID;
        this.partyBID = partyBID;
        this.favoritesVisible = favoritesVisible;
    }

    public int getFriendID() {
        return friendID;
    }

    public void setFriendID(int friendID) {
        this.friendID = friendID;
    }

    public int getPartyAID() {
        return partyAID;
    }

    public void setPartyAID(int partyAID) {
        this.partyAID = partyAID;
    }

    public int getPartyBID() {
        return partyBID;
    }

    public void setPartyBID(int partyBID) {
        this.partyBID = partyBID;
    }

    public boolean getFavoritesVisible() {
        return favoritesVisible;
    }

    public void setFavoritesVisible(boolean favoritesVisible) {
        this.favoritesVisible = favoritesVisible;
    }
}
