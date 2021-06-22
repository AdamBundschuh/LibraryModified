package com.example.demo;

import com.example.demo.repos.BookRepository;
import com.example.demo.repos.CampusRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private CampusRepository campusRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private TestEntityManager testEnMan;

    @Test
    public void checkCampusCanHasManyBooksAndOnlyOneCampus(){
        Campus testCampus = new Campus();
        campusRepo.save(testCampus);

        Book testBook = new Book("Title1","Author1","X1","Description1",testCampus);
        Book testBook2 = new Book("Title2","Author2","X2","Description2",testCampus);
        bookRepo.save(testBook);
        bookRepo.save(testBook2);

        testEnMan.flush();
        testEnMan.clear();

        Campus retrievedCampus = campusRepo.findById(testCampus.getId()).get();

        assertThat(retrievedCampus.getBooks()).contains(testBook,testBook2);
    }
}
