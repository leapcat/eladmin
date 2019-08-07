package me.zhengjie.modules.casinogame.service;

import me.zhengjie.modules.casinogame.domain.AlicpGameChannel;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameChannelDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameChannelQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author shenzhi
* @date 2019-08-07
*/
@CacheConfig(cacheNames = "alicpGameChannel")
public interface AlicpGameChannelService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(AlicpGameChannelQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AlicpGameChannelQueryCriteria criteria);

    /**
     * findById
     * @param channelId
     * @return
     */
    @Cacheable(key = "#p0")
    AlicpGameChannelDTO findById(Long channelId);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AlicpGameChannelDTO create(AlicpGameChannel resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(AlicpGameChannel resources);

    /**
     * delete
     * @param channelId
     */
    @CacheEvict(allEntries = true)
    void delete(Long channelId);
}