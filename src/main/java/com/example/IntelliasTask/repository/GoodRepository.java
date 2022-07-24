package com.example.IntelliasTask.repository;

import com.example.IntelliasTask.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This JPA class for table "good" in db
 */
@Repository
public interface GoodRepository extends JpaRepository<Good, Integer> {

    /**
     * This method give you list of goods which user bought
     *
     * @param userId if you want take a list of goods which user bought, you must give a id of user
     * @return list of goods
     */
    @Query("select g from Good g left join g.users u where u.id =:userId")
    List<Good> findAllByUserId(Integer userId);
}
