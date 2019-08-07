package me.zhengjie.modules.casinogame.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.casinogame.domain.AlicpGameInstance;
import me.zhengjie.modules.casinogame.service.AlicpGameInstanceService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameInstanceQueryCriteria;
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
public class AlicpGameInstanceController {

    @Autowired
    private AlicpGameInstanceService alicpGameInstanceService;

    @Log("查询AlicpGameInstance")
    @GetMapping(value = "/alicpGameInstance")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMEINSTANCE_ALL','ALICPGAMEINSTANCE_SELECT')")
    public ResponseEntity getAlicpGameInstances(AlicpGameInstanceQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(alicpGameInstanceService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增AlicpGameInstance")
    @PostMapping(value = "/alicpGameInstance")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMEINSTANCE_ALL','ALICPGAMEINSTANCE_CREATE')")
    public ResponseEntity create(@Validated @RequestBody AlicpGameInstance resources){
        return new ResponseEntity(alicpGameInstanceService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AlicpGameInstance")
    @PutMapping(value = "/alicpGameInstance")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMEINSTANCE_ALL','ALICPGAMEINSTANCE_EDIT')")
    public ResponseEntity update(@Validated @RequestBody AlicpGameInstance resources){
        alicpGameInstanceService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AlicpGameInstance")
    @DeleteMapping(value = "/alicpGameInstance/{instanceId}")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAMEINSTANCE_ALL','ALICPGAMEINSTANCE_DELETE')")
    public ResponseEntity delete(@PathVariable Long instanceId){
        alicpGameInstanceService.delete(instanceId);
        return new ResponseEntity(HttpStatus.OK);
    }
}