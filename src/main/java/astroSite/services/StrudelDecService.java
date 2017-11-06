package astroSite.services;

import astroSite.domain.StrudelDec;

public interface StrudelDecService {

    Iterable<StrudelDec> listAllStrudelDecs();

    StrudelDec getStrudelDecById(Integer id);

    StrudelDec saveStrudelDec(StrudelDec strudelDec);

    Iterable<StrudelDec> saveStrudelDecList(Iterable<StrudelDec> strudelDecIterable);

    void deleteStrudelDec(Integer id);
}
