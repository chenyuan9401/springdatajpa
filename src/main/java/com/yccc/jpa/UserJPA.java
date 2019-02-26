package com.yccc.jpa;

import com.yccc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, Serializable {

}
