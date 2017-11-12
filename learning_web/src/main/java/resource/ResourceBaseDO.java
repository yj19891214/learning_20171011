package resource;

import rule.RuleId;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ResourceBaseDO extends RuleId implements Serializable {
    @Override
    public List<Long> getRuleIds() {
        return null;
    }
}
