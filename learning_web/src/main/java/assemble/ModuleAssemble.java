package assemble;

import factory.ModuleQueryDO;
import factory.ResourceAssembleFactory;
import factory.ResourceFactory;
import resource.BaseResourceDO;
import resource.ModuleDO;
import resource.ResourceBaseDO;
import rule.ruleengine.RuleEngine;
import strategy.EnrichStrategy;
import strategy.HourCountdownEnrichStratery;
import strategy.MultiRuleStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ModuleAssemble<Origin extends ResourceBaseDO>
        extends BaseAssemble<ModuleQueryDO, ModuleDO> implements MultiRuleStrategy {
    @Override
    public List<EnrichStrategy> getRichRuleStrategies() {
        List<EnrichStrategy> enrichStrategies = new ArrayList<>();
        enrichStrategies.add(HourCountdownEnrichStratery.getInstance());
        return enrichStrategies;
    }

    @Override
    protected boolean beAssemble(ModuleQueryDO moduleQueryDO) {
        return false;
    }

    @Override
    protected ModuleDO assemble(ModuleQueryDO moduleQueryDO) {
        //处理逻辑

        //查询资源
        List<Origin> resource = ResourceFactory.queryResource(moduleQueryDO);
        //执行规则
        List<Origin> ruleRes = RuleEngine.of(this, resource).execute();
        List<? extends BaseResourceDO> resourceDOS = doAssemble(ruleRes, moduleQueryDO);
        return null;
    }

    private List<? extends BaseResourceDO> doAssemble(List<Origin> ruleRes, ModuleQueryDO moduleQueryDO) {
        ResourceAssemble resourceAssemble = ResourceAssembleFactory.getResourceAssemble(moduleQueryDO);
       return (List<? extends BaseResourceDO>) resourceAssemble.process(moduleQueryDO);
    }
}
