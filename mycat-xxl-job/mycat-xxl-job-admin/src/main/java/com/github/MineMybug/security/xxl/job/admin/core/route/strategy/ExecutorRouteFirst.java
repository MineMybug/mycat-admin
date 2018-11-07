package com.github.MineMybug.security.xxl.job.admin.core.route.strategy;

import java.util.List;

import com.github.MineMybug.security.xxl.job.admin.core.route.ExecutorRouter;
import com.github.MineMybug.security.xxl.job.core.biz.model.ReturnT;
import com.github.MineMybug.security.xxl.job.core.biz.model.TriggerParam;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteFirst extends ExecutorRouter {

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList){
        return new ReturnT<String>(addressList.get(0));
    }

}
