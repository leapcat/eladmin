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
@Table(name="alicp_game_instance")
public class AlicpGameInstance implements Serializable {

    // 实例id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instance_id")
    private Long instanceId;

    // 游戏id
    @Column(name = "game_id",nullable = false)
    private Integer gameId;

    // 实例描述
    @Column(name = "instance_desc",nullable = false)
    private String instanceDesc;

    // 是否启用
    @Column(name = "enable",nullable = false)
    private Integer enable;

    // 创建时间
    @Column(name = "gmt_create",nullable = false)
    private Timestamp gmtCreate;

    // 修改时间
    @Column(name = "gmt_modified",nullable = false)
    private Timestamp gmtModified;

    // 扩展属性
    @Column(name = "props")
    private String props;

    // 定时可售
    @Column(name = "fixedTimeCanSale")
    private String fixedtimecansale;
}