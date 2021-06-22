package com.example.demo;

import com.example.demo.repos.CampusRepository;
import org.springframework.stereotype.Service;

@Service
public class CampusStorage {

    private CampusRepository campusRepo;

    public CampusStorage(CampusRepository campusRepo) {
        this.campusRepo = campusRepo;
    }



// not neccessary, for adding "business logic"

    public Campus retrieveCampusByName(String name) {
        Iterable<Campus> campuses = campusRepo.findAll();
        for (Campus campus: campuses) {
            if (campus.getName().contains(name)) {
                return campus;
            }
        }
        return null;
    }

    public Campus retrieveCampusById(Long id) {
        return campusRepo.findById(id).get();
    }

    public void deleteCampusById(Long id) {
        campusRepo.deleteById(id);
    }

    public void saveCampus(Campus campusToAdd) {
        campusRepo.save(campusToAdd);
    }

    public Iterable<Campus> retrieveAllCampuses() {
        return campusRepo.findAll();
    }
}
