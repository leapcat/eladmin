package me.zhengjie.modules.casinogame.service;

import me.zhengjie.modules.casinogame.domain.AlicpGameInstance;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameInstanceDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameInstanceQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author shenzhi
* @date 2019-08-07
*/
@CacheConfig(cacheNames = "alicpGameInstance")
public interface AlicpGameInstanceService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(AlicpGameInstanceQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AlicpGameInstanceQueryCriteria criteria);

    /**
     * findById
     * @param instanceId
     * @return
     */
    @Cacheable(key = "#p0")
    AlicpGameInstanceDTO findById(Long instanceId);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AlicpGameInstanceDTO create(AlicpGameInstance resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(AlicpGameInstance resources);

    /**
     * delete
     * @param instanceId
     */
    @CacheEvict(allEntries = true)
    void delete(Long instanceId);
}