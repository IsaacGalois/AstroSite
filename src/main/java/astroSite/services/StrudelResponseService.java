package astroSite.services;

import astroSite.domain.StrudelResponse;

public interface StrudelResponseService {

    Iterable<StrudelResponse> listAllStrudelResponses();

    StrudelResponse getStrudelResponseById(Integer id);

    StrudelResponse saveStrudelResponse(StrudelResponse strudelResponse);

    Iterable<StrudelResponse> saveStrudelResponseList(Iterable<StrudelResponse> strudelResponseIterable);

    void deleteStrudelResponse(Integer id);
}
