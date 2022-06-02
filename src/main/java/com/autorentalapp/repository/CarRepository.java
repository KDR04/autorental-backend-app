package com.autorentalapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.autorentalapp.models.Car;
import com.autorentalapp.models.CarStock;


@Repository
public class CarRepository {
	
	private String ADD_CAR = "INSERT INTO RENTALAPP.CAR(modelno,carmaker,color,registration) VALUES(?,?,?,?) RETURNING *";
	private String ADD_STOCK = "INSERT INTO RENTALAPP.CARSTOCK(available,carid) VALUES(?,?)";
	


	private RowMapper<Car>  carRowMapper =  new RowMapper<Car>() {
		
		@Override
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Car car = new Car();
			car.setCid(rs.getInt(1));
			car.setModelNo((rs.getString(2)));   
			car.setCarmaker(rs.getString(3));
			car.setColor(rs.getString(4));
			car.setRegistration(rs.getString(5));
//			car.setImage(rs.getString(6));
			return car;
		}
		
	};
	
	private RowMapper<CarStock> carStockRowMapper = new RowMapper<CarStock>() {
		
		@Override
		public CarStock mapRow(ResultSet rs, int rowNum) throws SQLException{
			CarStock carStock = new CarStock();
			carStock.setId(rs.getInt(1));
			carStock.setAvailable(rs.getBoolean(2));
			carStock.setCid(rs.getInt(3));
			System.out.println(carStock.toString());
			return carStock;
		}
		
	};
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CarRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public Car registerCar(Car car) {
		
		
		@SuppressWarnings("deprecation")
		Car cr = jdbcTemplate.queryForObject(ADD_CAR, 
				new Object[] {car.getModelNo(),car.getCarmaker(),car.getColor(),car.getRegistration()}, carRowMapper);
		
		System.out.println(cr.toString());
		
		CarStock carStock = new CarStock();

		jdbcTemplate.update(ADD_STOCK, 
				new Object[] {carStock.isAvailable(),cr.getCid()});
			
		
		return cr;
	}	
	
}
