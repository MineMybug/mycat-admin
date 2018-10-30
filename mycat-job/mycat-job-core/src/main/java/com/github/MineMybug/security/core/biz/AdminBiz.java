package com.github.MineMybug.security.core.biz;


import java.util.List;

import com.github.MineMybug.security.core.biz.model.HandleCallbackParam;
import com.github.MineMybug.security.core.biz.model.RegistryParam;
import com.github.MineMybug.security.core.biz.model.ReturnT;

/**
 * @author xuxueli 2017-07-27 21:52:49
 */
public interface AdminBiz {

    public static final String MAPPING = "/api";


    // ---------------------- callback ----------------------

    /**
     * callback
     *
     * @param callbackParamList
     * @return
     */
    public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList);


    // ---------------------- registry ----------------------

    /**
     * registry
     *
     * @param registryParam
     * @return
     */
    public ReturnT<String> registry(RegistryParam registryParam);

    /**
     * registry remove
     *
     * @param registryParam
     * @return
     */
    public ReturnT<String> registryRemove(RegistryParam registryParam);


    // ---------------------- job opt ----------------------

    /**
     * trigger job for once
     *
     * @param jobId
     * @return
     */
    public ReturnT<String> triggerJob(int jobId);

}
