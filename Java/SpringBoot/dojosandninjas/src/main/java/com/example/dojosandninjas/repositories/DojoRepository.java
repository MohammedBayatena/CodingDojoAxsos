package com.example.dojosandninjas.repositories;

import com.example.dojosandninjas.models.Dojo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

    List<Dojo> findAll();

    Optional<Dojo> findById(Long id);

//    @Query(value = "select count(n.id) as count from ninjas n where dojo_id = ?1 order by n.id ", nativeQuery = true)
//    Long nativequery(Long id);

//    @Query(value = "select count(n.id) as count from Ninja n where n.dojo.id = ?1 order by n.id ")
//    Long jpqlquery(Long id);

}