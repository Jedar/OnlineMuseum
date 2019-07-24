package fudan.ossw.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

public class Artwork {
    @JSONField(name="artID")
    private int artID;

    @JSONField(name="title")
    private String title;

    @JSONField(name="imageFileName")
    private String imageFileName;

    @JSONField(name="videoFileName", serialize=false)
    private String videoFileName;

    @JSONField(name="age")
    private String age;

    @JSONField(name="size", serialize=false)
    private String size;

    @JSONField(name="description")
    private String description;

    @JSONField(name="view")
    private int view;

    @JSONField(name="location", serialize=false)
    private String location;

    @JSONField(name="findTime", serialize=false)
    private String findTime;

    @JSONField(name="timeReleased", serialize=false)
    private Timestamp timeReleased;

    @JSONField(name="delete", serialize=false)
    private boolean isDelete = false;

    @JSONField(name="uploadID", serialize=false)
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
        this.timeReleased = new Timestamp(new java.util.Date().getTime());
        this.isDelete = false;
        this.uploadID = 1;
    }

    public Artwork(int artID, String title, String imageFileName, String videoFileName, String age, String size, String description, String location, String findTime,int uploadID) {
        this.artID = artID;
        this.title = title;
        this.imageFileName = imageFileName;
        this.videoFileName = videoFileName;
        this.age = age;
        this.size = size;
        this.description = description;
        this.location = location;
        this.findTime = findTime;
        this.uploadID = uploadID;
        this.timeReleased = new Timestamp(new java.util.Date().getTime());
        this.isDelete = false;
        this.view=0;
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

    public Timestamp getTimeReleased() {
        return timeReleased;
    }

    public void setTimeReleased(Timestamp timeReleased) {
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

    @Override
    public String toString() {
        return artID + " " + title + " " + description;
    }
}
