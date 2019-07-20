package test.ossw.dao;

import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.CriteriaArtwork;

/**
 * @ClassName ArtworkDaoImplTest
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 21:21
 * @Version 1.0
 **/
public class ArtworkDaoImplTest {
    public static void main(String[] args) {
        testGetCriteriaArtworks();
    }

    /*测试模糊查询*/
    public static void testGetCriteriaArtworks() {
        CriteriaArtwork criteriaArtwork = new CriteriaArtwork();
        System.out.println(DaoFactory.getInstance().getArtworkDao().getCriteriaArtworks(criteriaArtwork));
        criteriaArtwork.setLocation("上海");
        System.out.println(DaoFactory.getInstance().getArtworkDao().getPageCriteriaArtworks(criteriaArtwork, "title", 0, 3));
    }
}
