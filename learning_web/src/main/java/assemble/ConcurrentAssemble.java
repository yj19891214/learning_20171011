package assemble;

import assemble.repo.ThreadPoolRepo;
import factory.SceneCallableFactory;
import resource.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/11/13.
 */
public class ConcurrentAssemble extends BaseAssemble<List<SceneQueryDO>,List<SceneDO>> {
    private static ConcurrentAssemble ourInstance = new ConcurrentAssemble();

    public static ConcurrentAssemble getInstance() {
        return ourInstance;
    }

    private ConcurrentAssemble() {
    }

    @Override
    protected boolean beAssemble(List<SceneQueryDO> sceneQueryDOS) {
        return true;
    }

    @Override
    protected List<SceneDO> assemble(List<SceneQueryDO> sceneQueryDOS) {
        //getModule
        Map<Long, ResourceModuleDO> allModuleMap= new HashMap<>();
        //构建callable
        List<Callable<Map<SceneRespDO,List<ModuleDO>>>> callables = new ArrayList<>();
        //楼层顺序，并行请求后排序用
        final List<Pair<SceneQueryDO,List<ResourceSceneDO>>> correctSceneList=new ArrayList<>();
        sceneQueryDOS.forEach(sceneQueryDO -> {
            List<List<ResourceSceneDO>> resources=splitScene(sceneQueryDO);
            resources.forEach(res ->{
                callables.add(SceneCallableFactory.getSceneCallable(sceneQueryDO,res,allModuleMap));
                correctSceneList.add(Pair.of(sceneQueryDO,res));
            } );
        });
        //并行组装moduleDO
        Map<SceneRespDO,List<ModuleDO>> resultMap=concurrencyAssembleModule(callables);
        Map<Long,List<ModuleDO>> moduleMap= new HashMap<>();
        for (Map.Entry<SceneRespDO, List<ModuleDO>> entry : resultMap.entrySet()) {
            SceneRespDO key = entry.getKey();
            moduleMap.put(key.sceneId,entry.getValue());
        }
        //组装sceneDO

        return null;
    }
    //并发组装坑位
    private Map<SceneRespDO,List<ModuleDO>> concurrencyAssembleModule(List<Callable<Map<SceneRespDO, List<ModuleDO>>>> callables) {
            Map<SceneRespDO,List<ModuleDO>> resultMap = new HashMap<>();
        try {
            List<Future<Map<SceneRespDO, List<ModuleDO>>>> futures = ThreadPoolRepo.newExecutorService().invokeAll(callables);
            for (Future<Map<SceneRespDO, List<ModuleDO>>> future : futures) {
                Map<SceneRespDO, List<ModuleDO>> futuresMap = future.get();
                resultMap.putAll(futuresMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }


    private List<List<ResourceSceneDO>> splitScene(SceneQueryDO sceneQueryDO) {
        return null;
    }
}
