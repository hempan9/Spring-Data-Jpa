package com.hmp.spring.dao;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hmp.spring.model.Passenger;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
    Iterable<Passenger> deleteByFirstName(String firstName);
    Page<Passenger> findAll(Pageable pageable);

//    @Override
//    @Query("update Passenger p set p.deleted='true' where p.id= :int")
//    void deleteAllById(@PathParam("int") Iterable<? extends Integer> integers);
//    @Override
//    @Query("update Passenger p set p.deleted='true' where p.id= ?1 ")
//    void deleteById( Integer integers);
    @Modifying
@Query("UPDATE Passenger p SET p.deleted = 'true' WHERE p.id in ?1 ")
    void deleteAllById(List<? extends Integer> integers);

    @Modifying
    @Query( "UPDATE Passenger p SET p.deleted = 'true' WHERE p.id in ?1 ")
    void deleteById(Integer id);
    @Modifying
    @Query( "UPDATE Passenger p SET p.deleted = 'true' ")
    void deleteAll();
}


