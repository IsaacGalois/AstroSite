package astroSite.repositories;

import astroSite.domain.NasaCollection;
import org.springframework.data.repository.CrudRepository;

public interface NasaCollectionRepository extends CrudRepository<NasaCollection, Integer> {
}
