package com.example.queriesandjoins.repositories;

import com.example.queriesandjoins.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    @Query("select c.name from Country c join c.languages l where ?1 in (l.language) order by l.percentage desc ")
    List<Object[]> findCountryByLang(String lang);

    @Query("select c from Country c where c.name = ?1")
    List<Country> findCountryByName(String name);

    @Query("select c.name, count (c.id) as cnt from Country c group by c.region order by cnt desc ")
    List<Object[]> findCountryByRegion();

    @Query("select c.name , count(ci) as cnt from Country c join c.cities ci group by c.name order by cnt desc ")
    List<Object[]> findCountryCityCount();

    @Query("select c.name from Country c  where c.governmentForm = 'Constitutional Monarchy' ")
    List<Object[]> findConMonCountries();

    @Query("select c.name from Country c where c.population > 100000 and c.surfaceArea < 501")
    List<Object[]> findsub501andpop();
}
