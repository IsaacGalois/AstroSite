package astroSite.services;

import astroSite.domain.StrudelCategory;

public interface StrudelCategoryService {

    Iterable<StrudelCategory> listAllStrudelCategorys();

    StrudelCategory getStrudelCategoryById(Integer id);

    StrudelCategory saveStrudelCategory(StrudelCategory strudelCategory);

    Iterable<StrudelCategory> saveStrudelCategoryList(Iterable<StrudelCategory> strudelCategoryIterable);

    void deleteStrudelCategory(Integer id);
}
