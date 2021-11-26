package com.fox.ums.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberAuthDTO {

    private Long userId;
    private String username;
    private Integer status;
}
