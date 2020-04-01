package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.pojo.wx.WxMeetingInfo;
import cn.proflu.profluweb.pojo.wx.WxOrderExam;
import cn.proflu.profluweb.service.wx.WxMeetingInfoService;
import cn.proflu.profluweb.service.wx.WxOrderExamService;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会议信息
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-18
 */
@RestController
@RequestMapping("/wxapp/meeting")
@Api(value = "会议信息", tags = "会议信息的接口")
public class WxMeetingInfoController {
    /**
     * webex会议信息service
     */
    @Autowired
    private WxMeetingInfoService wxMeetingInfoService;
    /**
     * 预约考试service
     */
    @Autowired
    private WxOrderExamService wxOrderExamService;

    /**
     * 获取所有可用会议信息
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取所有可用会议信息")
    @GetMapping("/findMeetingInfoList")
    public List<WxMeetingInfo> findMeetingInfoList() throws Exception {
        List<WxMeetingInfo> meetingInfos = wxMeetingInfoService.findMeetingInfoList();

        List<WxMeetingInfo> meetingInfoList = new ArrayList<WxMeetingInfo>();

        for (WxMeetingInfo meetingInfo : meetingInfos) {
            String orderTime = meetingInfo.getMiOrdertime();
            List<WxOrderExam> wxOrderExams = wxOrderExamService.findByOrderTime(orderTime);
            if (wxOrderExams.size() < 10) {
                meetingInfoList.add(meetingInfo);
            }
        }
        return meetingInfoList;
    }
}
