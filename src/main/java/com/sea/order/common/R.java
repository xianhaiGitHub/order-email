package com.sea.order.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Sea.Zhao
 * @param <T>
 */
@ApiModel(value = "通用接口返回对象", description = "通用接口返回对象")
public class R<T> implements Serializable {
    private static final long serialVersionUID = 3647560525939692009L;
    @ApiModelProperty(value = "1000默认成功，其它为失败自行定义")
    private Integer errorCode = 1000;

    @ApiModelProperty(value = "描述，默认success 其它自行定义")
    private String errorMessage = "success";

    @ApiModelProperty(value = "默认为true,默认为真成功，false为假成功自行定义")
    private Boolean success = true;

    @ApiModelProperty(value = "数据集")
    private T data;

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    /**
     * @description: success T 非 null
     * @Author Sea.Zhao
     * @param t
     * @param <T>
     * @return
     */
    public static <T> R<T> ok(T t) {
        R<T> r = new R<T>();
        r.setData(t);
        return r;
    }

    /**
     * @description: success T 为 null
     * @Author Sea.Zhao
     * @param <T>
     * @return
     */
    public static <T> R<T> ok() {
        return new R<T>();
    }

    /**
     * @description: failed 使用 自定义 codeEnum 参数
     * @Author Sea.Zhao
     * @param codeEnum
     * @param <T>
     * @return
     */
    public static <T> R<T> error(CodeEnum codeEnum) {
        R<T> r = new R<T>();
        r.setError(codeEnum);
        return r;
    }

    /**
     * @description: failed 使用自定义errorCode,  errorMessage参数
     * @Author Sea.Zhao
     * @param errorCode
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> R<T> error(Integer errorCode, String errorMessage) {
        R<T> r = new R<T>();
        r.setSuccess(Boolean.FALSE);
        r.setErrorCode(errorCode);
        r.setErrorMessage(errorMessage);
        return r;
    }

    public R setError(CodeEnum codeEnum) {
        this.success = Boolean.FALSE;
        this.errorCode = codeEnum.getCode();
        this.errorMessage = codeEnum.getDesc();
        return this;
    }

}
