package com.minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.minor.project.model.UserfeedbackDtls;

public interface UserFeedbackRepository extends JpaRepository<UserfeedbackDtls, Integer>{

}
