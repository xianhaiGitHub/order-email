package com.sea.order.common;
/**
 * @description: 错误消息enum
 * @author: Sea
 */
public enum CodeEnum {
    /**
     * b_开头为业务提示
     **/
    b_success(1000, "success"),
    b_MobilePrefixError(1001, "mobile prefix error");


    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String desc;


    CodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public CodeEnum fillData(Object... data) {
        this.desc = String.format(this.desc, data);
        return this;
    }
}
