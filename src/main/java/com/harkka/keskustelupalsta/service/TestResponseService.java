package com.harkka.keskustelupalsta.service;

import java.util.HashMap;
import java.util.Map;

public class TestResponseService {

    public TestResponse get() {
        return new TestResponse();
    }
/*
    public TestResponse getSubjects() {
        Map<String, TestResponse> subjects = new HashMap<>();

        TestResponse subject = new TestResponse();
        subject.setId(1);
        subject.setSubject("Test response");
        subject.setMessage("Toimiiko");
        subject.setAikaleima("12:30");

        subjects.put("subjects", subject);
        return subjects;
    }

 */
}

