package com.stackroute.Soulmate.controller;

import com.stackroute.Soulmate.model.Soulmate;
import com.stackroute.Soulmate.service.SoulmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SoulmateController {

    private SoulmateService soulmateService;

    @Autowired
    public SoulmateController(SoulmateService soulmateService) {
        this.soulmateService = soulmateService;
    }

    @PostMapping("/soulmate")
    public ResponseEntity<Soulmate> addProfile(@RequestBody Soulmate soulmate){
        return new ResponseEntity<>(soulmateService.addProfile(soulmate) , HttpStatus.CREATED);
    }

    @DeleteMapping("/soulmate/{id}")
    public ResponseEntity<Soulmate> delProfile(@PathVariable int id){
        return new ResponseEntity<>(soulmateService.deleteProfile(id) , HttpStatus.OK);
    }

    @PutMapping("/soulmate")
    public ResponseEntity<Soulmate> updateProfile(@RequestBody Soulmate soulmate ){
        return new ResponseEntity<>(soulmateService.updateProfile(soulmate) , HttpStatus.OK);
    }

    @GetMapping("/soulmates")
    public ResponseEntity<List<Soulmate>> getAllProfile(){
        return new ResponseEntity<>(soulmateService.getAllProfile() , HttpStatus.OK);
    }

    @GetMapping("/soulmate/{name}")
    public ResponseEntity<Soulmate> getSoulmateByName(@PathVariable String name){
        return new ResponseEntity (soulmateService.listByName(name) , HttpStatus.FOUND);
    }

    @GetMapping("/soulmate/{gender}/{age}")
    public ResponseEntity<Soulmate> getSoulmateByGender(@PathVariable String gender , @PathVariable int age){
        return new ResponseEntity (soulmateService.listByGenderAndAge(gender , age) , HttpStatus.FOUND);
    }
}
