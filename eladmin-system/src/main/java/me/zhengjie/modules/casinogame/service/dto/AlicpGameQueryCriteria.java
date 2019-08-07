package me.zhengjie.modules.casinogame.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import me.zhengjie.annotation.Query;

/**
* @author shenzhi
* @date 2019-08-07
*/
@Data
public class AlicpGameQueryCriteria{

    // 精确
    @Query
    private Integer gameId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String gameDesc;

    // 精确
    @Query
    private Integer enable;
}