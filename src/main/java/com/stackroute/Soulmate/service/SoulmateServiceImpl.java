package com.stackroute.Soulmate.service;

import com.stackroute.Soulmate.model.Soulmate;
import com.stackroute.Soulmate.repo.SoulmateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoulmateServiceImpl implements SoulmateService {

    private SoulmateRepo soulmateRepo;
    @Autowired
    public SoulmateServiceImpl(SoulmateRepo soulmateRepo){
        this.soulmateRepo = soulmateRepo;
    }

    @Override
    public Soulmate addProfile(Soulmate soulmate) {
        Soulmate newSoulmate = soulmateRepo.save(soulmate);
        return newSoulmate;
    }

    @Override
    public Soulmate deleteProfile(int id) {
        Soulmate delSoulmate = soulmateRepo.findById(id).get();
        if(delSoulmate!=null){
            soulmateRepo.deleteById(id);
        }
        return delSoulmate;
    }

    @Override
    public Soulmate updateProfile(Soulmate soulmate) {
        Soulmate existSoulmate = soulmateRepo.getById(soulmate.getId());
        if (existSoulmate!=null){
            existSoulmate.setName(soulmate.getName());
            existSoulmate.setGender(soulmate.getGender());
            existSoulmate.setAge(soulmate.getAge());
        }
        return existSoulmate;
    }

    @Override
    public List<Soulmate> getAllProfile() {
        return soulmateRepo.findAll();
    }

    @Override
    public List<Soulmate> listByName(String name) {
        return soulmateRepo.findByName(name);
    }

    @Override
    public List<Soulmate> listByGenderAndAge(String gender, int age) {
        return soulmateRepo.findByGenderAndAge(gender, age);
    }


}
