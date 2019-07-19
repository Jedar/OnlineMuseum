package fudan.ossw.dao;

import fudan.ossw.dao.impl.*;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 19:29
 * @Version 1.0
 **/
public class DaoFactory {
    private static DaoFactory daoFactory = new DaoFactory();
    private UserDaoImpl userDao;
    private ArtworkDaoImpl artworkDao;
    private MessageDaoImpl messageDao;
    private RequestDaoImpl requestDao;
    private FriendDaoImpl friendDao;
    private FavoriteDaoImpl favoriteDao;

    private DaoFactory() {
        userDao = new UserDaoImpl();
        artworkDao = new ArtworkDaoImpl();
        messageDao = new MessageDaoImpl();
        requestDao = new RequestDaoImpl();
        friendDao = new FriendDaoImpl();
        favoriteDao = new FavoriteDaoImpl();
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }
    public UserDaoImpl getUserDao(){
        return userDao;
    }
    public ArtworkDaoImpl getArtworkDao() {
        return artworkDao;
    }
    public MessageDaoImpl getMessageDao() {
        return messageDao;
    }
    public RequestDaoImpl getRequestDao() {
        return requestDao;
    }
    public FriendDaoImpl getFriendDao() {
        return friendDao;
    }
    public FavoriteDaoImpl getFavoriteDao() {
        return favoriteDao;
    }
}
