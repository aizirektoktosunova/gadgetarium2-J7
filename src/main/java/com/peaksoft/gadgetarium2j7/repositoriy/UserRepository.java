package com.peaksoft.gadgetarium2j7.repositoriy;

import com.peaksoft.gadgetarium2j7.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}