package process;

import org.springframework.util.CollectionUtils;
import rule.RuleId;
import strategy.MultiRuleStrategy;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public abstract class RuleProcessor<RID extends RuleId> extends BaseProcess<RuleProcessParam<MultiRuleStrategy, RuleId>, List<RID>> {
    @Override
    protected boolean beProcess(RuleProcessParam<MultiRuleStrategy, RuleId> param) {
        return param!=null && !CollectionUtils.isEmpty(param.ruleIds)
                && !CollectionUtils.isEmpty(param.ruleMap)
                && !CollectionUtils.isEmpty(param.getRuleParserTypes());
    }
}
