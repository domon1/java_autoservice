package com.course.project.carservice.service;

import com.course.project.carservice.domain.Address;
import com.course.project.carservice.repository.AddressRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public List<Address> findAll(){
        return addressRepo.findAll();
    }

    public void save(Address address){
        addressRepo.save(address);
    }

    public void delete(Address address){
        addressRepo.delete(address);
    }
}
