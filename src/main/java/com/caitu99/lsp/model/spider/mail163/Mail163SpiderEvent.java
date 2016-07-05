/*
 * Copyright (c) 2015-2020 by caitu99
 * All rights reserved.
 */
package com.caitu99.lsp.model.spider.mail163;

import com.alibaba.fastjson.annotation.JSONField;
import com.caitu99.lsp.model.spider.MailSpiderEvent;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yukf
 * @Description: (类职责详细描述, 可空)
 * @ClassName: Mail163SpiderEvent
 * @date 2015年10月27日 下午4:13:01
 * @Copyright (c) 2015-2020 by caitu99
 */
public class Mail163SpiderEvent extends MailSpiderEvent {
    private Mail163SpiderState state = Mail163SpiderState.NONE;
    private String sid;
    private String verifyid;
    private String next;
    private String entryUrl;

    public Mail163SpiderEvent() {

    }

    public Mail163SpiderEvent(String sessionId, DeferredResult<Object> deferredResult, HttpServletRequest request) {
        super(sessionId, deferredResult, request);
    }

    public Mail163SpiderState getState() {
        return state;
    }

    public void setState(Mail163SpiderState state) {
        this.state = state;
    }

    @JSONField(deserialize = false)
    public void setException(Exception exception) {
        this.setState(Mail163SpiderState.ERROR);
        this.exception = exception;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getVerifyid() {
        return verifyid;
    }

    public void setVerifyid(String verifyid) {
        this.verifyid = verifyid;
    }

    @JSONField(serialize = false)
    public String getNext() {
        return next;
    }

    @JSONField(deserialize = false)
    public void setNext(String next) {
        this.next = next;
    }

    @JSONField(serialize = false)
    public String getEntryUrl() {
        return entryUrl;
    }

    @JSONField(deserialize = false)
    public void setEntryUrl(String entryUrl) {
        this.entryUrl = entryUrl;
    }
}
