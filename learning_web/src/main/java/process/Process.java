package process;

/**
 * Created by Administrator on 2017/11/12.
 */
public interface Process<Req,Resp> {
    Resp process(Req req);

}
