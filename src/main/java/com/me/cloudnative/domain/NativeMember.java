package com.me.cloudnative.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NativeMember implements Serializable {
    private Long memId;
    private String memName;
    private String memNo;
    private  String memCell;
    //private final List<String> memFamilyCell;
    private  Integer memAge;
    private  String createTime;
    private String updateTime;
    private  String memaudotor;
}
