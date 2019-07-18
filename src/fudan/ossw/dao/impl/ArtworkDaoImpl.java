package fudan.ossw.dao.impl;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.Dao;
import fudan.ossw.entity.Artwork;

public class ArtworkDaoImpl implements ArtworkDao {
    private Dao<Artwork> dao = new JDBCDao<>();

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
            "FROM `arts` WHERE artID=?;";

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
            "WHERE `artID` = ?; ";

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
        return dao.get(Artwork.class,SQL_SELECT,id);
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
    public void addArtwork(Artwork artwork) {
        dao.update(Artwork.class,SQL_INSERT,artwork.getTitle(),artwork.getImageFileName(),artwork.getVideoFileName(),
                artwork.getAge(),artwork.getSize(),artwork.getDescription(),artwork.getView(),artwork.getLocation(),
                artwork.getFindTime(),artwork.getTimeReleased(),artwork.getIsDelete(),artwork.getUploadID());
    }

    @Override
    public void updateArtwork(int id, Artwork artwork) {
        dao.update(Artwork.class,SQL_UPDATE,artwork.getTitle(),artwork.getImageFileName(),artwork.getVideoFileName(),
                artwork.getAge(),artwork.getSize(),artwork.getDescription(),artwork.getView(),artwork.getLocation(),
                artwork.getFindTime(),artwork.getTimeReleased(),artwork.getIsDelete(),artwork.getUploadID(),id);
    }
}
