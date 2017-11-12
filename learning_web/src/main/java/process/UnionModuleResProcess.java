package process;

import context.CustomReq;
import context.ProcessContext;
import resource.ModuleDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 * 合并模块资源，多个坑位的素材到一个坑位上来
 */
public class UnionModuleResProcess extends BaseProcess<ProcessContext<CustomReq,Void>,Void> {
    private static UnionModuleResProcess instance = new UnionModuleResProcess();

    public static UnionModuleResProcess getInstance() {
        return instance;
    }

    private UnionModuleResProcess() {
    }

    @Override
    protected boolean beProcess(ProcessContext<CustomReq, Void> processContext) {
        return false;
    }

    @Override
    protected Void doProcess(ProcessContext<CustomReq, Void> processContext) {
        List<ModuleDO> moduleDOS = processContext.req.moduleDOS;
        List resources=new ArrayList();
        for (ModuleDO moduleDO : moduleDOS) {
            resources.addAll(moduleDO.resources);
        }
        ModuleDO moduleDO = new ModuleDO();
        moduleDO.resources=resources;
        processContext.req.moduleDOS=new ArrayList((Collection) moduleDO);

        return null;
    }
}
