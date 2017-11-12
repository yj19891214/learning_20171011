package strategy;

import rule.ruleengine.StrategyType;

/**
 * Created by Administrator on 2017/11/12.
 * 规则处理结果执行策略
 */
public interface RuleStrategy {
    StrategyType getStrategyType();
}
