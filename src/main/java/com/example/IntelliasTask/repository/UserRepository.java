package com.example.IntelliasTask.repository;

import com.example.IntelliasTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This JPA class for table "user" in db
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * This method give you list of users, who bought good with id = goodId
     *
     * @param goodId id of good which you want see
     * @return list of users who take this good
     */
    @Query("select u from User u left join u.goods g where g.id =:goodId")
    List<User> findAllByGoodId(Integer goodId);
}
