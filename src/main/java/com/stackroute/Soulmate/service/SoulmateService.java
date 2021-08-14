package com.stackroute.Soulmate.service;

import com.stackroute.Soulmate.model.Soulmate;

import java.util.List;

public interface SoulmateService {

    public Soulmate addProfile(Soulmate soulmate);

    public Soulmate deleteProfile(int id);

    public Soulmate updateProfile(Soulmate soulmate);

    public List<Soulmate> getAllProfile();

    public List<Soulmate> listByName(String name);

    public List<Soulmate> listByGenderAndAge(String gender , int age);

}
