package fudan.ossw.dao;

import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.CriteriaArtwork;

import java.util.List;

public interface ArtworkDao {

    public Artwork getArtwork(int id);

    public boolean deleteArtwork(int id);

    public boolean addArtwork(Artwork artwork);

    public boolean updateArtwork(int id, Artwork artwork);

    public List<Artwork> getAllArtworks();

    public List<Artwork> getHeatList();

    public List<Artwork> getNewestList();

    public List<Artwork> getCriteriaArtworks(CriteriaArtwork ca, String orderWay);

    public List<Artwork> getPageCriteriaArtworks(CriteriaArtwork ca, String orderWay, int mark, int size);
}
