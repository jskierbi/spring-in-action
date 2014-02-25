package norbsoft.sia.part2.db;

import norbsoft.sia.part2.domain.Spitter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcSpitterDAO extends JdbcDaoSupport implements SpitterDAO {

	private static final String SQL_INSERT_SPITTER =
			"insert into spitter (username, password, fullname, email, is_updated_by_email) " +
					"values (?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_SPITTER =
			"update spitter set username = ?, password = ?, fullname = ?, email = ?, is_updated_by_email = ? where id = ?";
	private static final String SQL_SELECT_SPITTER =
			"select id, username, password, fullname, email, is_updated_by_email from spitter where id = ?";

	@Override public void addSpitter(final Spitter spitter) {

		// update via PreparedStatementCreator and retreive inserted key
		KeyHolder key = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement ps = con.prepareStatement(SQL_INSERT_SPITTER, new String[]{"id"});
				ps.setString(1, spitter.getUsername());
				ps.setString(2, spitter.getPassword());
				ps.setString(3, spitter.getFullName());
				ps.setString(4, spitter.getEmail());
				ps.setBoolean(5, spitter.isUpdatedByEmail());
				return ps;
			}
		}, key);

		spitter.setId(key.getKey().longValue());
	}

	@Override public Spitter getSpitterById(long id) {

		return getJdbcTemplate().queryForObject(
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
}
