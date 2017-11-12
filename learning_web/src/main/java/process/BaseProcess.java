package process;

/**
 * Created by Administrator on 2017/11/12.
 */
public  abstract class BaseProcess<Req,Resp> implements Process<Req,Resp> {
    protected abstract boolean beProcess(Req req);
    protected abstract Resp doProcess(Req req);
    public Resp process(Req req) {
        if (!beProcess(req)){
            return null;
        }
        return doProcess(req);
    }
}
