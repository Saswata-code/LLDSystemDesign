package com.example.isro.repository;

import com.example.isro.model.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RocketRepository extends JpaRepository<Rocket,String> {
}
