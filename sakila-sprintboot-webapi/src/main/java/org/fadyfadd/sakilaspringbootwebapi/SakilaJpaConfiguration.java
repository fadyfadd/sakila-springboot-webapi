package org.fadyfadd.sakilaspringbootwebapi;

import java.util.Objects;

import javax.sql.DataSource;

import org.fadyfadd.sakilaspringbootwebapi.sakila.Actor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackageClasses = Actor.class,
  entityManagerFactoryRef = "sakilaEntityManagerFactory",
  transactionManagerRef = "sakilaTransactionManager"
)
public class SakilaJpaConfiguration {
	
	@Bean
	@ConfigurationProperties("spring.datasource.hikari")
	public DataSource sakilaDataSource() {
	    return sakilaDataSourceProperties()
	      .initializeDataSourceBuilder()
	      .build();
	}
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties sakilaDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    public JdbcTemplate sakilaJdbcTemplate(@Qualifier("sakilaDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean sakilaEntityManagerFactory(
      @Qualifier("sakilaDataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(sakilaDataSource())
          .packages("org.fadyfadd.sakilaspringbootwebapi.sakila")
          .build();
    }

    @Bean
    public PlatformTransactionManager sakilaTransactionManager(
      @Qualifier("sakilaEntityManagerFactory") LocalContainerEntityManagerFactoryBean sakilaEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(sakilaEntityManagerFactory.getObject()));
    }	 

}