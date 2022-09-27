package com.harkka.keskustelupalsta.service;

import com.harkka.keskustelupalsta.repository.SubjectRepository;
import com.harkka.keskustelupalsta.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.harkka.keskustelupalsta.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectService {

//    @Autowired
//    SubjectRepository subjectRepository;

    public ResponseEntity<Object> createSubject(Subject newSubject, SubjectRepository subjectRepository) {

        try {
            System.out.println("New subject is saved to DB.");
            return ResponseHandler.generateResponse("New subject has been saved.",
                    HttpStatus.CREATED, subjectRepository.save(new Subject(newSubject.getSubjectname(), newSubject.getMessage())));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Some failure happened in the saving new subject.",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

    public ResponseEntity<Object> getSubjects(SubjectRepository subjectRepository) {

        try {
            System.out.println("Saved subjects are retrieved from DB.");
            return ResponseHandler.generateResponse("Subjects are.",
                    HttpStatus.MULTI_STATUS, subjectRepository.findAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Some failure happened in the gettting subjects.",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

    public ResponseEntity<Object> updateSubject(long id, Subject subject, SubjectRepository subjectRepository) {

        try {
            System.out.println("Subject is updated from DB.");
            Optional<Subject> subjectData = subjectRepository.findById(id);
            Subject tmpSubject = subjectData.get();

            if (subjectData.isPresent()) {
                if(subject.getSubjectname() != null && !subject.getSubjectname().isEmpty()) {
                    tmpSubject.setSubjectname(subject.getSubjectname());
                }
                if (subject.getMessage() != null && !subject.getMessage().isBlank()) {
                    tmpSubject.setMessage(subject.getMessage());
                }
            }
            return ResponseHandler.generateResponse("Subject has been updated.",
                    HttpStatus.OK, subjectRepository.save(tmpSubject));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Some failure happened in the updating subject.",
                    HttpStatus.NOT_FOUND, null);
        }

    }

    public ResponseEntity<Object> deleteSubject(long id, SubjectRepository subjectRepository) {

        try {
            System.out.println("Subject is deleted from DB.");
            subjectRepository.deleteById(id);

            return ResponseHandler.generateResponse("Subject has been deleted.",
                    HttpStatus.NO_CONTENT, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Some failure happened in the updating subject.",
                    HttpStatus.NOT_FOUND, null);
        }
    }

}
