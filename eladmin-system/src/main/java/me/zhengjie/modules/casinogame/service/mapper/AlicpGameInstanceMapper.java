package me.zhengjie.modules.casinogame.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.casinogame.domain.AlicpGameInstance;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameInstanceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author shenzhi
* @date 2019-08-07
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlicpGameInstanceMapper extends EntityMapper<AlicpGameInstanceDTO, AlicpGameInstance> {

}