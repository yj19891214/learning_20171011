package parser;

/**
 * Created by Administrator on 2017/11/12.
 */
public interface RuleParser<T,R> {
    R parseRule(T rule);
    default R parseRule(T rule,RuleParamContext ruleParamContext){
        return  this.parseRule(rule);
    }
}
