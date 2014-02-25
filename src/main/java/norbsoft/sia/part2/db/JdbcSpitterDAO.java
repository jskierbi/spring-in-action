package norbsoft.sia.part2.db;

import norbsoft.sia.part2.domain.Spitter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcSpitterDAO implements SpitterDAO {

	private static final String SQL_INSERT_SPITTER =
			"insert into spitter (username, password, fullname, email, is_updated_by_email) " +
					"values (:username, :password, :fullname, :email, :is_updated_by_email)";
	private static final String SQL_UPDATE_SPITTER =
			"update spitter set username = ?, password = ?, fullname = ?, email = ?, is_updated_by_email = ? where id = ?";
	private static final String SQL_SELECT_SPITTER =
			"select id, username, password, fullname, email, is_updated_by_email from spitter where id = ?";

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override public void addSpitter(Spitter spitter) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", spitter.getUsername());
		params.put("password", spitter.getPassword());
		params.put("fullname", spitter.getFullName());
		params.put("email", spitter.getEmail());
		params.put("is_updated_by_email", spitter.isUpdatedByEmail());

		KeyHolder key = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(
				SQL_INSERT_SPITTER,
				new MapSqlParameterSource(params),
				key, new String[] {"id"}); // Retrive new key

		spitter.setId(key.getKey().longValue());
	}

	@Override public Spitter getSpitterById(long id) {

		return jdbcTemplate.queryForObject(
				SQL_SELECT_SPITTER,
				new ParameterizedRowMapper<Spitter>() {
					@Override public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {

						Spitter spitter = new Spitter();
						spitter.setId(rs.getLong(1));
						spitter.setUsername(rs.getString(2));
						spitter.setPassword(rs.getString(3));
						spitter.setFullName(rs.getString(4));
						spitter.setEmail(rs.getString(5));
						spitter.setUpdatedByEmail(rs.getBoolean(6));
						return spitter;
					}
				},
				id);
	}

	@Override public void saveSpitter(Spitter spitter) {

	}

	private long queryForIdentity() {

		// POSTGRES specific!
		return jdbcTemplate.queryForObject("select lastval()", null, Long.class);
	}
}
