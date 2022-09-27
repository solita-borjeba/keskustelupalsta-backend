package com.harkka.keskustelupalsta.service;

public class TestResponse {
    private String noImpl;
    private int id;
    private String subject;
    private String message;
    private String aikaleima;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public TestResponse() {
        this.noImpl = "Ei vielä toteutettu";


        /*

        { id: 1, aihe: 'Hello', viestienlkm: 1, aikaleima: '12:00' },
        { id: 2, aihe: 'DataGridPro', viestienlkm: 2, aikaleima: '13:00' },
        { id: 3, aihe: 'MUI', viestienlkm: 1, aikaleima: '12:30' },
      ]

         */
    }

    public String getNoImpl() {
        return noImpl;
    }

    public void setNoImpl(String noImpl) {
        this.noImpl = noImpl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAikaleima() {
        return aikaleima;
    }

    public void setAikaleima(String aikaleima) {
        this.aikaleima = aikaleima;
    }
}
