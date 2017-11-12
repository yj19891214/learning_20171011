package parser;

import rule.HourCountdownRule;
import strategy.RuleStrategy;
import rule.ruleengine.StrategyType;

/**
 * Created by Administrator on 2017/11/12.
 */
public class HourCountdownRuleParser implements RuleParser<HourCountdownRule,Integer>,RuleStrategy {
    private static HourCountdownRuleParser instance = new HourCountdownRuleParser();

    public static HourCountdownRuleParser getInstance() {
        return instance;
    }

    private HourCountdownRuleParser() {
    }

    @Override
    public Integer parseRule(HourCountdownRule rule) {
        //解析规则
        return null;
    }

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.RICH_HOUR_COUNTDOWN;
    }
}
