package astroSite.services.impl;

import astroSite.domain.StrudelImage;
import astroSite.repositories.StrudelImageRepository;
import astroSite.services.StrudelImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelImageServiceImpl implements StrudelImageService {

    @Autowired
    private StrudelImageRepository strudelImageRepository;

    @Override
    public Iterable<StrudelImage> listAllStrudelImages() {
        return strudelImageRepository.findAll();
    }

    @Override
    public StrudelImage getStrudelImageById(Integer id) {
        return strudelImageRepository.findOne(id);
    }

    @Override
    public StrudelImage saveStrudelImage(StrudelImage strudelImage) {
        return strudelImageRepository.save(strudelImage);
    }

    @Override
    public Iterable<StrudelImage> saveStrudelImageList(Iterable<StrudelImage> strudelImageIterable) {
        return strudelImageRepository.save(strudelImageIterable);
    }

    @Override
    public void deleteStrudelImage(Integer id) {
        strudelImageRepository.delete(id);
    }
}
