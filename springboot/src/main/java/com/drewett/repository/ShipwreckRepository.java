package com.drewett.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drewett.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long>{
	

}
