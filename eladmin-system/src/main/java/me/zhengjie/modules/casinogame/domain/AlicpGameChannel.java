package me.zhengjie.modules.casinogame.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author shenzhi
* @date 2019-08-07
*/
@Entity
@Data
@Table(name="alicp_game_channel")
public class AlicpGameChannel implements Serializable {

    // 渠道id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")
    private Long channelId;

    // 实例id
    @Column(name = "instance_id",nullable = false)
    private Long instanceId;

    // 游戏id
    @Column(name = "game_id",nullable = false)
    private Integer gameId;

    // 渠道描述
    @Column(name = "channel_desc",nullable = false)
    private String channelDesc;

    // 接入Token
    @Column(name = "access_token",nullable = false)
    private String accessToken;

    // 接入Key
    @Column(name = "access_key",nullable = false)
    private String accessKey;

    // 是否启用
    @Column(name = "enable",nullable = false)
    private Integer enable;

    // 修改时间
    @Column(name = "gmt_modified",nullable = false)
    private Timestamp gmtModified;

    // 创建时间
    @Column(name = "gmt_create",nullable = false)
    private Timestamp gmtCreate;

    // 业务渠道id
    @Column(name = "app_channel_id")
    private String appChannelId;
}