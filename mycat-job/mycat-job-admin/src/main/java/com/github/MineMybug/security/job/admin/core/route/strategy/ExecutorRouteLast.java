package com.github.MineMybug.security.job.admin.core.route.strategy;

import java.util.ArrayList;

import com.github.MineMybug.security.core.biz.model.ReturnT;
import com.github.MineMybug.security.core.biz.model.TriggerParam;
import com.github.MineMybug.security.job.admin.core.route.ExecutorRouter;
import com.github.MineMybug.security.job.admin.core.trigger.XxlJobTrigger;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteLast extends ExecutorRouter {

    public String route(int jobId, ArrayList<String> addressList) {
        return addressList.get(addressList.size()-1);
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
