package fudan.ossw.service;

import fudan.ossw.entity.Artwork;

import java.util.List;

public interface ArtworkService extends BaseService {
    boolean update(Artwork artwork);
    boolean delete(Artwork artwork);
    List<Artwork> getHeatList();
    List<Artwork> getNewestList();
    boolean view(int artworkID);
    Artwork getArtworkByID(int artworkID);
    List<Artwork> search(String title, String description, String location, String sortWay);
    List<Artwork> searchPage(String title, String description, String location, String sortWay, int mark, int pageSize);
}
