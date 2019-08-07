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
@Table(name="alicp_game_config")
public class AlicpGameConfig implements Serializable {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_id")
    private Long configId;

    // 配置路径
    @Column(name = "config_path",unique = true,nullable = false)
    private String configPath;

    // 配置名称
    @Column(name = "config_key",nullable = false)
    private String configKey;

    // 上级配置路径
    @Column(name = "config_parent")
    private String configParent;

    // 配置描述
    @Column(name = "config_desc")
    private String configDesc;

    // 配置项值
    @Column(name = "config_value")
    private String configValue;

    // 备注
    @Column(name = "config_memo")
    private String configMemo;

    // *
    @Column(name = "gmt_create")
    private Timestamp gmtCreate;

    // *
    @Column(name = "gmt_modified")
    private Timestamp gmtModified;
}