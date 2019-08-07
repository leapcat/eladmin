package me.zhengjie.modules.casinogame.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author shenzhi
* @date 2019-08-07
*/
@Data
public class AlicpGameInstanceDTO implements Serializable {

    // 实例id
    private Long instanceId;

    // 游戏id
    private Integer gameId;

    // 实例描述
    private String instanceDesc;

    // 是否启用
    private Integer enable;

    // 创建时间
    private Timestamp gmtCreate;

    // 修改时间
    private Timestamp gmtModified;

    // 扩展属性
    private String props;

    // 定时可售
    private String fixedtimecansale;
}