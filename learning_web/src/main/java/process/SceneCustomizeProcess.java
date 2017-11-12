package process;

import context.CustomReq;
import context.ProcessContext;
import resource.ModuleDO;
import resource.ResourceModuleDO;
import resource.ResourceSceneDO;
import resource.SceneQueryDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/12.
 */
public class SceneCustomizeProcess {
    private static SceneCustomizeProcess instance = new SceneCustomizeProcess();

    public static SceneCustomizeProcess getInstance() {
        return instance;
    }

    private SceneCustomizeProcess() {
    }

    private static List<BaseProcess<ProcessContext<CustomReq,Void>,Void>> processes = new ArrayList(
            (Collection) UnionModuleResProcess.getInstance()
    );


    public List<ModuleDO> customizeProcess(SceneQueryDO sceneQureyDO, ResourceSceneDO subScene, List<ModuleDO> moduleDOS, Map<Long, ResourceModuleDO> allModuleMap) {
       CustomReq customReq = new CustomReq();
       customReq.subCurSceneDO=subScene;
       customReq.allModuleMap=allModuleMap;
       customReq.moduleDOS=moduleDOS;

        ProcessContext<CustomReq,Void> context  =new ProcessContext<>();
        context.req=customReq;
        for (BaseProcess process : processes) {
            process.process(context);
        }
        return context.req.moduleDOS;
    }
}
