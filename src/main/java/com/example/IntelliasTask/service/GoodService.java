package com.example.IntelliasTask.service;

import com.example.IntelliasTask.dto.GoodDto;

import java.util.List;


public interface GoodService {

    /**
     * This method show you all list of goods
     *
     * @return DTO of this goods
     */
    List<GoodDto> findAll();

    /**
     * This method show you good number id
     *
     * @param id you indicate which good you want
     * @return DTO of this good
     */
    List<GoodDto> findById(Integer id);

    /**
     * This method create and save good which you provide
     *
     * @param goodDto good which you provide
     * @return DTO of this good
     */
    GoodDto save(GoodDto goodDto);

    /**
     * This method update good name or some else field
     *
     * @param goodDto with changes
     * @return update GoodDto
     */
    GoodDto update(GoodDto goodDto);

    /**
     * This method delete one good witch you choose
     *
     * @param id of good witch you want delete
     */
    void deleteBy(Integer id);

    /**
     * This method give you list of goods which user bought
     *
     * @param userId if you want take a list of goods which user bought, you must give a id of user
     * @return list of goods
     */
    List<GoodDto> findAllGoodsBoughtByUser(Integer userId);
}
