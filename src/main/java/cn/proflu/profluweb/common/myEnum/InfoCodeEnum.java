package cn.proflu.profluweb.common.myEnum;

import lombok.Getter;

@Getter
public enum InfoCodeEnum {

    //新闻相关枚举
    GET_TITLE_LIST(1, "获取栏目信息"),
    USER_CLOOECT_INFO(2, "用户收藏列表"),
    GET_INDIVIDUATION_COMMEND(3, "获取个性化推荐"),
    GET_NEWS_DETAIL(4, "获取新闻内容详情"),
    GET_RELATED_COMMEND(5, "获取相关推荐"),
    USER_FOCUS_TOPIC(6, "用户关注话题列表"),
    GET_TOPIC_LIST(7, "获取话题列表"),
    GET_HOT_TOPIC(8, "获取热门话题"),
    USER_SUB_TOPIC(9, "用户取消或订阅话题"),
    GET_TOPIC_DETAIL(10, "获取话题详情"),
    USER_CLICK_UP(11, "用户点赞"),
    USER_CLICK_DOWN(12, "用户踩话题"),
    USER_DISLIKE(13, "用户不喜欢"),
    KEYWORD_SEARCH(14, "关键词搜索"),

    DATE_FORMAT1(15,"yyyy-MM-dd HH:mm:ss"),
    DATE_FORMAT2(16,"yyyy-MM-dd HH"),

    //用户类型枚举
    USER_LOGIN_TYPE(8, "用户登录类型"),
    SESSION_OUTTIME(1800,"用户登录session缓存时间（秒）");
    ;
    private Integer code;
    private String message;

    InfoCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
