package com.example.demo.repositories;

import com.example.demo.enums.Continent;
import com.example.demo.enums.Region;
import com.example.demo.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByRegion(Region region);
    List<Country> findByContinent(Continent continent);
}
