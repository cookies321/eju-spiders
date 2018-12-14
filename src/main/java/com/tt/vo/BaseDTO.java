package com.tt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

import static com.eju.houseparent.common.global.Global.CODE_FAIL;
import static com.eju.houseparent.common.global.Global.CODE_SUCCESS;

/**
 * API接口返回数据基础模型
 */
@ApiModel(value = "BaseDTO对象",description ="基础响应对象")
public class BaseDTO<T> implements java.io.Serializable, Cloneable {

    private static final long serialVersionUID = -5809782578272943999L;

    @ApiModelProperty(value = "响应码",name="code",example = "接口返回值(1:成功;0:失败)",required = true)
    private String code = CODE_SUCCESS;//接口返回值(1:成功;0:失败)
    @ApiModelProperty(value = "响应消息",name="msg",example = "提示信息代码对应的消息")
    private String msg = "操作成功";//提示信息代码对应的消息
    @ApiModelProperty(value = "响应结果",name="result",example = "返回数据结果集")
    private Map result = null;//返回数据结果集
    @ApiModelProperty(value = "签名",name="sign",example = "签名")
    private String sign; //签名
    @ApiModelProperty(value = "具体vo对象",name="resultVo",example = "实体")
    private T resultVo;

    public void setCodeAndMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseDTO addObject(Object o) {
        if (o != null) {
            String name = o.getClass().getSimpleName();
            name = name.substring(0, 1).toLowerCase() + name.substring(1);
            addObject(name, o);
        }
        return this;
    }

    public BaseDTO addObject(Object... objects) {

        if (objects != null && objects.length > 0) {
            for (Object o : objects) {
                addObject(o);
            }
        }
        return this;
    }

    public BaseDTO addObject(String name, Object o) {
        if (result == null) {
            result = new HashMap<>();
        }
        result.put(name, o);
        return this.signature();
    }

    public BaseDTO addObject(String name1, Object o1, String name2, Object o2) {
        addObject(name1, o1);
        addObject(name2, o2);
        return this;
    }

    public BaseDTO addObject(String name1, Object o1, String name2, Object o2, String name3, Object o3) {
        addObject(name1, o1);
        addObject(name2, o2);
        addObject(name3, o3);
        return this;
    }


    public BaseDTO fail(String msg) {
        this.code = CODE_FAIL;
        this.msg = msg;
        return this;
    }

    public BaseDTO signature() {
        return this;
    }

    @Override
    public Object clone() {
        BaseDTO bd = null;
        try {
            bd = (BaseDTO) super.clone();
            Map newResult = new HashMap();
            newResult.putAll(bd.result);
            bd.result = newResult;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map getResult() {
        return result;
    }

    public void setResult(Map result) {
        this.result = result;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public T getResultVo() {
        return resultVo;
    }

    public void setResultVo(T resultVo) {
        this.resultVo = resultVo;
    }
}