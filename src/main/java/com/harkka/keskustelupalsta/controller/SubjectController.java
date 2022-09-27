package com.harkka.keskustelupalsta.controller;

import com.harkka.keskustelupalsta.model.Subject;
import com.harkka.keskustelupalsta.repository.SubjectRepository;
import com.harkka.keskustelupalsta.response.ResponseHandler;
import com.harkka.keskustelupalsta.service.SubjectService;
import com.harkka.keskustelupalsta.service.TestResponse;
import com.harkka.keskustelupalsta.service.TestResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class SubjectController {

    private final SubjectService service;
    TestResponseService trs;
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectController() {
        this.service = new SubjectService();
    }


    @PostMapping("/createSubject")  //BB korjaa Postiksi
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> createSubject(@RequestBody Subject subject) {

        try {
            System.out.println("Create new subject." + subject.getSubjectname() + " " + subject.getMessage());
            return service.createSubject(subject, subjectRepository);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseHandler.generateResponse("Create Subject ctrl", HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/getSubjects")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getSubjects() {

        try {
            System.out.println("Get subjects.");
            return service.getSubjects(subjectRepository);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseHandler.generateResponse("Get Subjects ctrl", HttpStatus.MULTI_STATUS, null);
        }
    }


    @PutMapping("/updateSubject/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> updateSubject(@PathVariable("id") long id, @RequestBody Subject subject) {

        try {
            System.out.println("Update subjects." + subject.getSubjectname() + " " + subject.getMessage());
            return service.updateSubject(id, subject, subjectRepository);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Update Subject ctrl", HttpStatus.MULTI_STATUS, null);
        }

    }

    @DeleteMapping("/deleteSubject/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> deleteSubject(@PathVariable("id") long id) {

        try {
            System.out.println("Perille tuli Delete.");
            return service.deleteSubject(id, subjectRepository);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Nou work", HttpStatus.MULTI_STATUS, null);
        }
    }
}
