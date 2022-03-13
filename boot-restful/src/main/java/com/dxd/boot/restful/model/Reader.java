package com.dxd.boot.restful.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reader {
    private String name;
    private Integer age;

}
