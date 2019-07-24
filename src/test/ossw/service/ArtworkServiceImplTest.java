package test.ossw.service;

import fudan.ossw.entity.Artwork;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.impl.ArtworkServiceImpl;

import java.util.List;

public class ArtworkServiceImplTest {
    public static void main(String[] args) {
        ArtworkService service = new ArtworkServiceImpl();

        List<Artwork> list = service.getHeatList();

        for (Artwork artwork:list){
            System.out.println(artwork.getTitle());
        }

        list = service.getNewestList();

        for (Artwork artwork:list){
            System.out.println(artwork.getTitle());
        }
        testSearchPage();
    }

    private static void testSearchPage() {
        ArtworkService service = new ArtworkServiceImpl();
        System.out.println(service.search("玉", "", "", ""));
    }
}
