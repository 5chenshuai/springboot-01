package com.chenxi.springboot01practice.response;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class MapResult<String,Object> {

    //数据列表
    private Map<String,Object> map;

    //数据总数
    private long total;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
