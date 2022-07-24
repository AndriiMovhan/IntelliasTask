package com.example.IntelliasTask.service;


import com.example.IntelliasTask.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * This method show you all list of users
     *
     * @return DTO of this users
     */
    List<UserDto> findAll();

    /**
     * This method show you user number id
     *
     * @param id you indicate which user you want
     * @return DTO of this user
     */
    List<UserDto> findById(Integer id);

    /**
     * This method create and save user which you provide
     *
     * @param userDto user which you provide
     * @return DTO of this user
     */
    UserDto save(UserDto userDto);

    /**
     * This method update user first name or some else field
     *
     * @param userDto with changes
     * @return update UserDto
     */
    UserDto update(UserDto userDto);

    /**
     * This method delete one user witch you choose
     *
     * @param id of user witch you want delete
     */
    void deleteBy(Integer id);

    /**
     * This method give you list of users, who bought good with id = goodId
     *
     * @param goodId id of good which you want see
     * @return list of users who take this good
     */
    List<UserDto> findAllUsersThatBoughtGoodById(Integer goodId);

    /**
     * This method provides an opportunity user buy good
     *
     * @param userId you must choose which user buy good
     * @param goodId you must choose which good user want buy
     * @return sentence with purchase status
     */
    String buyGood(Integer userId, Integer goodId);
}
