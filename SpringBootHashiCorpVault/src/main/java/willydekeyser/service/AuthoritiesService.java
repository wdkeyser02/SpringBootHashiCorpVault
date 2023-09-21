package willydekeyser.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import willydekeyser.model.Authorities;

@Service
public class AuthoritiesService {

	private final JdbcTemplate jdbcTemplate;
		
	public AuthoritiesService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Authorities> findAll() {
		var sql = "SELECT id, authority FROM authorities";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	RowMapper<Authorities> rowMapper = (rs, rowNum) -> new Authorities(
			rs.getInt("id"),
			rs.getString("authority"));
}
