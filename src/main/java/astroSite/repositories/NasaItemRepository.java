package astroSite.repositories;

import astroSite.domain.NasaItem;
import org.springframework.data.repository.CrudRepository;

public interface NasaItemRepository extends CrudRepository<NasaItem, Integer> {
}
