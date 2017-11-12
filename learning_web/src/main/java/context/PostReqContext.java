package context;

import resource.ModuleDO;
import resource.ResourceModuleDO;
import resource.ResourceSceneDO;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class PostReqContext {
    public List<ResourceModuleDO> resourceModuleDOS;

    public List<ModuleDO> moduleDOS;

    public ResourceSceneDO reqSceneDO;

    public ResourceSceneDO subSceneDO;
}
