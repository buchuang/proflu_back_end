package cn.proflu.profluweb.VO.wx;

import lombok.Data;

import java.util.List;

@Data
public class NewsParamInfo {
    private String uid;
    private String guid;
    private String dt;
    private String plt;
    private String topic_id;
    private String type;
    private String id;
    private String iid;
    private List<CheckedIndustry> ids;
}
