package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    private BookStorage bookStorage;
    private CampusStorage campusStorage;

    public Populator(BookStorage bookStorage, CampusStorage campusStorage){
        this.bookStorage = bookStorage;
        this.campusStorage = campusStorage;
    }


    @Override
    public void run(String... args) throws Exception {
        Campus miamiCampus = new Campus("Miami","We got some good books!");
        Campus lakelandCampus = new Campus("Lakeland","We got some good books!");
        Campus bocaCampus = new Campus("Boca","We got some good books!");
        Book sampleBook = new Book("Miami Livin","Rick Ross",
                "https://media.timeout.com/images/105695117/630/472/image.jpg",
                "Book about life in Miami",miamiCampus);

        Book otherSampleBook = new Book("Master & Apprentice","Claudia Gray",
                "https://images-na.ssl-images-amazon.com/images/I/919Z+udTaLL.jpg",
                "Cool Star Wars Story", miamiCampus);

        Book otherOtherSampleBook = new Book("Of Mice and Men","Steinbeck",
                "https://upload.wikimedia.org/wikipedia/commons/a/a8/Of_Mice_and_Men_%281937_1st_ed_dust_jacket%29.jpg",
                "Lennie kills a rabbit", miamiCampus);

        campusStorage.saveCampus(miamiCampus);
        campusStorage.saveCampus(lakelandCampus);
        campusStorage.saveCampus(bocaCampus);

        bookStorage.saveBook(otherOtherSampleBook);
        bookStorage.saveBook(sampleBook);
        bookStorage.saveBook(otherSampleBook);

    }
}
