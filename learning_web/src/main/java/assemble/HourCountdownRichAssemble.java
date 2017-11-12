package assemble;


import parser.HourCountdownRuleParser;
import rule.HourCountdownRule;
import strategy.EnrichStrategy;

/**
 * Created by Administrator on 2017/11/12.
 */
public class HourCountdownRichAssemble extends RichAssemble<RichReq,Boolean> {
    @Override
    protected Boolean assemble(RichReq richReq) {
    HourCountdownRuleParser instance= HourCountdownRuleParser.getInstance();
        Integer parseRes = instance.parseRule((HourCountdownRule) richReq.rule);
        EnrichStrategy enrichStrategy = richReq.richStrategyMap.get(instance.getStrategyType());
        if (null != parseRes){
            enrichStrategy.enrich(richReq.ruleRes,parseRes);
        }
        return null;
    }
}
