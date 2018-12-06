package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;

import java.util.List;

public interface DistilleryRepositoryCustom {

    public List<Distillery> getDistilleryByRegion(String region);

    public List<Distillery> getDistilleryByWhiskyAge(int age);

    public List<Distillery> getDistilleriesForWhiskyAge(int age);
}
