package me.zhengjie.modules.casinogame.service.impl;

import me.zhengjie.modules.casinogame.domain.AlicpGameConfig;
import me.zhengjie.exception.EntityExistException;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.casinogame.repository.AlicpGameConfigRepository;
import me.zhengjie.modules.casinogame.service.AlicpGameConfigService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameConfigDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameConfigQueryCriteria;
import me.zhengjie.modules.casinogame.service.mapper.AlicpGameConfigMapper;
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
public class AlicpGameConfigServiceImpl implements AlicpGameConfigService {

    @Autowired
    private AlicpGameConfigRepository alicpGameConfigRepository;

    @Autowired
    private AlicpGameConfigMapper alicpGameConfigMapper;

    @Override
    public Object queryAll(AlicpGameConfigQueryCriteria criteria, Pageable pageable){
        Page<AlicpGameConfig> page = alicpGameConfigRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(alicpGameConfigMapper::toDto));
    }

    @Override
    public Object queryAll(AlicpGameConfigQueryCriteria criteria){
        return alicpGameConfigMapper.toDto(alicpGameConfigRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public AlicpGameConfigDTO findById(Long configId) {
        Optional<AlicpGameConfig> alicpGameConfig = alicpGameConfigRepository.findById(configId);
        ValidationUtil.isNull(alicpGameConfig,"AlicpGameConfig","configId",configId);
        return alicpGameConfigMapper.toDto(alicpGameConfig.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AlicpGameConfigDTO create(AlicpGameConfig resources) {
        if(alicpGameConfigRepository.findByConfigPath(resources.getConfigPath()) != null){
            throw new EntityExistException(AlicpGameConfig.class,"config_path",resources.getConfigPath());
        }
        return alicpGameConfigMapper.toDto(alicpGameConfigRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AlicpGameConfig resources) {
        Optional<AlicpGameConfig> optionalAlicpGameConfig = alicpGameConfigRepository.findById(resources.getConfigId());
        ValidationUtil.isNull( optionalAlicpGameConfig,"AlicpGameConfig","id",resources.getConfigId());

        AlicpGameConfig alicpGameConfig = optionalAlicpGameConfig.get();
        AlicpGameConfig alicpGameConfig1 = null;
        alicpGameConfig1 = alicpGameConfigRepository.findByConfigPath(resources.getConfigPath());
        if(alicpGameConfig1 != null && !alicpGameConfig1.getConfigId().equals(alicpGameConfig.getConfigId())){
            throw new EntityExistException(AlicpGameConfig.class,"config_path",resources.getConfigPath());
        }
        // 此处需自己修改
        resources.setConfigId(alicpGameConfig.getConfigId());
        alicpGameConfigRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long configId) {
        alicpGameConfigRepository.deleteById(configId);
    }
}