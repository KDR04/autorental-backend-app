package com.autorentalapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.autorentalapp.models.User;

@Repository
public class UserRepository {

	private String GET_USER_QUERY = "SELECT * FROM RENTALAPP.USER";
	
	private String ADD_USER = "INSERT INTO RENTALAPP.USER(firstname,lastname,email,password,phonenumber,age,drivinglicense) VALUES(?,?,?,?,?,?,?)";
	
	private RowMapper<User>  rowMapper =  new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			user.setId(rs.getInt(1));
			user.setFirstname(rs.getString(2));
			user.setLastname(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setPhonenumber(rs.getString(6));
			user.setAge(rs.getInt(7));
			user.setDrivinglicense(rs.getString(8));
			System.out.println(user.toString());
			return user;
		}
		
	};
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserRepository() {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<User> getAllUsers() {
		System.out.println("repo here");
		return jdbcTemplate.query(GET_USER_QUERY, rowMapper);
	}
	
	public User registerUser(User user) {
		
		
		int executeResult = jdbcTemplate.update(ADD_USER, 
				new Object[] {user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(),
						user.getPhonenumber(),user.getAge(),user.getDrivinglicense()});
		if (executeResult > 0) {
			return user;
		}
		return null;
	}
	
}
