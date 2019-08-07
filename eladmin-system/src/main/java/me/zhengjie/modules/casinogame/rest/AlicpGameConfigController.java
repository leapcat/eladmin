package me.zhengjie.modules.casinogame.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.casinogame.domain.AlicpGameConfig;
import me.zhengjie.modules.casinogame.service.AlicpGameConfigService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameConfigQueryCriteria;
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
public class AlicpGameConfigController {

    @Autowired
    private AlicpGameConfigService alicpGameConfigService;

    @Log("查询AlicpGameConfig")
    @GetMapping(value = "/alicpGameConfig")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECONFIG_ALL','ALICPGAMECONFIG_SELECT')")
    public ResponseEntity getAlicpGameConfigs(AlicpGameConfigQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(alicpGameConfigService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增AlicpGameConfig")
    @PostMapping(value = "/alicpGameConfig")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECONFIG_ALL','ALICPGAMECONFIG_CREATE')")
    public ResponseEntity create(@Validated @RequestBody AlicpGameConfig resources){
        return new ResponseEntity(alicpGameConfigService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AlicpGameConfig")
    @PutMapping(value = "/alicpGameConfig")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECONFIG_ALL','ALICPGAMECONFIG_EDIT')")
    public ResponseEntity update(@Validated @RequestBody AlicpGameConfig resources){
        alicpGameConfigService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AlicpGameConfig")
    @DeleteMapping(value = "/alicpGameConfig/{configId}")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMECONFIG_ALL','ALICPGAMECONFIG_DELETE')")
    public ResponseEntity delete(@PathVariable Long configId){
        alicpGameConfigService.delete(configId);
        return new ResponseEntity(HttpStatus.OK);
    }
}