package me.zhengjie.modules.casinogame.service.impl;

import me.zhengjie.modules.casinogame.domain.AlicpGameInstance;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.casinogame.repository.AlicpGameInstanceRepository;
import me.zhengjie.modules.casinogame.service.AlicpGameInstanceService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameInstanceDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameInstanceQueryCriteria;
import me.zhengjie.modules.casinogame.service.mapper.AlicpGameInstanceMapper;
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
public class AlicpGameInstanceServiceImpl implements AlicpGameInstanceService {

    @Autowired
    private AlicpGameInstanceRepository alicpGameInstanceRepository;

    @Autowired
    private AlicpGameInstanceMapper alicpGameInstanceMapper;

    @Override
    public Object queryAll(AlicpGameInstanceQueryCriteria criteria, Pageable pageable){
        Page<AlicpGameInstance> page = alicpGameInstanceRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(alicpGameInstanceMapper::toDto));
    }

    @Override
    public Object queryAll(AlicpGameInstanceQueryCriteria criteria){
        return alicpGameInstanceMapper.toDto(alicpGameInstanceRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public AlicpGameInstanceDTO findById(Long instanceId) {
        Optional<AlicpGameInstance> alicpGameInstance = alicpGameInstanceRepository.findById(instanceId);
        ValidationUtil.isNull(alicpGameInstance,"AlicpGameInstance","instanceId",instanceId);
        return alicpGameInstanceMapper.toDto(alicpGameInstance.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AlicpGameInstanceDTO create(AlicpGameInstance resources) {
        return alicpGameInstanceMapper.toDto(alicpGameInstanceRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AlicpGameInstance resources) {
        Optional<AlicpGameInstance> optionalAlicpGameInstance = alicpGameInstanceRepository.findById(resources.getInstanceId());
        ValidationUtil.isNull( optionalAlicpGameInstance,"AlicpGameInstance","id",resources.getInstanceId());

        AlicpGameInstance alicpGameInstance = optionalAlicpGameInstance.get();
        // 此处需自己修改
        resources.setInstanceId(alicpGameInstance.getInstanceId());
        alicpGameInstanceRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long instanceId) {
        alicpGameInstanceRepository.deleteById(instanceId);
    }
}