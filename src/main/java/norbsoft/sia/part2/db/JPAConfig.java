package norbsoft.sia.part2.db;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan("norbsoft.sia.part2")
public class JPAConfig {

	@Bean
	public BasicDataSource localhostDataSource() {

		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(org.postgresql.Driver.class.getName());

		// @see http://jdbc.postgresql.org/documentation/80/connect.html
		// Format {{jdbc:postgresql://host:port/database}}
		source.setUrl("jdbc:postgresql://localhost:5432/spring-in-action");
		source.setUsername("jakub");
		source.setPassword("");
		source.setInitialSize(5);
		source.setMaxActive(10);
		return source;
	}

	@Bean
	public JpaVendorAdapter hibernateJpaVendorAdapter() {

		HibernateJpaVendorAdapter jva = new HibernateJpaVendorAdapter();
		jva.setDatabase(org.springframework.orm.jpa.vendor.Database.POSTGRESQL);
		jva.setShowSql(true);
		jva.setGenerateDdl(false);
		jva.setDatabasePlatform(PostgreSQL9Dialect.class.getName());
		return jva;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(localhostDataSource());
		emf.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		emf.setPackagesToScan("norbsoft.sia.part2.domain");
		return emf;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {

		return new PersistenceAnnotationBeanPostProcessor();
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {

		return new PersistenceExceptionTranslationPostProcessor();
	}
}
