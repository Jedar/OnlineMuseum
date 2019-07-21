package fudan.ossw.service.impl;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.CriteriaArtwork;
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

    public List<Artwork> search(String title, String description, String location, String sortWay) {
        CriteriaArtwork ca = new CriteriaArtwork(title, description, location);
        return DaoFactory.getInstance().getArtworkDao().getCriteriaArtworks(ca, sortWay);
    }

    public List<Artwork> searchPage(String title, String description, String location, String sortWay, int mark, int pageSize) {
        CriteriaArtwork ca = new CriteriaArtwork(title, description, location);
        return DaoFactory.getInstance().getArtworkDao().getPageCriteriaArtworks(ca, sortWay, mark, pageSize);
    }
}
