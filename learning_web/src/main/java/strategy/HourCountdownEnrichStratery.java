package strategy;

import rule.ruleengine.StrategyType;

/**
 * Created by Administrator on 2017/11/12.
 * 规则处理结果的执行策略
 */
public class HourCountdownEnrichStratery<T,R>  implements EnrichStrategy<T,R>{
    private HourCountdownEnrichStratery() {
    }
    private static  HourCountdownEnrichStratery instance = new HourCountdownEnrichStratery();

    public static HourCountdownEnrichStratery getInstance(){
        return  instance;
    }


    @Override
    public StrategyType getStrategyType() {
        return StrategyType.RICH_HOUR_COUNTDOWN;
    }

    @Override
    public void enrich(T res, R result) {
        if ( res ==null){
            return;
        }
        //res.setAttach(result)  将处理的结果放到T 里面
    }
}
