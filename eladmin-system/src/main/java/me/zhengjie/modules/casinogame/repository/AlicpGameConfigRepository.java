package me.zhengjie.modules.casinogame.repository;

import me.zhengjie.modules.casinogame.domain.AlicpGameConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author shenzhi
* @date 2019-08-07
*/
public interface AlicpGameConfigRepository extends JpaRepository<AlicpGameConfig, Long>, JpaSpecificationExecutor {

    /**
     * findByConfigPath
     * @param config_path
     * @return
     */
    AlicpGameConfig findByConfigPath(String config_path);
}