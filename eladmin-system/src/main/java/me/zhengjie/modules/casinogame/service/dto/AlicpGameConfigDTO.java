package me.zhengjie.modules.casinogame.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author shenzhi
* @date 2019-08-07
*/
@Data
public class AlicpGameConfigDTO implements Serializable {

    // 主键
    private Long configId;

    // 配置路径
    private String configPath;

    // 配置名称
    private String configKey;

    // 上级配置路径
    private String configParent;

    // 配置描述
    private String configDesc;

    // 配置项值
    private String configValue;

    // 备注
    private String configMemo;

    // *
    private Timestamp gmtCreate;

    // *
    private Timestamp gmtModified;
}