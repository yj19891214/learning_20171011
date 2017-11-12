package resource;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ModuleDO<T,A> extends ModuleBaseDO {
    //坑位所有资源
    public List<T> resources;
    public Long mid;
    //自定义对象
    public A attach;

}
