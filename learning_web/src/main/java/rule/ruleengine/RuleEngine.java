package rule.ruleengine;

import parser.RuleParamContext;
import process.RuleProcessParam;
import process.RuleProcessorHolper;
import rule.Rule;
import rule.RuleId;
import strategy.MultiRuleStrategy;

import java.util.*;

/**
 * Created by Administrator on 2017/11/12.
 */
public class RuleEngine<T extends MultiRuleStrategy,RID extends RuleId> {
    //规则执行结果的封装策略
    private T ruleStrategies;
    //有赋予规则的资源列表
    private List<RID> ruleIds;
    private RuleParamContext ruleParamContext;

    private RuleEngine(T ruleStrategies, List<RID> ruleIds, RuleParamContext ruleParamContext) {
        this.ruleStrategies = ruleStrategies;
        this.ruleIds = ruleIds;
        this.ruleParamContext = ruleParamContext;
    }
    public static<T extends MultiRuleStrategy,RID extends RuleId>  RuleEngine of(T ruleStrategies,List<RID> ruleIds){
        return  new RuleEngine(ruleStrategies,ruleIds,null);
    }
    public static<T extends MultiRuleStrategy,RID extends RuleId>  RuleEngine of(T ruleStrategies,List<RID> ruleIds,RuleParamContext ruleParamContext){
        return  new RuleEngine(ruleStrategies,ruleIds,ruleParamContext);
    }
    //解析、执行规则
    public List<RID> execute(){
        RuleProcessParam param = new RuleProcessParam();
        param.ruleIds=ruleIds;
        param.ruleMap=getRules();
        param.ruleStrategies=ruleStrategies;
        param.paramContext=ruleParamContext;

        List<RID> ridList= RuleProcessorHolper.process(param);
        return ridList;
    }

    //获取每个资源与其下的所有规则的映射集合
    private Map<RID,List<Rule>>getRules() {
        Map<RID,List<Rule>> ruleMap =new LinkedHashMap<RID, List<Rule>>();
        List<Long> ruleTemplateIds = new ArrayList<>();
        for (RID ruleId : ruleIds) {
            ruleTemplateIds.addAll(ruleId.getRuleIds());
        }
        //db 获取规则模板id 和规则模板内容
        Map<Long ,List<Rule>> ruleTemplates = new HashMap<>();
        List<Rule> rules = new ArrayList<>();
        for (RID ruleRes : ruleIds) {
            List<Long> queryRuleIds = ruleRes.getRuleIds();//每个资源下面的所有模板Id
            for (Long queryRuleId : queryRuleIds) {
                rules.addAll(ruleTemplates.get(queryRuleId));
            }
            ruleMap.put(ruleRes,rules);
        }
        return ruleMap;
    }
}
