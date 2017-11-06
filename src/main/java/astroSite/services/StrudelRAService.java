package astroSite.services;

import astroSite.domain.StrudelRA;

public interface StrudelRAService {

    Iterable<StrudelRA> listAllStrudelRAs();

    StrudelRA getStrudelRAById(Integer id);

    StrudelRA saveStrudelRA(StrudelRA strudelRA);

    Iterable<StrudelRA> saveStrudelRAList(Iterable<StrudelRA> strudelRAIterable);

    void deleteStrudelRA(Integer id);
}
