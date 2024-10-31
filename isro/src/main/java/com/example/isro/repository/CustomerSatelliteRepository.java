package com.example.isro.repository;

import com.example.isro.model.CustomerSatellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerSatelliteRepository extends JpaRepository<CustomerSatellite,String>, JpaSpecificationExecutor<CustomerSatellite> {

}
