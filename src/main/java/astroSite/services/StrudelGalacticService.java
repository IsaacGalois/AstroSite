package astroSite.services;

import astroSite.domain.StrudelGalactic;

public interface StrudelGalacticService {

    Iterable<StrudelGalactic> listAllStrudelGalactics();

    StrudelGalactic getStrudelGalacticById(Integer id);

    StrudelGalactic saveStrudelGalactic(StrudelGalactic strudelGalactic);

    Iterable<StrudelGalactic> saveStrudelGalacticList(Iterable<StrudelGalactic> strudelGalacticIterable);

    void deleteStrudelGalactic(Integer id);
}
