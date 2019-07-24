package fudan.ossw.service;

import fudan.ossw.entity.Artwork;

import java.util.List;

public interface ArtworkService extends BaseService {
    /*插入新的艺术品*/
    boolean insert(Artwork artwork);

    /*更新艺术品信息*/
    boolean update(Artwork artwork);

    /*删除艺术品*/
    boolean delete(Artwork artwork);

    /*得到热度最高的三个艺术品*/
    List<Artwork> getHeatList();

    /*得到最新上传的三个艺术品*/
    List<Artwork> getNewestList();

    /*更新艺术品的热度*/
    boolean view(int artworkID);

    /*通过ID得到艺术品*/
    Artwork getArtworkByID(int artworkID);

    /*模糊搜索所有的艺术品*/
    List<Artwork> search(String title, String description, String location, String sortWay);

    /*模糊搜索一页艺术品*/
    List<Artwork> searchPage(String title, String description, String location, String sortWay, int mark, int pageSize);
}
