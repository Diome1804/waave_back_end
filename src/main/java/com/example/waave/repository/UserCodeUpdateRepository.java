package com.example.waave.repository;

import com.example.waave.model.UserCodeUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCodeUpdateRepository extends JpaRepository<UserCodeUpdate, Long> {
}