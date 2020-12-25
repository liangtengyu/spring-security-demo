package com.liangtengyu.utils;

import com.liangtengyu.entity.Result;

/**
 * @Author: lty
 * @Date: 2020/12/25 13:44
 */
public class ResultUtil {



    //region success
    public static Result success(){
        return success("00","请求成功","");
    }

    public static Result success( Object data){
        return success("-1","请求成功",data);
    }


    public static Result success(String msg){
        return success("00",msg,"");
    }


    public static Result success(String code,String msg){
        return success(code,msg,"");
    }

    private static Result success(String code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    //endregion


    //-----

    //region failed
    public static Result failed(){
        return failed("-1","请求失败","");
    }

    public static Result failed( Object data){
        return failed("-1","请求失败",data);
    }
    public static Result failed(String msg){
        return failed("-1",msg,"");
    }

    public static Result failed(String code,String msg){
        return failed(code,msg,"");
    }

    private static Result failed(String code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    //endregion



}
