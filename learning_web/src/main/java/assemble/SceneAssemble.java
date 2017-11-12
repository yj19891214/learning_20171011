package assemble;

import process.ModulePostProcessor;
import process.SceneCustomizeProcess;
import process.ScenePreProcessor;
import resource.*;
import rule.ruleengine.RuleEngine;
import strategy.EnrichStrategy;
import strategy.MultiRuleStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/12.
 */
public class SceneAssemble extends BaseAssemble<List<SceneQueryDO>, List<SceneDO>> implements MultiRuleStrategy {
    @Override
    public List<EnrichStrategy> getRichRuleStrategies() {
        return null;
    }

    @Override
    protected boolean beAssemble(List list) {
        return false;
    }

    @Override
    protected List<SceneDO> assemble(List<SceneQueryDO> sceneQuryDOS) {
        Map<Long, ResourceModuleDO> allModuleMap = new HashMap();//楼下对应的坑位
        List<SceneDO> sceneDOS = new ArrayList<>();
        sceneQuryDOS.forEach(sceneQuryDO -> {
            List<SceneDO> assembleRes = null;
            assembleRes = doAssemble(sceneQuryDO, allModuleMap);
            sceneDOS.addAll(assembleRes);
        });
        return sceneDOS;
    }

    private List<SceneDO> doAssemble(SceneQueryDO sceneQureyDO, Map<Long, ResourceModuleDO> allModuleMap) {
        List<ResourceSceneDO> subScenes = sceneQureyDO.resourceSceneDO.getSubScenes();
        //预处理
        subScenes = ScenePreProcessor.preProcess(sceneQureyDO.resourceSceneDO);
        List<SceneDO> sceneDOS = new ArrayList<>();
        for (ResourceSceneDO subScene : subScenes) {
            //查询坑位信息
            List<Long> moduleIds = subScene.getModuleIds();
            //根据moduleIds 查询坑位
            List<ResourceModuleDO> resourceModuleDOS = getModules(moduleIds, allModuleMap);
            //执行规则
            RuleEngine.of(this, resourceModuleDOS).execute();
            //assemble module
            List<ModuleDO> moduleDOS = doAssemble(resourceModuleDOS, subScene, sceneQureyDO);
            //流程内容自定义处理
            moduleDOS = SceneCustomizeProcess.getInstance().customizeProcess(sceneQureyDO, subScene, moduleDOS, allModuleMap);

            sceneDOS.addAll(ModulePostProcessor.postProcess(sceneQureyDO.resourceSceneDO, subScene, resourceModuleDOS, moduleDOS));
        }
        return sceneDOS;
    }

    private List<ModuleDO> doAssemble(List<ResourceModuleDO> resourceModuleDOS, ResourceSceneDO subScene, SceneQueryDO sceneQureyDO) {
        return null;
    }


    private List<ResourceModuleDO> getModules(List<Long> moduleIds, Map<Long, ResourceModuleDO> allModuleMap) {
        return null;
    }
}
