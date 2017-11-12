package process;

import context.PreReqContext;
import context.PreRspContext;
import context.ProcessContext;
import resource.ResourceSceneDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/11/12.
 * <p>
 * 合并模块为坑位
 */
public class UnionScene2moduleProcess extends BaseProcess<ProcessContext<PreReqContext, PreRspContext>, Void> {
    private static UnionScene2moduleProcess instance = new UnionScene2moduleProcess();

    public static UnionScene2moduleProcess getInstance() {
        return instance;
    }

    private UnionScene2moduleProcess() {
    }

    @Override
    protected boolean beProcess(ProcessContext<PreReqContext, PreRspContext> preContext) {
        return false;
    }

    @Override
    protected Void doProcess(ProcessContext<PreReqContext, PreRspContext> preContext) {
        ResourceSceneDO resourceSceneDO = preContext.req.resourceSceneDO;
        List<Long> moduleIds = new ArrayList<>();
        for (ResourceSceneDO subSceneDO : resourceSceneDO.getSubScenes()) {
            moduleIds.addAll(subSceneDO.getModuleIds());
        }
        try {
            ResourceSceneDO newSceneDO = resourceSceneDO.clone();
            newSceneDO.setModuleIds(moduleIds);
            newSceneDO.setSubScenes(new ArrayList((Collection) newSceneDO));
            preContext.rsp.resourceSceneDOS = new ArrayList((Collection) newSceneDO);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
