package norbsoft.sia.part2.db;

import norbsoft.sia.part2.domain.Spitter;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcSpitterDAO implements SpitterDAO {

	private static final String SQL_INSERT_SPITTER =
			"insert into spitter (username, password, fullname) values (?, ?, ?)";
	private static final String SQL_UPDATE_SPITTER =
			"update spitter set username = ?, password = ?, fullname = ? where id = ?";
	private static final String SQL_SELECT_SPITTER =
			"select id, username, fullname from spitter where id = ?";

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	@Override public void addSpitter(Spitter spitter) {

	}

	@Override public Spitter getSpitterById(long id) {

		return null;
	}

	@Override public void saveSpitter(Spitter spitter) {

	}
}
