package com.course.project.carservice.repository;

import com.course.project.carservice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
