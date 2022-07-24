package com.example.IntelliasTask.service.serviceImpl;

import com.example.IntelliasTask.dto.UserDto;
import com.example.IntelliasTask.mapper.UserMapper;
import com.example.IntelliasTask.model.Good;
import com.example.IntelliasTask.model.User;
import com.example.IntelliasTask.model.UserGood;
import com.example.IntelliasTask.model.UserGoodId;
import com.example.IntelliasTask.repository.GoodRepository;
import com.example.IntelliasTask.repository.UserGoodRepository;
import com.example.IntelliasTask.repository.UserRepository;
import com.example.IntelliasTask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserGoodRepository userGoodRepository;
    private final GoodRepository goodRepository;


    /**
     * This method show you all list of users
     *
     * @return DTO of this users
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(toList());
    }

    /**
     * This method show you user number id
     *
     * @param id you indicate which user you want
     * @return DTO of this user
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findById(Integer id) {
        return userRepository.findById(id).stream().map(userMapper::toDto).collect(toList());
    }

    /**
     * This method create and save user which you provide
     *
     * @param userDto user which you provide
     * @return DTO of this user
     */
    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User entity = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(entity));
    }

    /**
     * This method update user first name or some else field
     *
     * @param userDto with changes
     * @return update UserDto
     */
    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        Integer userId = userDto.getId();
        Assert.notNull(userId, "User id should be null");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(format("No such user with id: %d", userId)));

        userMapper.updateProperties(userDto, user);
        return userMapper.toDto(userRepository.save(user));
    }

    /**
     * This method delete one user witch you choose
     *
     * @param id of user witch you want delete
     */
    @Override
    @Transactional
    public void deleteBy(Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * This method give you list of users, who bought good with id = goodId
     *
     * @param goodId id of good which you want see
     * @return list of users who take this good
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAllUsersThatBoughtGoodById(Integer goodId) {
        return userRepository.findAllByGoodId(goodId).stream().map(userMapper::toDto).collect(toList());
    }

    /**
     * This method provides an opportunity user buy good
     *
     * @param userId you must choose which user buy good
     * @param goodId you must choose which good user want buy
     * @return sentence with purchase status
     */
    @Override
    public String buyGood(Integer userId, Integer goodId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(format("No such user with id: %d", userId)));
        Good good = goodRepository.findById(goodId)
                .orElseThrow(() -> new EntityNotFoundException(format("No such good with id: %d", goodId)));

        Integer amountOfMoney = user.getAmountOfMoney();
        Integer price = good.getPrice();
        if (amountOfMoney < price) {
            throw new IllegalStateException("Sorry, unfortunately you don't have enough money");
        }

        userGoodRepository.save(
                UserGood.builder()
                        .id(UserGoodId
                                .builder()
                                .goodId(goodId)
                                .userId(userId)
                                .build())
                        .user(user)
                        .good(good)
                        .build());
        user.setAmountOfMoney(amountOfMoney - price);
        userRepository.save(user);
        return format("purchase successful, you have bought %s", good.getName());
    }
}

