package process;

import assemble.RichAssemble;
import assemble.RichReq;
import factory.RichRuleAssembleFactory;
import org.springframework.util.CollectionUtils;
import rule.Rule;
import rule.RuleId;
import strategy.EnrichStrategy;
import strategy.MultiRuleStrategy;
import rule.ruleengine.StrategyType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/12.
 */
public class RichRuleProcessor extends RuleProcessor<RuleId> {
    private static RichRuleProcessor instance = new RichRuleProcessor();
    public static RichRuleProcessor getInstance(){
        return instance;
    }
    private RichRuleProcessor() {
    }

    @Override
    protected List<RuleId> doProcess(RuleProcessParam<MultiRuleStrategy, RuleId> param) {
        Map<RuleId, List<Rule>> ruleMap = param.ruleMap;
        List<EnrichStrategy> richRuleStrategies = param.ruleStrategies.getRichRuleStrategies();
        Map<StrategyType, EnrichStrategy> ricStrategyMap = new HashMap<>();
        for (EnrichStrategy richRuleStrategy : richRuleStrategies) {
            ricStrategyMap.put(richRuleStrategy.getStrategyType(), richRuleStrategy);
        }
        List<RuleId> reList = new ArrayList<>();
        for (RuleId ruleId : param.ruleIds) {
            List<Rule> rules = ruleMap.get(ruleId);
            if (CollectionUtils.isEmpty(rules)) {
                reList.add(ruleId);
                continue;
            }
            for (Rule rule : rules) {
             RichAssemble richAssemble=   RichRuleAssembleFactory.getRichAseemble(rule.getRuleParserType());
                richAssemble.process(RichReq.of(ricStrategyMap,rule,ruleId,param.paramContext));
            }
        }
        param.ruleIds=reList;
        return reList;
    }

}
