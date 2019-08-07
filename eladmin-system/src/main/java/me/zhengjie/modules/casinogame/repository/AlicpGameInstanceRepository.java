package me.zhengjie.modules.casinogame.repository;

import me.zhengjie.modules.casinogame.domain.AlicpGameInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author shenzhi
* @date 2019-08-07
*/
public interface AlicpGameInstanceRepository extends JpaRepository<AlicpGameInstance, Long>, JpaSpecificationExecutor {
}