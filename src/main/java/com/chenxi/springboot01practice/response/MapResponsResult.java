package com.chenxi.springboot01practice.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MapResponsResult extends  ResponsResultImpl  {
    MapResult mapResule;
    /**
     * @param resultCodeEnum
     * @return
     * @Description: 使用枚举返回类型构建返回list结果
     * @Param [resultCode]
     * @Author chenhaotao
     * @Date 2019/1/5 0005 11:58
     */
    public MapResponsResult(ResultCodeEnum resultCodeEnum, MapResult mapResule) {
        super(resultCodeEnum);
        this.mapResule = mapResule;
    }
}
