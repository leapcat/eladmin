package me.zhengjie.modules.casinogame.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.casinogame.domain.AlicpGameChannel;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameChannelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author shenzhi
* @date 2019-08-07
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlicpGameChannelMapper extends EntityMapper<AlicpGameChannelDTO, AlicpGameChannel> {

}