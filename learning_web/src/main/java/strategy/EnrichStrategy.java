package strategy;

/**
 * Created by Administrator on 2017/11/12.
 * 资源执行策略
 */
public interface EnrichStrategy<T,R> extends RuleStrategy {
    /**
     *
     * @param res  规则处理生成的内容类型
     * @param result
     */
    void enrich(T res,R result);
}
