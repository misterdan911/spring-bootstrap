package com.myspring.bootstrap.repository;

import com.myspring.bootstrap.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

    // Method 1: Using Derived Query (contains equivalent to LIKE %word%)
    // List<User> findByNameContaining(String keyword);

    // Method 2: Custom Query (if needed for more flexibility)
    // @Query("SELECT u FROM User u WHERE u.name LIKE %:keyword%")
    // List<User> searchByName(@Param("keyword") String keyword);
}