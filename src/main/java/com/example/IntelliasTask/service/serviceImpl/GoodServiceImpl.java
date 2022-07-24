package com.example.IntelliasTask.service.serviceImpl;

import com.example.IntelliasTask.dto.GoodDto;
import com.example.IntelliasTask.mapper.GoodMapper;
import com.example.IntelliasTask.model.Good;
import com.example.IntelliasTask.repository.GoodRepository;
import com.example.IntelliasTask.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

/**
 * This class implements GoodService and his methods
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodServiceImpl implements GoodService {

    private final GoodMapper goodMapper;
    private final GoodRepository goodRepository;

    /**
     * This method show you all list of goods
     *
     * @return DTO of this goods
     */
    @Override
    @Transactional(readOnly = true)
    public List<GoodDto> findAll() {
        return goodRepository.findAll().stream().map(goodMapper::toDto).collect(toList());
    }

    /**
     * This method show you good number id
     *
     * @param id you indicate which good you want
     * @return DTO of this good
     */
    @Override
    @Transactional(readOnly = true)
    public List<GoodDto> findById(Integer id) {
        return goodRepository.findById(id).stream().map(goodMapper::toDto).collect(toList());
    }

    /**
     * This method create and save good which you provide
     *
     * @param goodDto good which you provide
     * @return DTO of this good
     */
    @Override
    @Transactional
    public GoodDto save(GoodDto goodDto) {
        Good entity = goodMapper.toEntity(goodDto);
        return goodMapper.toDto(goodRepository.save(entity));
    }

    /**
     * This method update good name or some else field
     *
     * @param goodDto with changes
     * @return update GoodDto
     */
    @Override
    @Transactional
    public GoodDto update(GoodDto goodDto) {
        Integer goodId = goodDto.getId();
        Assert.notNull(goodId, "Good id should be null");
        Good good = goodRepository.findById(goodId)
                .orElseThrow(() -> new EntityNotFoundException(format("No such good with id: %d", goodId)));
        goodMapper.updateProperties(goodDto, good);
        return goodMapper.toDto(goodRepository.save(good));
    }

    /**
     * This method delete one good witch you choose
     *
     * @param id of good witch you want delete
     */
    @Override
    @Transactional
    public void deleteBy(Integer id) {
        goodRepository.deleteById(id);
    }

    /**
     * This method give you list of goods which user bought
     *
     * @param userId if you want take a list of goods which user bought, you must give a id of user
     * @return list of goods
     */
    @Override
    @Transactional(readOnly = true)
    public List<GoodDto> findAllGoodsBoughtByUser(Integer userId) {
        return goodRepository.findAllByUserId(userId).stream().map(goodMapper::toDto).collect(toList());
    }
}
