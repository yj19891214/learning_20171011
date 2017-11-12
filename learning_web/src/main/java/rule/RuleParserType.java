package rule;

/**
 * Created by Administrator on 2017/11/12.
 */
public enum RuleParserType {
    demo(1,"例子");
    private int type;
    private String desc;

    RuleParserType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
