package me.zhengjie.modules.casinogame.service;

import me.zhengjie.modules.casinogame.domain.AlicpGameConfig;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameConfigDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameConfigQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author shenzhi
* @date 2019-08-07
*/
@CacheConfig(cacheNames = "alicpGameConfig")
public interface AlicpGameConfigService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(AlicpGameConfigQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AlicpGameConfigQueryCriteria criteria);

    /**
     * findById
     * @param configId
     * @return
     */
    @Cacheable(key = "#p0")
    AlicpGameConfigDTO findById(Long configId);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AlicpGameConfigDTO create(AlicpGameConfig resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(AlicpGameConfig resources);

    /**
     * delete
     * @param configId
     */
    @CacheEvict(allEntries = true)
    void delete(Long configId);
}