package me.zhengjie.modules.casinogame.service;

import me.zhengjie.modules.casinogame.domain.AlicpGame;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author shenzhi
* @date 2019-08-07
*/
@CacheConfig(cacheNames = "alicpGame")
public interface AlicpGameService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(AlicpGameQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AlicpGameQueryCriteria criteria);

    /**
     * findById
     * @param gameId
     * @return
     */
    @Cacheable(key = "#p0")
    AlicpGameDTO findById(Integer gameId);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AlicpGameDTO create(AlicpGame resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(AlicpGame resources);

    /**
     * delete
     * @param gameId
     */
    @CacheEvict(allEntries = true)
    void delete(Integer gameId);
}