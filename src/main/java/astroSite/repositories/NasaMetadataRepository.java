package astroSite.repositories;

import astroSite.domain.NasaMetadata;
import org.springframework.data.repository.CrudRepository;

public interface NasaMetadataRepository extends CrudRepository<NasaMetadata, Integer> {
}
