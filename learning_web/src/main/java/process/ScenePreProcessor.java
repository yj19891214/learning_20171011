package process;

import context.PreReqContext;
import context.PreRspContext;
import context.ProcessContext;
import resource.ResourceSceneDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ScenePreProcessor {

    public static List<BaseProcess> processes =new ArrayList(
            (Collection) UnionScene2moduleProcess.getInstance()
    );

    public static List<ResourceSceneDO> preProcess(ResourceSceneDO resourceSceneDO) {
        PreReqContext reqContext = new PreReqContext();
        reqContext.resourceSceneDO =resourceSceneDO;
        PreRspContext rspContext = new PreRspContext();
        rspContext.resourceSceneDOS=resourceSceneDO.getSubScenes();
        ProcessContext<PreReqContext,PreRspContext> processContext = new ProcessContext();
        processContext.req=reqContext;
        processContext.rsp=rspContext;

        for (BaseProcess process : processes) {
            process.process(processContext);
        }
        return processContext.rsp.resourceSceneDOS;
    }
}
