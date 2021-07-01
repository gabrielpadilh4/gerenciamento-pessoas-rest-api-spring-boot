package com.github.gabrielpadilh4.personapi.repository;

import com.github.gabrielpadilh4.personapi.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
