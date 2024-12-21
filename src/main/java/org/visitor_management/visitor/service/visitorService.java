package org.visitor_management.visitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
               
            }
        }
        repository.saveAll(visitors);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "Record Added Successfully");
        map.put("Data", visitors);
    
        return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> fetchAll() {
        List<visitor> visitors = repository.findAll();
        if (visitors.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Data not found in database");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Retrieved Successfully");
            map.put("Data", visitors);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> fetchByName(String name) {
        Optional<visitor> op = repository.findByName(name);
        if (op.isPresent()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Retrieved Successfully");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Data not found with the name : "+name);
            
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> fetchByDate(String date) {
        List<visitor> visitors = repository.findByDate(date);
        if(visitors.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Data not found for the given date : "+date);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Retrieved Successfully");
            map.put("Data", visitors);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> fetchById(int id) {
        Optional<visitor> op = repository.findById(id);
        if(op.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Retrieved Successfully");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Data not found with the id : " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteById(int id) {
        Optional<visitor> op = repository.findById(id);
        if(op.isPresent()){

            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Record Deleted");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Data not found with the id : " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<Object> updateVisitor(visitor visitor) {
        repository.save(visitor);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "Record Updated Successfully");
        map.put("Data", visitor);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    public ResponseEntity<Object> update(int id, visitor visitor) {
        if(repository.findById(id).isPresent()){
            visitor v = repository.findById(id).get();

            if(visitor.getSlno() != 0){
                v.setSlno(visitor.getSlno());
            }

            if(visitor.getName() != null){
                v.setName(visitor.getName());
            }

            if(visitor.getEmail()!= null){
                v.setEmail(visitor.getEmail());
            }

            if(visitor.getPhone() != 0){
                v.setPhone(visitor.getPhone());
            }

            if(visitor.getReason() != null){
                v.setReason(visitor.getReason());
            }

            if(visitor.getToMeet() != null){
                v.setToMeet(visitor.getToMeet());
            }

            if(visitor.getDate() != null){
                v.setDate(visitor.getDate());
            }

            repository.save(v);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record Updated Successfully");
            map.put("Data", v);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Data not found with the id: " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
        }


    }

  
}
