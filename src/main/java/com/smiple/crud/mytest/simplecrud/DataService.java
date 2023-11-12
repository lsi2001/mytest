package com.smiple.crud.mytest.simplecrud;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DataService {
	
	DataDAO dataDAO = new DataDAO();

	@Async
	public boolean create(DataDTO data){
		return dataDAO.create(data);
	}

	@Async
	@CachePut(value = "data", key = "#id")
	public boolean update(DataDTO data){
		return dataDAO.update(data);
	}

	@Async
	@CachePut(value = "data", key = "#id")
	public boolean delete(Integer id){
		return dataDAO.delete(id);
	}

	@Cacheable(value = "data", key = "#id")
	public DataDTO read(Integer id){
		return dataDAO.read(id);
	}

	   
}
