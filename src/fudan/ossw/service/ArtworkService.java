package service;

import fudan.ossw.entity.Artwork;

import java.util.List;

public interface ArtworkService {
    String getErrorMessage();
    boolean update(Artwork artwork);
    boolean delete(Artwork artwork);
    List<Artwork> search(String title, String description, String location);
}
