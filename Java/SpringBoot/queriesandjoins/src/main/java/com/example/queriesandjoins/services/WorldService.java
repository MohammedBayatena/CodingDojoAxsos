package com.example.queriesandjoins.services;

import com.example.queriesandjoins.models.City;
import com.example.queriesandjoins.models.Country;
import com.example.queriesandjoins.models.Language;
import com.example.queriesandjoins.repositories.CityRepository;
import com.example.queriesandjoins.repositories.CountryRepository;
import com.example.queriesandjoins.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldService {
    private final CountryRepository cRepo;
    private final CityRepository ciRepo;
    private final LanguageRepository lRepo;

    public WorldService(CountryRepository cRepo, CityRepository ciRepo, LanguageRepository lRepo) {
        this.cRepo = cRepo;
        this.ciRepo = ciRepo;
        this.lRepo = lRepo;
    }

    public List<Object[]> getCountriesMon() {
        return this.cRepo.findConMonCountries();
    }

    public List<City> getCities() {
        return this.ciRepo.findAll();
    }

    public List<Language> getLanguages() {
        return this.lRepo.findAll();
    }

    public List<Country> getCountryByName(String name) {
        return this.cRepo.findCountryByName(name);
    }

    public List<Object[]> getCountryByLanguage(String lang) {
        return this.cRepo.findCountryByLang(lang);
    }

    public List<Object[]> getCountryByRegion() {
        return this.cRepo.findCountryByRegion();
    }

    public List<Object[]> getCountriesByCityCount() {
        return this.cRepo.findCountryCityCount();
    }

    public List<Object[]> getCountryLanguagues() {
        return this.lRepo.findCountryLangs();
    }

    public List<City> getMexicanCities() {
        return this.ciRepo.mexicanCities();
    }

    public List<Object[]> getBuenosAiresCities() {
        return this.ciRepo.argentinaBuenosAires();
    }

    public List<Object[]> getsub501() {
        return this.cRepo.findsub501andpop();
    }
}