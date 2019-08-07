package me.zhengjie.modules.casinogame.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author shenzhi
* @date 2019-08-07
*/
@Data
public class AlicpGameChannelDTO implements Serializable {

    // 渠道id
    private Long channelId;

    // 实例id
    private Long instanceId;

    // 游戏id
    private Integer gameId;

    // 渠道描述
    private String channelDesc;

    // 接入Token
    private String accessToken;

    // 接入Key
    private String accessKey;

    // 是否启用
    private Integer enable;

    // 修改时间
    private Timestamp gmtModified;

    // 创建时间
    private Timestamp gmtCreate;

    // 业务渠道id
    private String appChannelId;
}