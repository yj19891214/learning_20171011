package process;

import rule.RuleId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class RuleProcessorHolper {
    private static List<RuleProcessor> processorList = new ArrayList<RuleProcessor>(
            (Collection<? extends RuleProcessor>) RichRuleProcessor.getInstance()
    );

    public static <RID extends RuleId> List<RID> process(RuleProcessParam param) {
        for (RuleProcessor ruleProcessor : processorList) {
            ruleProcessor.process(param);
        }
        return param.ruleIds;
    }
}
