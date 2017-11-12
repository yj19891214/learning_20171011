package assemble;

/**
 * Created by Administrator on 2017/11/12.
 */
public abstract class RichAssemble<Req extends RichReq,Resp> extends BaseAssemble<Req,Resp> {
    @Override
    protected boolean beAssemble(Req req) {
        return req.rule != null && req.ruleRes != null
                && req.richStrategyMap!=null&& req.ruleParamContext!=null;
    }
}
