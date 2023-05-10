package com.summercampquest.campquest.controllers;


<<<<<<< HEAD
import com.summercampquest.campquest.data.CampRepository;
import com.summercampquest.campquest.data.models.Camp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

=======
import com.summercampquest.campquest.models.Camp;
import com.summercampquest.campquest.service.CampData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> Saran
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/camps")
public class CampController {

    @Autowired
<<<<<<< HEAD
    private CampRepository campRepository;

    //Camp details display
    @GetMapping("view/{id}")
    public ResponseEntity<Camp> displayViewCampDetail(@PathVariable int campId) {
        Optional<Camp> camp = campRepository.findById(campId);
=======
    private CampData campData;

    @GetMapping
    public ResponseEntity<List<Camp>> displayCamps() {
        List<Camp> camp = campData.displayCamps();
        System.out.println(camp);

//                orElseThrow(()->new ResourceNotFoundException("Camp details not present "+campId));
        return new ResponseEntity<>(camp, HttpStatus.OK);
    }

    //Camp details display
    @GetMapping("/{id}")
    public ResponseEntity<Camp> displayViewId(@PathVariable("id") Integer campId) {
        Optional<Camp> camp = campData.displayCampById(campId);
>>>>>>> Saran
//                orElseThrow(()->new ResourceNotFoundException("Camp details not present "+campId));
        return new ResponseEntity<>(camp.get(), HttpStatus.OK);
    }

//    @GetMapping("view/{campId}")
//    public String displayViewCampdetail(Model model, @PathVariable int campId) {
//
//        Optional optCamp = campRespository.findById(campId);
//        if (optCamp.isPresent()) {
//            Camp camp = (Camp) optcamp.get();
//            model.addAttribute("camp", camp);
//            return "camp/view";
//        } else {
//            return "redirect:../";
//        }

//    }


}
