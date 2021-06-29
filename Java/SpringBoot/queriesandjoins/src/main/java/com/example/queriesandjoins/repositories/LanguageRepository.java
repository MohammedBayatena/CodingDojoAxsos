package com.example.queriesandjoins.repositories;

import com.example.queriesandjoins.models.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {

    List<Language> findAll();


    @Query("select c.name,l.language,l.percentage from Language l join l.country c where l.percentage >= 89 order by l.percentage desc")
    List<Object[]> findCountryLangs();

}
