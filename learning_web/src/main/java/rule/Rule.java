package rule;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/12.
 */
public interface Rule extends Serializable {
    //规则内容
    String getContent();
    //对应规则的解析类型
    RuleParserType getRuleParserType();
}

