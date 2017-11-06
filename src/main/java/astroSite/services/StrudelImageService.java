package astroSite.services;

import astroSite.domain.StrudelImage;

public interface StrudelImageService {

    Iterable<StrudelImage> listAllStrudelImages();

    StrudelImage getStrudelImageById(Integer id);

    StrudelImage saveStrudelImage(StrudelImage strudelImage);

    Iterable<StrudelImage> saveStrudelImageList(Iterable<StrudelImage> strudelImageIterable);

    void deleteStrudelImage(Integer id);
}
