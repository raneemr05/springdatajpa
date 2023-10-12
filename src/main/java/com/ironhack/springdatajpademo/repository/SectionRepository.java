package com.ironhack.springdatajpademo.repository;

import com.ironhack.springdatajpademo.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
}
