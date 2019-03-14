package com.chenxi.springboot01practice.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SCResponsResult extends ResponsResultImpl {

    ListResult listResult;

    /**
     * @param resultCodeEnum
     * @return
     * @Description: 使用枚举返回类型构建返回list结果
     * @Param [resultCode]
     * @Author chenhaotao
     * @Date 2019/1/5 0005 11:58
     */
    public SCResponsResult(ResultCodeEnum resultCodeEnum, ListResult listResult) {
        super(resultCodeEnum);
        this.listResult = listResult;
    }
}

