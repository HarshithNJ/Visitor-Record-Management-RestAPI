package org.visitor_management.visitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.visitor_management.visitor.dto.visitor;
import org.visitor_management.visitor.service.visitorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class visitorController {

    @Autowired
    visitorService service;

    @PostMapping("/visitors")
    public ResponseEntity<Object> saveVisitor(@RequestBody visitor visitor) {
        return service.saveVisitor(visitor);
    }
    
    @PostMapping("/visitors/multiple")
    public ResponseEntity<Object> savevisitors(@RequestBody List<visitor> visitors) {
        return service.savevisitors(visitors);
    }
    
}
