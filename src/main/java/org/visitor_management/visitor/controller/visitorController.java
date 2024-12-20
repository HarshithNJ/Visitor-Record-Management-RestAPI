package org.visitor_management.visitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.visitor_management.visitor.dto.visitor;
import org.visitor_management.visitor.service.visitorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class visitorController {

    @Autowired
    visitorService service;

    /*Saving Visitors*/
    //To Save Single Visitor
    @PostMapping("/visitors")
    public ResponseEntity<Object> saveVisitor(@RequestBody visitor visitor) {
        return service.saveVisitor(visitor);
    }
    
    //To Save Multiple Visitors
    @PostMapping("/visitors/multiple")
    public ResponseEntity<Object> savevisitors(@RequestBody List<visitor> visitors) {
        return service.savevisitors(visitors);
    }
    




    /*Fetching Visitors*/
    //To Fetch All Visitors
    @GetMapping("/visitors")
    public ResponseEntity<Object> fetchAll() {
        return service.fetchAll();
    }
    
    //To Fetch Visitor By Name
    @GetMapping("/visitors/{name}")
    public ResponseEntity<Object> fetchByName(@PathVariable String name) {
        return service.fetchByName(name);
    }
    
    //To Fetch Visitor By Date
    @GetMapping("/visitors/date/{date}")
    public ResponseEntity<Object> fetchByDate(@PathVariable String date) {
        return service.fetchByDate(date);
    }
    
    //To Fetch Visitor By Id
    @GetMapping("/visitors/visit/id/{id}")
    public ResponseEntity<Object> fetchById(@PathVariable int id) {
        return service.fetchById(id);
    }
    

    /*Deleting Visitor Value */
    //To Delete Visitor By Id
    @DeleteMapping("/visitors/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        return service.deleteById(id);
    }




    /*Updating Visitors Value*/
    //To Update Visitor Record By Using Put Mapping
    @PutMapping("/visitors")
    public ResponseEntity<Object> updateVisitor(@RequestBody visitor visitor) {
        return service.updateVisitor(visitor);
    }

    //To Update Visitor Record By Using Patch Mapping
    @PatchMapping("/visitors/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody visitor visitor) {
        return service.update(id, visitor);
    }
}
