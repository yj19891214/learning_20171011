package resource;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */
public class SceneDO {
    private Long sceneId;
    //资源内容
    private List<ModuleDO> content;
    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public List<ModuleDO> getContent() {
        return content;
    }

    public void setContent(List<ModuleDO> content) {
        this.content = content;
    }
}
