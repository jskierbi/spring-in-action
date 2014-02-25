package norbsoft.sia.part2.db;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DBConfig {

	/**
	 * Localhost DBCP data source definition (with connection pools)
	 *
	 * @see http://commons.apache.org/proper/commons-dbcp/
	 */
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
	public JdbcTemplate jdbcTemplate() {

		return new JdbcTemplate(localhostDataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {

		return new NamedParameterJdbcTemplate(localhostDataSource());
	}

	@Bean // method name is bean name :)
	public SpitterDAO jdbcSpitterDAO() {

		JdbcSpitterDAO dao = new JdbcSpitterDAO();
		// dao.setJdbcTemplate(jdbcTemplate());
		dao.setDataSource(localhostDataSource()); //now has JdbcTemplate created inside
		return dao;
	}
}
