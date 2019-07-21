package fudan.ossw.service.impl;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.Artwork;
import fudan.ossw.service.ArtworkService;

import java.util.List;

/**
 * @ClassName ArtworkServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 19:46
 * @Version 1.0
 **/
public class ArtworkServiceImpl implements ArtworkService{
    private ArtworkDao dao = DaoFactory.getInstance().getArtworkDao();

    String errorMessage;

    @Override
    public int getErrorCode() {
        return 0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean update(Artwork artwork) {
        return DaoFactory.getInstance().getArtworkDao().updateArtwork(artwork.getArtID(), artwork);
    }

    public boolean delete(Artwork artwork) {
        return DaoFactory.getInstance().getArtworkDao().deleteArtwork(artwork.getArtID());
    }

    public List<Artwork> search(String title, String description, String location) {
        return null;
    }

    @Override
    public List<Artwork> getHeatList() {
        return DaoFactory.getInstance().getArtworkDao().getHeatList();
    }

    @Override
    public List<Artwork> getNewestList() {
        return DaoFactory.getInstance().getArtworkDao().getNewestList();
    }

    @Override
    public boolean view(int artworkID) {
        Artwork artwork = dao.getArtwork(artworkID);

        artwork.setView(artwork.getView() + 1);

        return dao.updateArtwork(artworkID,artwork);
    }

    @Override
    public Artwork getArtworkByID(int artworkID) {
        return dao.getArtwork(artworkID);
    }
}
