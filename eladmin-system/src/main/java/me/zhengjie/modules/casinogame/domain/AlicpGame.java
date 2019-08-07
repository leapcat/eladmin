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
@Table(name="alicp_game")
public class AlicpGame implements Serializable {

    // 游戏id
    @Id
    @Column(name = "game_id")
    private Integer gameId;

    // 游戏描述
    @Column(name = "game_desc",nullable = false)
    private String gameDesc;

    // 引擎类型
    @Column(name = "engine_type",nullable = false)
    private Integer engineType;

    // 交易类型
    @Column(name = "trade_type",nullable = false)
    private Integer tradeType;

    // 启用标示
    @Column(name = "enable",nullable = false)
    private Integer enable;

    // 创建时间
    @Column(name = "gmt_create",nullable = false)
    private Timestamp gmtCreate;

    // 修改时间
    @Column(name = "gmt_modified",nullable = false)
    private Timestamp gmtModified;

    @Column(name = "enable_auto_check")
    private Integer enableAutoCheck;
}