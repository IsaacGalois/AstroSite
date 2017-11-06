package astroSite.repositories;

import astroSite.domain.NasaData;
import org.springframework.data.repository.CrudRepository;

public interface NasaDataRepository extends CrudRepository<NasaData, Integer>{
}
