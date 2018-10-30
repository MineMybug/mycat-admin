package com.github.MineMybug.security.job.admin.core.route.strategy;

import java.util.ArrayList;
import java.util.Random;

import com.github.MineMybug.security.core.biz.model.ReturnT;
import com.github.MineMybug.security.core.biz.model.TriggerParam;
import com.github.MineMybug.security.job.admin.core.route.ExecutorRouter;
import com.github.MineMybug.security.job.admin.core.trigger.XxlJobTrigger;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteRandom extends ExecutorRouter {

    private static Random localRandom = new Random();

    public String route(int jobId, ArrayList<String> addressList) {
        // Collections.shuffle(addressList);
        return addressList.get(localRandom.nextInt(addressList.size()));
    }

    @Override
    public ReturnT<String> routeRun(TriggerParam triggerParam, ArrayList<String> addressList) {
        // address
        String address = route(triggerParam.getJobId(), addressList);

        // run executor
        ReturnT<String> runResult = XxlJobTrigger.runExecutor(triggerParam, address);
        runResult.setContent(address);
        return runResult;
    }

}
