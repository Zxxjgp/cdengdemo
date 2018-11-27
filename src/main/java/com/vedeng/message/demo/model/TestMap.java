package com.vedeng.message.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/26 15:30
 * @Description //TODO 测试map
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestMap {
    private String id;
    private Integer mapAge;
    private String mapName;
    private User user;
}
