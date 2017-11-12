package assemble;

import parser.RuleParamContext;
import rule.Rule;
import rule.RuleId;
import strategy.EnrichStrategy;
import rule.ruleengine.StrategyType;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/12.
 */
public class RichReq {
    public Map<StrategyType,EnrichStrategy> richStrategyMap;
    public Rule rule;
    public RuleId ruleRes;
    public RuleParamContext ruleParamContext;

    public static RichReq of(Map richStrategyMap,Rule rule,RuleId ruleId,RuleParamContext ruleParamContext){
        RichReq richReq = new RichReq();
        richReq.richStrategyMap=richStrategyMap;
        richReq.rule=rule;
        richReq.ruleRes =ruleId;
        richReq.ruleParamContext=ruleParamContext;
        return richReq;
    }
}
