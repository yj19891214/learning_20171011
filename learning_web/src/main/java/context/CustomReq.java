package context;

import resource.ModuleDO;
import resource.ResourceModuleDO;
import resource.ResourceSceneDO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/12.
 */
public class CustomReq {

    public ResourceSceneDO subCurSceneDO;
    public Map<Long, ResourceModuleDO> allModuleMap;
    public List<ModuleDO> moduleDOS;
}
