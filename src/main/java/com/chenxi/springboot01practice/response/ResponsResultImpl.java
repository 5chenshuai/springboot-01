package com.chenxi.springboot01practice.response;

import com.chenxi.springboot01practice.response.ResponsResultBase;
import com.chenxi.springboot01practice.response.ResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ResponsResultImpl implements ResponsResultBase {

    //操作是否成功
    String flag = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    //提示信息
    String message = MSG_SUCCESS;

    /**
     * @Description: 使用枚举返回类型构建返回结果
     * @Param [resultCode]
     * @return
     * @Author chenhaotao
     * @Date 2019/1/5 0005 11:58
     */
    public ResponsResultImpl(ResultCodeEnum resultCodeEnum){
        this.flag = resultCodeEnum.flag;
        this.code = resultCodeEnum.code;
        this.message = resultCodeEnum.message;
    }

    /**
     * @Description: 返回成功状态
     * @Param []
     * @return com.chen.model.web.ResultRespons
     * @Author chenhaotao
     * @Date 2019/1/5 0005 12:03
     */
    public static ResponsResultImpl returnSuccess(){
        return new ResponsResultImpl(ResultCodeEnum.SUCCESS);
    }

    /**
     * @Description: 返回失败状态
     * @Param []
     * @return com.chen.model.web.ResultRespons
     * @Author chenhaotao
     * @Date 2019/1/5 0005 12:03
     */
    public static ResponsResultImpl returnFail(){
        return new ResponsResultImpl(ResultCodeEnum.FAIL);
    }

}
