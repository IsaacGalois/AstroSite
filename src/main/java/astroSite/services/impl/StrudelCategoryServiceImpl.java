package astroSite.services.impl;

import astroSite.domain.StrudelCategory;
import astroSite.repositories.StrudelCategoryRepository;
import astroSite.services.StrudelCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelCategoryServiceImpl implements StrudelCategoryService {

    @Autowired
    private StrudelCategoryRepository strudelCategoryRepository;

    @Override
    public Iterable<StrudelCategory> listAllStrudelCategorys() {
        return strudelCategoryRepository.findAll();
    }

    @Override
    public StrudelCategory getStrudelCategoryById(Integer id) {
        return strudelCategoryRepository.findOne(id);
    }

    @Override
    public StrudelCategory saveStrudelCategory(StrudelCategory strudelCategory) {
        return strudelCategoryRepository.save(strudelCategory);
    }

    @Override
    public Iterable<StrudelCategory> saveStrudelCategoryList(Iterable<StrudelCategory> strudelCategoryIterable) {
        return strudelCategoryRepository.save(strudelCategoryIterable);
    }

    @Override
    public void deleteStrudelCategory(Integer id) {
        strudelCategoryRepository.delete(id);
    }
}
