package com.smiple.crud.mytest.simplecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class DataDAO {
	
	final static Logger logger = LoggerFactory.getLogger(DataDAO.class);
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.url}")
	String username;
	
	@Value("${spring.datasource.url}")
	String password;
	
	@Value("${spring.datasource.driver}")
	String driverName;

	
	Connection conn;
	PreparedStatement pstmt;
    ResultSet rs;
		
    @SuppressWarnings("finally")
	public boolean create(DataDTO data){
    	
    	boolean result = true;
    	
    	try {
    		Class.forName(driverName);
    		conn = DriverManager.getConnection(url, username, password);
    		
    		String sql = "insert into data(created, name, content) values(now(), ?, ?)"; 
    		pstmt = conn.prepareStatement(sql);
    		
    		pstmt.setString(1, data.name);
    		pstmt.setString(2, data.content);
    		
            rs = pstmt.executeQuery();
            
            
            rs.close();
            pstmt.close();
            conn.close();
    		
    	}  catch (Exception e) {
    		result = false;
    	} finally {
    		return result;
    	}
    }
    
    @SuppressWarnings("finally")
	public boolean update(DataDTO data){
    	boolean result = true;
    	
    	try {
    		Class.forName(driverName);
    		conn = DriverManager.getConnection(url, username, password);
    		
    		String sql = "update data set name = ? , content = ? where id = ?"; 
    		pstmt = conn.prepareStatement(sql);
    		
    		pstmt.setString(1, data.getName());
    		pstmt.setString(2, data.getContent());
    		pstmt.setInt(3, data.getId());
    		
            rs = pstmt.executeQuery();
            
            rs.close();
            pstmt.close();
            conn.close();
    		
    	}  catch (Exception e) {
    		result = false;
    	} finally {
    		return result;
    	}
    }
    
    @SuppressWarnings("finally")
	public boolean delete(Integer id){
    	boolean result = true;
    	
    	try {
    		Class.forName(driverName);
    		conn = DriverManager.getConnection(url, username, password);
    		
    		String sql = "delete from data where id = ?"; 
    		pstmt = conn.prepareStatement(sql);
    		
    		pstmt.setInt(1, id);
    		
            rs = pstmt.executeQuery();
            
            rs.close();
            pstmt.close();
            conn.close();
    		
    	}  catch (Exception e) {
    		result = false;
    	} finally {
    		return result;
    	}
    }
    
    public DataDTO read(Integer id){
    	DataDTO result = new DataDTO();
    	
    	try {
    		Class.forName(driverName);
    		conn = DriverManager.getConnection(url, username, password);
    		
    		String sql = "select id, created, name, content from data where id = ?"; 
    		pstmt = conn.prepareStatement(sql);
    		
    		pstmt.setInt(1, id);
    		
            rs = pstmt.executeQuery();
            
            if(!rs.next()) {
            	result = null;
            } else {
            	result.setId(rs.getInt("id"));
            	result.setCreated(rs.getString("created"));
            	result.setName(rs.getString("name"));
            	result.setContent(rs.getString("content"));
            }
            
            rs.close();
            pstmt.close();
            conn.close();
    		
    	}  catch (Exception e) {
    		logger.error("Exception during retrive data");
    	}
		return result; 
    
    

    }
        
	
	
	
	
	
}
