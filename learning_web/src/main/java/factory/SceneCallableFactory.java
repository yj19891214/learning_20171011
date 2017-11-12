package factory;

import assemble.SceneAssemble;
import assemble.SceneAssembleCallable;
import resource.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/11/13.
 */
public class SceneCallableFactory {
    public static Callable<Map<SceneRespDO,List<ModuleDO>>> getSceneCallable(SceneQueryDO sceneQueryDO, List<ResourceSceneDO> res, Map<Long, ResourceModuleDO> allModuleMap) {
        return SceneAssembleCallable.of(sceneQueryDO,res,allModuleMap);
    }
}
