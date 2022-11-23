package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employers;

public interface EmployersRepository extends JpaRepository<Employers, Long> {

}
