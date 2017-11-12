package process;

import parser.RuleParamContext;
import rule.Rule;
import rule.RuleId;
import rule.RuleParserType;
import strategy.MultiRuleStrategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/12.
 */
public class RuleProcessParam <T extends MultiRuleStrategy, RID extends RuleId>{
    public T ruleStrategies;
    public List<RID> ruleIds;
    public Map<RID,List<Rule>> ruleMap;
    public Set<RuleParserType> ruleParserTypes;
    public RuleParamContext paramContext;

    public Set<RuleParserType> getRuleParserTypes(){
        for (List<Rule> rules : ruleMap.values()) {
            for (Rule rule : rules) {
                ruleParserTypes.add(rule.getRuleParserType());
            }
        }
        return ruleParserTypes;
    }
}
