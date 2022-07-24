package com.example.IntelliasTask.rest;

import com.example.IntelliasTask.dto.GoodDto;
import com.example.IntelliasTask.dto.UserDto;
import com.example.IntelliasTask.service.GoodService;
import com.example.IntelliasTask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This REST controller with user API
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;
    private final GoodService goodService;

    /**
     * This method show you all list of users
     *
     * @return DTO of this users
     */
    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    /**
     * This method give you list of goods which user bought
     *
     * @param userId if you want take a list of goods which user bought, you must give a id of user
     * @return list of goods
     */
    @GetMapping("/user/{id}/good")
    public ResponseEntity<List<GoodDto>> getAllBoughtGoods(@PathVariable(name = "id") Integer userId) {
        return ResponseEntity.ok(goodService.findAllGoodsBoughtByUser(userId));
    }

    /**
     * This method show you user number id
     *
     * @param id you indicate which user you want
     * @return DTO of this user
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<List<UserDto>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    /**
     * This method create and save user which you provide
     *
     * @param userDto user which you provide
     * @return DTO of this user
     */
    @PostMapping("/user")
    public ResponseEntity<UserDto> save(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    /**
     * This method update user first name or some else field
     *
     * @param userDto with changes
     * @return update UserDto
     */
    @PutMapping("/user")
    public ResponseEntity<UserDto> update(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok(userService.update(userDto));
    }

    /**
     * This method provides an opportunity user buy good
     *
     * @param userId you must choose which user buy good
     * @param goodId you must choose which good user want buy
     * @return sentence with purchase status
     */
    @PutMapping("/user/{userId}/good/{goodId}")
    public ResponseEntity<String> buyGood(@PathVariable Integer userId,
                                          @PathVariable Integer goodId) {
        return ResponseEntity.ok(userService.buyGood(userId, goodId));
    }

    /**
     * This method delete one user witch you choose
     *
     * @param id of user witch you want delete
     */
    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteBy(id);
    }
}
