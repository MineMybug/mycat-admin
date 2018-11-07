package com.github.MineMybug.security.xxl.job.admin.core.route.strategy;

import java.util.List;
import java.util.Random;

import com.github.MineMybug.security.xxl.job.admin.core.route.ExecutorRouter;
import com.github.MineMybug.security.xxl.job.core.biz.model.ReturnT;
import com.github.MineMybug.security.xxl.job.core.biz.model.TriggerParam;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteRandom extends ExecutorRouter {

    private static Random localRandom = new Random();

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList) {
        String address = addressList.get(localRandom.nextInt(addressList.size()));
        return new ReturnT<String>(address);
    }

}
