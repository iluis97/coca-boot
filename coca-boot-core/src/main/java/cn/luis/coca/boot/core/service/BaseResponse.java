package cn.luis.coca.boot.core.service;

import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class BaseResponse<T> implements Serializable {

    /**
     * 消息类型
     */
    protected Boolean success;

    /**
     * 消息code
     */
    protected String code;

    /**
     * 消息详情
     */
    protected String desc;

    /**
     * 返回前端的数据
     */
    protected T data;


}
