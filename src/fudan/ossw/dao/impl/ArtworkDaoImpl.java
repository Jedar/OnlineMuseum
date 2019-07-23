package fudan.ossw.dao.impl;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.BaseDao;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.CriteriaArtwork;

import java.util.List;

public class ArtworkDaoImpl implements ArtworkDao {
    private BaseDao<Artwork> baseDao = new JDBCDao<>();

    private static String SQL_SELECT = "SELECT `arts`.`artID`," +
            "    `arts`.`title`," +
            "    `arts`.`imageFileName`," +
            "    `arts`.`videoFileName`," +
            "    `arts`.`age`," +
            "    `arts`.`size`," +
            "    `arts`.`description`," +
            "    `arts`.`view`," +
            "    `arts`.`location`," +
            "    `arts`.`findTime`," +
            "    `arts`.`timeReleased`," +
            "    `arts`.`isDelete`," +
            "    `arts`.`uploadID`" +
            "FROM `arts` WHERE artID=? AND isDelete=?;";

    private static String SQL_UPDATE = "UPDATE `OnlineMuseum`.`arts` " +
            "SET " +
            "`title` = ?, " +
            "`imageFileName` = ?, " +
            "`videoFileName` = ?, " +
            "`age` = ?, " +
            "`size` = ?, " +
            "`description` = ?, " +
            "`view` = ?, " +
            "`location` = ?, " +
            "`findTime` = ?, " +
            "`timeReleased` = ?, " +
            "`isDelete` = ?, " +
            "`uploadID` = ? " +
            "WHERE `artID` = ? AND isDelete=?; ";

    private static String SQL_INSERT = "INSERT INTO `OnlineMuseum`.`arts` " +
            "(`artID`, " +
            "`title`, " +
            "`imageFileName`, " +
            "`videoFileName`, " +
            "`age`, " +
            "`size`, " +
            "`description`, " +
            "`view`, " +
            "`location`, " +
            "`findTime`, " +
            "`timeReleased`, " +
            "`isDelete`, " +
            "`uploadID`) " +
            "VALUES " +
            "(NULL,?,?,?,?,?,?,?,?,?,?,?,?);\n";

    @Override
    public Artwork getArtwork(int id) {
        return baseDao.get(Artwork.class,SQL_SELECT,id,false);
    }

    @Override
    public boolean deleteArtwork(int id) {
        Artwork artwork = getArtwork(id);
        if(artwork == null){
            return false;
        }
        if(artwork.getIsDelete()){
            return false;
        }
        artwork.setIsDelete(true);
        updateArtwork(artwork.getArtID(),artwork);
        return true;
    }

    @Override
    public boolean addArtwork(Artwork artwork) {
        return baseDao.update(Artwork.class,SQL_INSERT,artwork.getTitle(),artwork.getImageFileName(),artwork.getVideoFileName(),
                artwork.getAge(),artwork.getSize(),artwork.getDescription(),artwork.getView(),artwork.getLocation(),
                artwork.getFindTime(),artwork.getTimeReleased(),artwork.getIsDelete(),artwork.getUploadID());
    }

    @Override
    public boolean updateArtwork(int id, Artwork artwork) {
        return baseDao.update(Artwork.class,SQL_UPDATE,artwork.getTitle(),artwork.getImageFileName(),artwork.getVideoFileName(),
                artwork.getAge(),artwork.getSize(),artwork.getDescription(),artwork.getView(),artwork.getLocation(),
                artwork.getFindTime(),artwork.getTimeReleased(),artwork.getIsDelete(),artwork.getUploadID(),id,false);
    }

    @Override
    public List<Artwork> getAllArtworks() {
        String sql = "SELECT * FROM arts WHERE isDelete=?";
        return baseDao.getForList(Artwork.class, sql, false);
    }

    @Override
    public List<Artwork> getHeatList() {
        String sql = "SELECT `arts`.`artID`," +
                "    `arts`.`title`," +
                "    `arts`.`imageFileName`," +
                "    `arts`.`videoFileName`," +
                "    `arts`.`age`," +
                "    `arts`.`size`," +
                "    `arts`.`description`," +
                "    `arts`.`view`," +
                "    `arts`.`location`," +
                "    `arts`.`findTime`," +
                "    `arts`.`timeReleased`," +
                "    `arts`.`isDelete`," +
                "    `arts`.`uploadID`" +
                "FROM `arts` WHERE isDelete=? ORDER BY `view` DESC LIMIT 0,3;";
        return baseDao.getForList(Artwork.class,sql,false);
    }

    @Override
    public List<Artwork> getNewestList() {
        String sql = "SELECT `arts`.`artID`," +
                "    `arts`.`title`," +
                "    `arts`.`imageFileName`," +
                "    `arts`.`videoFileName`," +
                "    `arts`.`age`," +
                "    `arts`.`size`," +
                "    `arts`.`description`," +
                "    `arts`.`view`," +
                "    `arts`.`location`," +
                "    `arts`.`findTime`," +
                "    `arts`.`timeReleased`," +
                "    `arts`.`isDelete`," +
                "    `arts`.`uploadID`" +
                "FROM `arts` WHERE isDelete=? ORDER BY `timeReleased` DESC LIMIT 0,3;";
        return baseDao.getForList(Artwork.class,sql,false);
    }

    @Override
    public List<Artwork> getCriteriaArtworks(CriteriaArtwork ca, String sortWay) {
        String sql = "SELECT * FROM arts " +
                "WHERE title LIKE ? AND description LIKE ? AND location LIKE ? AND isDelete = ? " +
                "ORDER BY view DESC";
        return baseDao.getForList(Artwork.class, sql, ca.getTitle(), ca.getDescription(), ca.getLocation(), false);
    }

    @Override
    public List<Artwork> getPageCriteriaArtworks(CriteriaArtwork ca, String orderWay, int mark, int size) {
        String sql = getSql(orderWay);
        return baseDao.getForList(Artwork.class, sql, ca.getTitle(), ca.getDescription(), ca.getLocation(), false, mark, size);
    }

    private String getSql(String sortWay) {
        switch (sortWay) {
            case "view" :
                return "SELECT * FROM arts WHERE title LIKE ? AND description LIKE ? AND location LIKE ? AND isDelete = ? ORDER BY view DESC LIMIT ? , ?";
            case "timeReleased":
                return "SELECT * FROM arts WHERE title LIKE ? AND description LIKE ? AND location LIKE ? AND isDelete = ? ORDER BY timeReleased DESC LIMIT ? , ?";
        }
        return "SELECT * FROM arts WHERE title LIKE ? AND description LIKE ? AND location LIKE ? AND isDelete = ? ORDER BY view DESC LIMIT ? , ?";
    }
}
