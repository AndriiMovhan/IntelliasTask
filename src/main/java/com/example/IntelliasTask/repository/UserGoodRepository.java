package com.example.IntelliasTask.repository;

import com.example.IntelliasTask.model.UserGood;
import com.example.IntelliasTask.model.UserGoodId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This JPA class for table "user_good" in db
 */
@Repository
public interface UserGoodRepository extends JpaRepository<UserGood, UserGoodId> {
}
