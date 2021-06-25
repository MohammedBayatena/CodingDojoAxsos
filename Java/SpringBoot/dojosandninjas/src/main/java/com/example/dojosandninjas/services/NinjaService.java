package com.example.dojosandninjas.services;


import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepo;

    public NinjaService(NinjaRepository ninjaRepo) {
        this.ninjaRepo = ninjaRepo;
    }


    public Ninja createNinja(Ninja n) {

        ninjaRepo.save(n);
        return n;

    }


}
