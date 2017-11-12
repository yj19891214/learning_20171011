package assemble;

import resource.*;
import strategy.EnrichStrategy;
import strategy.MultiRuleStrategy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/11/13.
 */
public class SceneAssembleCallable implements Callable<Map<SceneRespDO, List<ModuleDO>>> , MultiRuleStrategy{
    private SceneQueryDO sceneQueryDO;
    private List<ResourceSceneDO> resourceSceneDOS;
    private Map<Long,ResourceModuleDO> allModuleMap;


    public static SceneAssembleCallable of(SceneQueryDO sceneQueryDO, List<ResourceSceneDO> res, Map<Long, ResourceModuleDO> allModuleMap) {
        SceneAssembleCallable sceneAssembleCallable = new SceneAssembleCallable();
        sceneAssembleCallable.sceneQueryDO = sceneQueryDO;
        sceneAssembleCallable.resourceSceneDOS = res;
        sceneAssembleCallable.allModuleMap = allModuleMap;
        return sceneAssembleCallable;
    }

    @Override
    public Map<SceneRespDO, List<ModuleDO>> call() throws Exception {

        return doAssemble();
    }

    private Map<SceneRespDO,List<ModuleDO>> doAssemble() {
        for (ResourceSceneDO subResourceSceneDO : resourceSceneDOS) {
            //查询坑位信息
            List<Long> moduleIds = subResourceSceneDO.getModuleIds();
            //....一下处理内容和sceneAssemble 一样
        }
        return null;
    }

    @Override
    public List<EnrichStrategy> getRichRuleStrategies() {
        return SceneAssemble.getInstance().getRichRuleStrategies();
    }
}
