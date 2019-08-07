package me.zhengjie.modules.casinogame.service.impl;

import me.zhengjie.modules.casinogame.domain.AlicpGameChannel;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.casinogame.repository.AlicpGameChannelRepository;
import me.zhengjie.modules.casinogame.service.AlicpGameChannelService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameChannelDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameChannelQueryCriteria;
import me.zhengjie.modules.casinogame.service.mapper.AlicpGameChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;

/**
* @author shenzhi
* @date 2019-08-07
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AlicpGameChannelServiceImpl implements AlicpGameChannelService {

    @Autowired
    private AlicpGameChannelRepository alicpGameChannelRepository;

    @Autowired
    private AlicpGameChannelMapper alicpGameChannelMapper;

    @Override
    public Object queryAll(AlicpGameChannelQueryCriteria criteria, Pageable pageable){
        Page<AlicpGameChannel> page = alicpGameChannelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(alicpGameChannelMapper::toDto));
    }

    @Override
    public Object queryAll(AlicpGameChannelQueryCriteria criteria){
        return alicpGameChannelMapper.toDto(alicpGameChannelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public AlicpGameChannelDTO findById(Long channelId) {
        Optional<AlicpGameChannel> alicpGameChannel = alicpGameChannelRepository.findById(channelId);
        ValidationUtil.isNull(alicpGameChannel,"AlicpGameChannel","channelId",channelId);
        return alicpGameChannelMapper.toDto(alicpGameChannel.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AlicpGameChannelDTO create(AlicpGameChannel resources) {
        return alicpGameChannelMapper.toDto(alicpGameChannelRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AlicpGameChannel resources) {
        Optional<AlicpGameChannel> optionalAlicpGameChannel = alicpGameChannelRepository.findById(resources.getChannelId());
        ValidationUtil.isNull( optionalAlicpGameChannel,"AlicpGameChannel","id",resources.getChannelId());

        AlicpGameChannel alicpGameChannel = optionalAlicpGameChannel.get();
        // 此处需自己修改
        resources.setChannelId(alicpGameChannel.getChannelId());
        alicpGameChannelRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long channelId) {
        alicpGameChannelRepository.deleteById(channelId);
    }
}