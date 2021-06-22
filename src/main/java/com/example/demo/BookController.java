package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    //1. Providing mapping for methods
    //2. Find the data for the view to display
    //3. Add the data to the model object
    //4. Select the template to be displayed

    private BookStorage bookStorage;

    public BookController(BookStorage bookStorage){
        this.bookStorage = bookStorage;
    }

    @RequestMapping("/books/{title}")
    public String displaySingleBook(Model model, @PathVariable String title){

        Book bookToDisplay = bookStorage.retrieveBookByTitle(title);

        model.addAttribute("book", bookToDisplay);

        return "single-book";
    }

//    @RequestMapping("/books/{id}")
//    public String displaySingleBook(Model model, @PathVariable Long id){
//
//        Book bookToDisplay = bookStorage.retrieveBookByID(id);
//
//        model.addAttribute("book", bookToDisplay);
//
//        return "single-book";
//    }
}
