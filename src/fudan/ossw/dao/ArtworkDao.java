package fudan.ossw.dao;

import fudan.ossw.entity.Artwork;

public interface ArtworkDao {

    public Artwork getArtwork(int id);

    public boolean deleteArtwork(int id);

    public boolean addArtwork(Artwork artwork);

    public boolean updateArtwork(int id, Artwork artwork);
}
