package fudan.ossw.dao;

import fudan.ossw.entity.Artwork;

public interface ArtworkDao {

    public Artwork getArtwork(int id);

    public boolean deleteArtwork(int id);

    public void addArtwork(Artwork artwork);

    public void updateArtwork(int id, Artwork artwork);
}
