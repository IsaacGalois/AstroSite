package astroSite.services;

import astroSite.domain.StrudelTarget;

public interface StrudelTargetService {

    Iterable<StrudelTarget> listAllStrudelTargets();

    StrudelTarget getStrudelTargetById(Integer id);

    StrudelTarget saveStrudelTarget(StrudelTarget strudelTarget);

    Iterable<StrudelTarget> saveStrudelTargetList(Iterable<StrudelTarget> strudelTargetIterable);

    void deleteStrudelTarget(Integer id);
}
