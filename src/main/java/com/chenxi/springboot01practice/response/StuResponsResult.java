package com.chenxi.springboot01practice.response;

import com.chenxi.springboot01practice.bean.Student;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StuResponsResult extends ResponsResultImpl  {
    Student student;

    /**
     * @param resultCodeEnum
     * @return
     * @Description: 使用枚举返回类型构建返回list结果
     * @Param [resultCode]
     * @Author chenhaotao
     * @Date 2019/1/5 0005 11:58
     */
    public StuResponsResult(ResultCodeEnum resultCodeEnum, Student student) {
        super(resultCodeEnum);
        this.student = student;
    }
}
