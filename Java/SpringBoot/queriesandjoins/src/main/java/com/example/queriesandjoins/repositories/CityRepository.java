package com.example.queriesandjoins.repositories;

import com.example.queriesandjoins.models.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    List<City> findAll();


    @Query("select ci.name from City ci join ci.country c where c.name = 'Mexico' and ci.population > 500000 order by ci.population desc ")
    List<City> mexicanCities();

    @Query("select c.name,ci.name,ci.district,ci.population from City ci join ci.country c where c.name= 'Argentina' and ci.district = 'Buenos Aires' and ci.population > 500000 ")
    List<Object[]> argentinaBuenosAires();
}
