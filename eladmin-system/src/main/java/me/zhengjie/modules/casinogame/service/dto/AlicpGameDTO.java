package me.zhengjie.modules.casinogame.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author shenzhi
* @date 2019-08-07
*/
@Data
public class AlicpGameDTO implements Serializable {

    // 游戏id
    private Integer gameId;

    // 游戏描述
    private String gameDesc;

    // 引擎类型
    private Integer engineType;

    // 交易类型
    private Integer tradeType;

    // 启用标示
    private Integer enable;

    // 创建时间
    private Timestamp gmtCreate;

    // 修改时间
    private Timestamp gmtModified;

    private Integer enableAutoCheck;
}