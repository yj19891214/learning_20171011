package factory;

import assemble.BaseAssemble;
import assemble.ModuleAssemble;
import resource.ResourceModuleDO;
import resource.ResourceSceneDO;

/**
 * Created by Administrator on 2017/11/13.
 */
public class ModuleAssembleFactory {
    public static BaseAssemble getModuleAssemble(ResourceModuleDO resModuleDO, ResourceSceneDO subScene) {
        return new ModuleAssemble();
    }
}
