package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class CampusController {
    private CampusStorage campusStorage;

    public CampusController(CampusStorage campusStorage){
        this.campusStorage = campusStorage;
    }

    @RequestMapping("/campuses")
    public String displayAllCampuses(Model model){

        Iterable<Campus> allCampuses = campusStorage.retrieveAllCampuses();
        model.addAttribute("campuses", allCampuses);

        return "all-campus";
    }

    @RequestMapping("/campuses/{name}")
    public String displaySingleCampus(Model model, @PathVariable String name) {

        Campus campus = campusStorage.retrieveCampusByName(name);
        model.addAttribute("campus",campus);
        return "single-campus";

    }
}
