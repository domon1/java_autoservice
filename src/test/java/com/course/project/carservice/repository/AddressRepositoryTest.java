package com.course.project.carservice.repository;

import com.course.project.carservice.IntegrationTestBase;
import com.course.project.carservice.domain.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressRepositoryTest extends IntegrationTestBase {
    /*@Autowired
    private AddressRepository addressRepository;

    public static final Long ADDRESS_ID = 1L;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindById(){
        Optional<Address> address = addressRepository.findById(ADDRESS_ID);
        assertTrue(address.isPresent());
        address.ifPresent( entity -> {
            assertEquals("Leninskaya", entity.getStreet());
            assertEquals("23", entity.getHouse());
        });
    }

    @Test
    void testSave(){
        Address address = Address.builder()
                .street("Shkolnaya")
                .house("16A")
                .build();
        addressRepository.save(address);
        assertNotNull(address.getId());
    }*/
}