package com.harkka.keskustelupalsta;

import com.harkka.keskustelupalsta.controller.SubjectController;
import com.harkka.keskustelupalsta.model.Subject;
import com.harkka.keskustelupalsta.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;


@SpringBootTest
class KeskustelupalstaBackendApplicationTests {

	@Autowired
	SubjectRepository subjectRepository;

	@Test
	void contextLoads() {
		assertThat(subjectRepository).isNotNull();
	}

	// DB testejä
	@Test
	void createSubject() {
		Subject newSubject = new Subject("Subjectname : Test1", "Message : Messu1");
		Subject savedSubject = subjectRepository.save(newSubject);

		System.out.printf("ID : %d\n", savedSubject.getId());
		System.out.printf("%s\n", savedSubject.getSubjectname());
		System.out.printf("%s\n", savedSubject.getMessage());
	}

	@Test
	void getSubjects() {
		List<Subject> subjects = (List<Subject>) subjectRepository.findAll();

		System.out.printf("ID : %d\n", subjects.get(0).getId());
		System.out.printf("Subject name : %s\n", subjects.get(0).getSubjectname());
		System.out.printf("Message : %s\n", subjects.get(0).getMessage());
	}

	@Test
	void updateSubject() {
// vaihtoehto 1 :		Optional<Subject> subjectDB = subjectRepository.findById(21L);
		List<Subject> subjects = (List<Subject>) subjectRepository.findAll();

		Subject updateSubject = subjects.get(0);
		System.out.printf("ID : %d\n", updateSubject.getId());
		System.out.printf("Subject name : %s\n", updateSubject.getSubjectname());
		System.out.printf("Message : %s\n", updateSubject.getMessage());

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		updateSubject.setMessage("Päivitetty " + timeStamp);
		subjectRepository.save(updateSubject);

		Optional<Subject> updatedSubject = subjectRepository.findById(updateSubject.getId());
		System.out.printf("ID : %d\n", updatedSubject.get().getId());
		System.out.printf("Subject name : %s\n", updatedSubject.get().getSubjectname());
		System.out.printf("Message : %s\n", updatedSubject.get().getMessage());

	}

	@Test
	void deleteSubject() {
		List<Subject> subjects = (List<Subject>) subjectRepository.findAll();
		//subjectRepository.deleteById(33L);
		Subject deleteSubject = subjects.get(0);
		System.out.printf("ID : %d\n", deleteSubject.getId());
		System.out.printf("Subject name : %s\n", deleteSubject.getSubjectname());
		System.out.printf("Message : %s\n", deleteSubject.getMessage());

		subjectRepository.delete(deleteSubject);

		Optional<Subject> deletedSubject = subjectRepository.findById(deleteSubject.getId());
		System.out.printf("Whole subject has been deleted : %b", deletedSubject.isEmpty());
	}

}
