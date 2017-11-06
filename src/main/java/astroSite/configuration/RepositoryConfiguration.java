package astroSite.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"astroSite.domain"}) //<--Tell DAO accessing functions to look for entities in mvc.models package
@EnableJpaRepositories(basePackages = {"astroSite.repositories"}) //<--Tell DAO accessing functions to look for repositories in mvc.repositories package
@EnableTransactionManagement
public class RepositoryConfiguration {
}
