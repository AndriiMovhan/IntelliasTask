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
 * This REST controller with good API
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodController {

    private final GoodService goodService;
    private final UserService userService;

    /**
     * This method show you all list of goods
     *
     * @return DTO of this goods
     */
    @GetMapping("/good")
    public ResponseEntity<List<GoodDto>> getAll() {
        return ResponseEntity.ok(goodService.findAll());
    }

    /**
     * This method give you list of users, who bought good with id = goodId
     *
     * @param goodId id of good which you want see
     * @return list of users who take this good
     */
    @GetMapping("/good/{id}/user")
    public ResponseEntity<List<UserDto>> getAllUsersThatBoughtGoodById(@PathVariable(name = "id") Integer goodId) {
        return ResponseEntity.ok(userService.findAllUsersThatBoughtGoodById(goodId));
    }

    /**
     * This method show you good number id
     *
     * @param id you indicate which good you want
     * @return DTO of this good
     */
    @GetMapping("/good/{id}")
    public ResponseEntity<List<GoodDto>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(goodService.findById(id));
    }

    /**
     * This method create and save good which you provide
     *
     * @param goodDto good which you provide
     * @return DTO of this good
     */
    @PostMapping("/good")
    public ResponseEntity<GoodDto> save(@RequestBody @Validated GoodDto goodDto) {
        return ResponseEntity.ok(goodService.save(goodDto));
    }

    /**
     * This method update good name or some else field
     *
     * @param goodDto with changes
     * @return update GoodDto
     */
    @PutMapping("/good")
    public ResponseEntity<GoodDto> update(@RequestBody @Validated GoodDto goodDto) {
        return ResponseEntity.ok(goodService.update(goodDto));
    }

    /**
     * This method delete one good witch you choose
     *
     * @param id of good witch you want delete
     */
    @DeleteMapping("/good/{id}")
    public void deleteById(@PathVariable Integer id) {
        goodService.deleteBy(id);
    }
}
