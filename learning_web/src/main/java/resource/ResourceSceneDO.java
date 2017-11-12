package resource;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ResourceSceneDO implements Cloneable {
    private Long id;
    public List<ResourceSceneDO> subScenes;

    private List<Long> moduleIds;

    public List<ResourceSceneDO> getSubScenes() {
        return subScenes;
    }

    public void setSubScenes(List<ResourceSceneDO> subScenes) {
        this.subScenes = subScenes;
    }

    public List<Long> getModuleIds() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModuleIds(List<Long> moduleIds) {
        this.moduleIds = moduleIds;
    }

    @Override
    public ResourceSceneDO clone() throws CloneNotSupportedException {
        ResourceSceneDO resSceneDO = (ResourceSceneDO) super.clone();
        return resSceneDO;
    }
}
