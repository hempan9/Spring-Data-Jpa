package com.hmp.spring.service;
import com.hmp.spring.dao.PassengerRepository;
import com.hmp.spring.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    public PassengerService(PassengerRepository repository){
        this.repository= repository;
    }
    PassengerRepository repository;

    public Page<Passenger> pageByALl(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void deleteSoftDelete(List<Integer> ids) {
        repository.deleteAllById(ids);
    }

    public void deleteSoftDelete(Integer id) {
        repository.deleteById(id);

    }
    public void deleteSoftDelete( ) {
        repository.deleteAll();

    }
}
