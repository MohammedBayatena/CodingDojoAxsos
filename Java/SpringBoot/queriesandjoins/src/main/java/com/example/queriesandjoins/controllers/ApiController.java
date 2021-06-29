package com.example.queriesandjoins.controllers;

import java.util.List;

import com.example.queriesandjoins.models.City;
import com.example.queriesandjoins.models.Country;
import com.example.queriesandjoins.models.Language;
import com.example.queriesandjoins.services.WorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final WorldService wService;

    public ApiController(WorldService wService) {
        this.wService = wService;
    }

    @GetMapping("/ConstitutionalMonarchy")
    public List<Object[]> Index() {
        return this.wService.getCountriesMon();
    }

    @GetMapping("/n/{name}")
    public List<Object[]> CountryByName(@PathVariable("name") String name) {
        return this.wService.getCountryByLanguage(name);
    }

    @GetMapping("/n/cityCount")
    public List<Object[]> CountryByCityCount() {
        return this.wService.getCountriesByCityCount();
    }

    @GetMapping("/n/region")
    public List<Object[]> CountryByRegion() {
        return this.wService.getCountryByRegion();
    }

    @GetMapping("/c")
    public List<City> Cities() {
        return this.wService.getCities();
    }

    @GetMapping("/c/mexico")
    public List<City> MexicanCities() {
        return this.wService.getMexicanCities();
    }

    @GetMapping("/c/arg")
    public List<Object[]> BACities() {
        return this.wService.getBuenosAiresCities();
    }

    @GetMapping("/l")
    public List<Language> Languages() {
        return this.wService.getLanguages();
    }

    @GetMapping("/l/c")
    public List<Object[]> CountryLangs() {
        return this.wService.getCountryLanguagues();
    }

    @GetMapping("/sub501pop100k")
    public List<Object[]> sub501() {
        return this.wService.getsub501();
    }

}