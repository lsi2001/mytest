package com.smiple.crud.mytest.simplecrud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
 
@RestController
public class SimpleCRUD {
	
	@Autowired
	DataService dataService;
 
    final static Logger logger = LoggerFactory.getLogger(SimpleCRUD.class);
    
    
    @ApiOperation(value="등록", notes="등록")
    @PostMapping("/data")
    @RequestMapping(value="/data", method={ RequestMethod.POST})
    public ResponseEntity create(@RequestBody DataDTO data) throws Exception {

        if(dataService.create(data)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @ApiOperation(value="조회", notes="조회")
    @GetMapping("/data/{id}")
    @RequestMapping(value="/data/{id}", method={ RequestMethod.GET})
    public ResponseEntity<DataDTO> read(@PathVariable Integer id) throws Exception {

        DataDTO ret = dataService.read(id);
        return new ResponseEntity<DataDTO>(ret, HttpStatus.OK);
    }
    
    @ApiOperation(value="수정", notes="수정")
    @PutMapping("/data/{id}")
    @RequestMapping(value="/data", method={ RequestMethod.PUT})
    public ResponseEntity update(@RequestBody DataDTO data ) throws Exception {
    	
    	if(dataService.update(data)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}

    }
    
    @ApiOperation(value="삭제", notes="삭제")
    @DeleteMapping("/data/{id}")
    @RequestMapping(value="/data/{id}", method={ RequestMethod.DELETE})
    public ResponseEntity delete(@PathVariable Integer id) throws Exception {
    	if(dataService.delete(id)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
}