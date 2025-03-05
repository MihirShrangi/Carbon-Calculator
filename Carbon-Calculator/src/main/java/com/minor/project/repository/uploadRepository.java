package com.minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minor.project.model.Images;



public interface uploadRepository extends JpaRepository<Images, Integer> {

}
