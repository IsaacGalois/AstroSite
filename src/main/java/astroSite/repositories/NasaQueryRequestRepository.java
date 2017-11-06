package astroSite.repositories;

import astroSite.domain.NasaQueryRequest;
import org.springframework.data.repository.CrudRepository;

public interface NasaQueryRequestRepository extends CrudRepository<NasaQueryRequest, Integer>{
}
