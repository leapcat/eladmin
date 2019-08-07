package me.zhengjie.modules.casinogame.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.casinogame.domain.AlicpGame;
import me.zhengjie.modules.casinogame.service.AlicpGameService;
import me.zhengjie.modules.casinogame.service.dto.AlicpGameQueryCriteria;
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
public class AlicpGameController {

    @Autowired
    private AlicpGameService alicpGameService;

    @Log("查询AlicpGame")
    @GetMapping(value = "/alicpGame")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAME_ALL','ALICPGAME_SELECT')")
    public ResponseEntity getAlicpGames(AlicpGameQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(alicpGameService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增AlicpGame")
    @PostMapping(value = "/alicpGame")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAME_ALL','ALICPGAME_CREATE')")
    public ResponseEntity create(@Validated @RequestBody AlicpGame resources){
        return new ResponseEntity(alicpGameService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AlicpGame")
    @PutMapping(value = "/alicpGame")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAME_ALL','ALICPGAME_EDIT')")
    public ResponseEntity update(@Validated @RequestBody AlicpGame resources){
        alicpGameService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AlicpGame")
    @DeleteMapping(value = "/alicpGame/{gameId}")
    @PreAuthorize("hasAnyRole('ADMIN','ALICPGAME_ALL','ALICPGAME_DELETE')")
    public ResponseEntity delete(@PathVariable Integer gameId){
        alicpGameService.delete(gameId);
        return new ResponseEntity(HttpStatus.OK);
    }
}