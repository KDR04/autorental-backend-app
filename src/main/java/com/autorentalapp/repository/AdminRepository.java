package com.autorentalapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.autorentalapp.models.Admins;

@Repository
public class AdminRepository {
	
	private String GET_ADMIN_QUERY ="SELECT * FROM RENTALAPP.ADMINS";
	
	private RowMapper<Admins>  rowMapper =  new RowMapper<Admins>() {

		@Override
		public Admins mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Admins admin = new Admins();
			admin.setId(rs.getInt(1));
			admin.setUsername(rs.getString(2));
			admin.setPassword(rs.getString(3));
			System.out.println(admin.toString());
			return admin;
		}
		
	};
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AdminRepository(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Admins> getAllAdmins() {
		System.out.println("repo here");
		return jdbcTemplate.query(GET_ADMIN_QUERY, rowMapper);
	}
	
}
