package fudan.ossw.entity;

/**
 * @ClassName CriteriaArtwork
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 20:57
 * @Version 1.0
 **/
public class CriteriaArtwork {
    private String title;
    private String description;
    private String location;

    public CriteriaArtwork() {

    }

    public CriteriaArtwork(String title, String description, String location) {
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public String getTitle() {
        if(title == null)
            return "%%";
        else
            return "%" + title + "%";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        if(description == null)
            return "%%";
        else
            return "%" + description + "%";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        if(location == null)
            return "%%";
        else
            return "%" + location + "%";
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
