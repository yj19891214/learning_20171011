package process;

import context.PostReqContext;
import context.PostRspContext;
import context.ProcessContext;
import resource.ModuleDO;
import resource.ResourceModuleDO;
import resource.ResourceSceneDO;
import resource.SceneDO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ModulePostProcessor {
    private static ModulePostProcessor instance = new ModulePostProcessor();

    public static ModulePostProcessor getInstance() {
        return instance;
    }

    private ModulePostProcessor() {
    }
    private static List<BaseProcess<ProcessContext<PostReqContext, PostRspContext>,Void>> processes =new ArrayList<>();

    public static List<SceneDO> postProcess(ResourceSceneDO resourceSceneDO, ResourceSceneDO subScene, List<ResourceModuleDO> resourceModuleDOS, List<ModuleDO> moduleDOS) {
        PostReqContext reqContext = new PostReqContext();
        reqContext.reqSceneDO=resourceSceneDO;
        reqContext.subSceneDO=subScene;
        reqContext.resourceModuleDOS=resourceModuleDOS;
        reqContext.moduleDOS=moduleDOS;

        PostRspContext rspContext = new PostRspContext();
        initRspContext(rspContext,resourceSceneDO,subScene,moduleDOS);

        ProcessContext<PostReqContext,PostRspContext> context = new ProcessContext<>();
        context.req=reqContext;
        context.rsp=rspContext;
        for (BaseProcess process : processes) {
            process.process(context);
        }
        return context.rsp.sceneDOS;
    }

    //初始化处理结果集，如果未走处理流程，则返回初始值
    private static void initRspContext(PostRspContext rspContext, ResourceSceneDO resourceSceneDO, ResourceSceneDO subScene, List<ModuleDO> moduleDOS) {
        List<SceneDO> sceneDOS = new ArrayList<>();
        SceneDO sceneDO = new SceneDO();
        sceneDO.setSceneId(resourceSceneDO.getId());
        //.....
        sceneDO.setContent(moduleDOS);
        sceneDOS.add(sceneDO);

        rspContext.sceneDOS=sceneDOS;
    }
}
