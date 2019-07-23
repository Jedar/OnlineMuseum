package fudan.ossw.service.impl;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.CriteriaArtwork;
import fudan.ossw.service.ArtworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName ArtworkServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 19:46
 * @Version 1.0
 **/
public class ArtworkServiceImpl implements ArtworkService{
    private Logger logger = LoggerFactory.getLogger("artwork");

    private ArtworkDao dao = DaoFactory.getInstance().getArtworkDao();

    String errorMessage;

    @Override
    public int getErrorCode() {
        return 0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean insert(Artwork artwork) {
        if (artwork.getImageFileName() == null || artwork.getImageFileName().equals("")){
            artwork.setImageFileName("Test.jpg");
        }
        if (artwork.getVideoFileName() == null || artwork.getVideoFileName().equals("")){
            artwork.setVideoFileName("test.mp4");
        }

        logger.info("Insert Artwork: title-{}",artwork.getTitle());

        return dao.addArtwork(artwork);
    }

    public boolean update(Artwork artwork) {
        Artwork old = DaoFactory.getInstance().getArtworkDao().getArtwork(artwork.getArtID());
        if (old == null){
            errorMessage = "未找到更新的藏品";
            return false;
        }
        if (artwork.getVideoFileName() == null || "".equals(artwork.getVideoFileName())){
            artwork.setVideoFileName(old.getVideoFileName());
        }
        if (artwork.getImageFileName() == null || "".equals(artwork.getImageFileName())){
            artwork.setImageFileName(old.getImageFileName());
        }
        artwork.setView(old.getView());

        logger.info("Update Artwork: id-{}",old.getArtID());

        return DaoFactory.getInstance().getArtworkDao().updateArtwork(artwork.getArtID(), artwork);
    }

    public boolean delete(Artwork artwork) {
        logger.info("Delete Artwork: title-{}",artwork.getTitle());
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
