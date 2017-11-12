package strategy;

import strategy.EnrichStrategy;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public interface MultiRuleStrategy {
    List<EnrichStrategy> getRichRuleStrategies();
}
