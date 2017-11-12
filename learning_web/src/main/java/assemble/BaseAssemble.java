package assemble;

import process.Process;

/**
 * Created by Administrator on 2017/11/12.
 */
public abstract class BaseAssemble<Req,Resp> implements Process<Req,Resp> {
    protected abstract boolean beAssemble(Req req);
    protected abstract Resp assemble(Req req);
    public Resp process(Req req) {
        if (!beAssemble(req)){
            return null;
        }

        return assemble(req);
    }
}
