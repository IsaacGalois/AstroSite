package astroSite.services;

import astroSite.domain.StrudelServOb;

public interface StrudelServObService {

    Iterable<StrudelServOb> listAllStrudelServObs();

    StrudelServOb getStrudelServObById(Integer id);

    StrudelServOb saveStrudelServOb(StrudelServOb strudelServOb);

    Iterable<StrudelServOb> saveStrudelServObList(Iterable<StrudelServOb> strudelServObIterable);

    void deleteStrudelServOb(Integer id);
}
