package org.visitor_management.visitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.visitor_management.visitor.dto.visitor;
import org.visitor_management.visitor.repository.visitorRepository;

@Service
public class visitorService {

    @Autowired
    visitorRepository repository;

    public ResponseEntity<Object> saveVisitor(visitor visitor) {
        if(repository.existsByslno(visitor.getSlno())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Slno already exists");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }else{
            repository.save(visitor);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record Added Successfully");
            map.put("Data", visitor);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> savevisitors(List<visitor> visitors) {
        for(visitor visitor : visitors){
            if(repository.existsByslno(visitor.getSlno())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Slno already exists");
    
                return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
            }else{
                repository.saveAll(visitors);
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
                map.put("success", "Record Added Successfully");
                map.put("Data", visitors);
    
                return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }
    
}
