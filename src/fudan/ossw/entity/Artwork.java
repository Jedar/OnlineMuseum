package fudan.ossw.entity;

import java.sql.Date;

public class Artwork {
    private int artID;
    private String title;
    private String imageFileName;
    private String videoFileName;
    private String age;
    private String size;
    private String description;
    private int view;
    private String location;
    private String findTime;
    private Date timeReleased;
    private boolean isDelete;
    private int uploadID;

    public Artwork(){

    }

    public Artwork(int artID, String title, String imageFileName, String videoFileName, String age, String size, String description, int view, String location) {
        this.artID = artID;
        this.title = title;
        this.imageFileName = imageFileName;
        this.videoFileName = videoFileName;
        this.age = age;
        this.size = size;
        this.description = description;
        this.view = view;
        this.location = location;
        this.findTime = "";
        this.timeReleased = new Date(new java.util.Date().getTime());
        this.isDelete = false;
        this.uploadID = 1;
    }

    public int getArtID() {
        return artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFindTime() {
        return findTime;
    }

    public void setFindTime(String findTime) {
        this.findTime = findTime;
    }

    public Date getTimeReleased() {
        return timeReleased;
    }

    public void setTimeReleased(Date timeReleased) {
        this.timeReleased = timeReleased;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        isDelete = delete;
    }

    public int getUploadID() {
        return uploadID;
    }

    public void setUploadID(int uploadID) {
        this.uploadID = uploadID;
    }
}
