package com.minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.minor.project.model.UserpayDtls;

public interface UserPayRepository extends JpaRepository<UserpayDtls, Integer>  {

}
