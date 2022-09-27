package com.harkka.keskustelupalsta.repository;

import com.harkka.keskustelupalsta.model.Subject;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
