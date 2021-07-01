package com.github.gabrielpadilh4.personapi.repository;

import com.github.gabrielpadilh4.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
