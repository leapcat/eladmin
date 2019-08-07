package me.zhengjie.modules.casinogame.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.casinogame.domain.AlicpGameChannel;
import me.zhengjie.modules.casinogame.service.AlicpGameChannelService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameChannelQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
* @author shenzhi
* @date 2019-08-07
*/
@RestController
@RequestMapping("api")
public class AlicpGameChannelController {

    @Autowired
    private AlicpGameChannelService alicpGameChannelService;

    @Log("查询AlicpGameChannel")
    @GetMapping(value = "/alicpGameChannel")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECHANNEL_ALL','ALICPGAMECHANNEL_SELECT')")
    public ResponseEntity getAlicpGameChannels(AlicpGameChannelQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(alicpGameChannelService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增AlicpGameChannel")
    @PostMapping(value = "/alicpGameChannel")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECHANNEL_ALL','ALICPGAMECHANNEL_CREATE')")
    public ResponseEntity create(@Validated @RequestBody AlicpGameChannel resources){
        return new ResponseEntity(alicpGameChannelService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AlicpGameChannel")
    @PutMapping(value = "/alicpGameChannel")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECHANNEL_ALL','ALICPGAMECHANNEL_EDIT')")
    public ResponseEntity update(@Validated @RequestBody AlicpGameChannel resources){
        alicpGameChannelService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AlicpGameChannel")
    @DeleteMapping(value = "/alicpGameChannel/{channelId}")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECHANNEL_ALL','ALICPGAMECHANNEL_DELETE')")
    public ResponseEntity delete(@PathVariable Long channelId){
        alicpGameChannelService.delete(channelId);
        return new ResponseEntity(HttpStatus.OK);
    }
}