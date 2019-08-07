package me.zhengjie.modules.casinogame.service.impl;

import me.zhengjie.modules.casinogame.domain.AlicpGame;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.casinogame.repository.AlicpGameRepository;
import me.zhengjie.modules.casinogame.service.AlicpGameService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameDTO;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameQueryCriteria;
import me.zhengjie.modules.casinogame.service.mapper.AlicpGameMapper;
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
public class AlicpGameServiceImpl implements AlicpGameService {

    @Autowired
    private AlicpGameRepository alicpGameRepository;

    @Autowired
    private AlicpGameMapper alicpGameMapper;

    @Override
    public Object queryAll(AlicpGameQueryCriteria criteria, Pageable pageable){
        Page<AlicpGame> page = alicpGameRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(alicpGameMapper::toDto));
    }

    @Override
    public Object queryAll(AlicpGameQueryCriteria criteria){
        return alicpGameMapper.toDto(alicpGameRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public AlicpGameDTO findById(Integer gameId) {
        Optional<AlicpGame> alicpGame = alicpGameRepository.findById(gameId);
        ValidationUtil.isNull(alicpGame,"AlicpGame","gameId",gameId);
        return alicpGameMapper.toDto(alicpGame.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AlicpGameDTO create(AlicpGame resources) {
        return alicpGameMapper.toDto(alicpGameRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AlicpGame resources) {
        Optional<AlicpGame> optionalAlicpGame = alicpGameRepository.findById(resources.getGameId());
        ValidationUtil.isNull( optionalAlicpGame,"AlicpGame","id",resources.getGameId());

        AlicpGame alicpGame = optionalAlicpGame.get();
        // 此处需自己修改
        resources.setGameId(alicpGame.getGameId());
        alicpGameRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer gameId) {
        alicpGameRepository.deleteById(gameId);
    }
}