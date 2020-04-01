package cn.proflu.profluweb.common.myEnum;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    JSCODE_NOT_NULL(5, "用户临时凭证不能为空"),
    GET_USERINFO_FAIL(6, "用户信息获取失败"),
    USER_NOT_LOGIN(7, "用户未登录"),
    SAVE_USER_FAIL(8, "保存用户失败"),
    UPDATE_USER_STATUS(9, "更新用户登录态失败"),
    USER_SESSION_INVALID(10, "用户登录session失效"),
    UPDATE_USER_FAIL(11, "更新用户失败"),
    GET_RESULT_FAIL(12, "获取结果错误"),
    NEWSID_NOT_NULL(13, "新闻标识不能为空"),
    INSERT_USERCOLLECTION_FAIL(14, "用户收藏保存失败"),
    INSERT_USERUP_FAIL(15, "用户点赞保存失败"),
    DELETE_USERUP_FAIL(16, "用户点赞删除失败"),
    GET_ERWEIMA_FAIL(17, "查询二维码失败"),
    GET_USER_FAIL(18, "查询用户失败"),
    CREATE_PERSONALPLAN_FAIL(19,"创建个人计划单失败"),
    GET_COMPANY_FAIL(20,"未查到相应公司"),
    SAVE_FOCUS_FAIL(21,"保存关注失败"),
    DELETE_FOCUS_FAIL(22,"删除关注失败"),
    SAVE_FEEDBACK_FAIL(23,"保存意见反馈失败"),
    GET_PERSONAL_FAIL(24,"未找到改个人计划单"),
    DELETE_USERCOMPANY_FAIL(25,"删除用户选择公司失败"),
    SAVE_USERCOMPANY_FAIL(26,"保存用户选择公司失败"),
    DELETE_USERINDUSTRY_FAIL(27,"删除用户选择行业失败"),
    SAVE_USERINDUSTRY_FAIL(28,"保存用户选择行业失败"),
    DELETE_USERENTREPRENEUR_FAIL(27,"删除用户选择行业失败"),
    SAVE_USERENTREPRENEUR_FAIL(28,"保存用户选择行业失败"),
    USER_NOT_SELECT(29,"用户未选择"),
    NOT_RIGHT_SESSION(-1,"非法session"),
    USER_UID_NULL(30,"用户session不能为空"),
    GET_EXAMUSER_FAIL(31,"获取考试用户信息失败"),
    UPDATE_EXAMUSER_FAIL(31,"更新考试用户信息失败"),
    SAVE_USER_EXAMINFO(32,"保存用户考试信息失败"),
    REMOVE_ORDEREXAM_FAIL(33,"删除用户预约订单错误"),
    SAVE_ORDEREXAM_FAIL(34,"保存用户预约订单错误"),
    UPDATE_EXAMUSERSTATUS_FAIL(35,"更新用户按钮状态失败"),
    CONTAIN_VALID_CHAR(36,"包含非法字符"),
    ;
    private Integer code;
    private String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
