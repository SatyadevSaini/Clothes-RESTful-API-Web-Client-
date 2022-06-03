package com.incapp.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Clothes;

@Repository
public class ClothesRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// add Clothes ...
	
	public String addClothes(Clothes c , MultipartFile image) {
		
		try {
			String query = "insert into cloth values(?,?,?,?,?)";
			
			int result = jdbcTemplate.update(query , new Object[] {c.getId(), c.getName() , c.getPrice() , c.getBrand() , image.getInputStream()});
			
			if(result!=0) {
				return"t";
			}
			else {
				return"f";
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			return"f";
		}
		
	}
	
	
	// get All Clothes 
	
   public	List<Clothes>  getAllClothes(){
	   
	   class DataMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Clothes c = new Clothes();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setPrice(rs.getInt("price"));
			c.setBrand(rs.getString("brand"));
		
			return c;
		} 
	   }
	   try {
		   
		   String query = "Select * from cloth";
		   List<Clothes> data = jdbcTemplate.query(query,new DataMapper());
		   return data;
		   
	} catch (Exception e) {
		e.printStackTrace();
		
		return null;
	}   
   }
   
   
   
   // get All Stuudent's Id 
   
  public List<Integer> getClothesId(){
	  class DataMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getInt("id");
		}  
	  }
	  
	  
	  try {
		String query = "select id from cloth";
		List<Integer> id = jdbcTemplate.query(query, new DataMapper());
		
		return id;
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	  
  }
  
 
//get All Clothesname like 
	
  public List<Clothes>  getAllClothesByName(String name){
	   
	   class DataMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Clothes c = new Clothes();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setPrice(rs.getInt("price"));
			c.setBrand(rs.getString("brand"));
		
			return c;
			
		} 
	   }
	   
	   try {
		   String query = "Select * from cloth where name like ?";
		   List<Clothes> data = jdbcTemplate.query(query , new DataMapper() , new Object[] {"%"+name+"%"});
		   return data;
		   
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}   
  }
  
  
  
  
  
  
  
  //delete Clothes
  
  public String deleteClothes(int id ) {
	  try {
		  String query = "delete from cloth where id=?";
		  int x = jdbcTemplate.update(query ,new Object[] {id}  );
		  
		  if(x==0) {
				return"false";
			}
			else {
				return"true";
			}
	} catch (Exception e) {
		e.printStackTrace();
		return"false";
	}  
  }
  
  
  
   public String updateClothes(Clothes c ,int id ) {
	   
	   try {
		   String query = "update cloth set id =? , name=? , price=? , brand=? where id =?";
		   int x = jdbcTemplate.update(query , new Object[] {c.getId(), c.getName() , c.getPrice() , c.getBrand() , id });
				
		   if(x==0) {
				return"f";
			}
			else {
				return"t";
			}
		   
	} catch (Exception e) {
		e.printStackTrace();
		return"f";
	}
	   
	   
   }
   
   
   // get image 
   public  byte[] getImage(int id) {
	   
	   class DataMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return rs.getBytes("image");
		}   
	   }
	   
	   try {   
		final   String query = "select * from cloth where id= ?";
		
		byte [] b = (byte[]) jdbcTemplate.queryForObject(query, new DataMapper() , new Object[] {id} );
		return b;
		     
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return null;
	   
   }
   
   
   
   
   //update image 
   
   public String updateImage(int id  , MultipartFile image) {
	   
	   try {
		   String query = "update cloth set image=? where id=?";
		   
		   int x = jdbcTemplate.update(query , new Object[] { image.getInputStream() , id });
		   
		   if (x!=0) {
			   return "t";
		   }else {
			return "f";
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return "f";
	}    
 }
   
   
   
   // update  Furniture with Image ... 
   
   
  
  
  
  
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
