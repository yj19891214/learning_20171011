package factory;

import resource.ModuleDO;
import resource.ResourceModuleDO;
import resource.ResourceSceneDO;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ModuleQueryDO {
    public ResourceModuleDO resModule;
    public List<ModuleDO> moduleDOS;
    public ResourceSceneDO resScene;//楼层信息
    public ResourceSceneDO curScene;//模块信息



    public static ModuleQueryDO of(ResourceSceneDO resourceSceneDO, ResourceSceneDO subScene, ResourceModuleDO resModuleDO) {
    return  null;
    }
}
