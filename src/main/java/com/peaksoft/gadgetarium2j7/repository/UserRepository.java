package com.peaksoft.gadgetarium2j7.repository;

import com.peaksoft.gadgetarium2j7.model.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select user from User user where user.email=:email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE upper(u.firstName) like concat('%',:text,'%') or " +
            "upper(u.lastName) like concat('%',:text,'%') or upper(u.email) like concat('%',:text,'%') ")
    List<User> searchAndPagination(@Param("text") String text, Pageable pageable);
}