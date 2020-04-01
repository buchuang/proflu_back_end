package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.common.myEnum.InfoCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.common.utils.DateUtil;
import cn.proflu.profluweb.common.utils.UDateToLocalTime;
import cn.proflu.profluweb.pojo.wx.WxEntranceExam;
import cn.proflu.profluweb.pojo.wx.WxOrderExam;
import cn.proflu.profluweb.pojo.wx.WxUserExamprocess;
import cn.proflu.profluweb.service.wx.WxEntranceExamService;
import cn.proflu.profluweb.service.wx.WxOrderExamService;
import cn.proflu.profluweb.service.wx.WxUserExamprocessService;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 考试流程接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-17
 */
@RestController
@RequestMapping("/vipSystem/wxapp/exam")
@Api(value = "考试流程", tags = "考试流程的接口")
public class WxUserExamprocessController {
    /**
     * 用户信息service
     */
    @Autowired
    private WxUserinfoService wxUserinfoService;
    /**
     * 用户考试流程service
     */
    @Autowired
    private WxUserExamprocessService wxUserExamprocessService;
    /**
     * 用户第一次考试service(填写培养计划)
     */
    @Autowired
    private WxEntranceExamService wxEntranceExamService;
    /**
     * 用户预约考试service
     */
    @Autowired
    private WxOrderExamService wxOrderExamService;
    /**
     * activiti5 运行时service
     */
    @Resource
    private RuntimeService runtimeService;
    /**
     * activiti5 部署service
     */
    @Resource
    private RepositoryService repositoryService;
    /**
     * activiti5 任务service
     */
    @Resource
    private TaskService taskService;


    /**
     * 保存用户提交的个人培养计划单，并为该用户开启流程
     *
     * @param uid            用户登录session
     * @param wxEntranceExam 考试1表单对象
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户个人培养答案")
    @GetMapping("/examOne")
    public Map examOneAnswer(String uid, WxEntranceExam wxEntranceExam) throws Exception {
        //保存用户个人培养答案
        System.out.println(uid);
        System.out.println(wxEntranceExam);
        String openid = wxUserinfoService.findOpenidByUid(uid);
        System.out.println(uid);
        wxEntranceExam.setEeOpenid(openid);
        wxEntranceExam.setEeSubmissiontime(DateUtil.format(new Date(), InfoCodeEnum.DATE_FORMAT1.getMessage()));
        wxEntranceExamService.addExamOneAnswer(wxEntranceExam);
        //开启流程实例
        ProcessDefinition pd = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionKey("myProcess_1")
                .latestVersion()
                .singleResult();
        ProcessInstance pi = runtimeService.startProcessInstanceById(pd.getId());

        //用户绑定流程实例
        WxUserExamprocess wxUserExamprocess = new WxUserExamprocess();
        wxUserExamprocess.setUeOpenid(openid);
        wxUserExamprocess.setUeUsername(wxEntranceExam.getEeName());
        wxUserExamprocess.setUeCreatetime(DateUtil.format(new Date(), InfoCodeEnum.DATE_FORMAT1.getMessage()));
        wxUserExamprocess.setUePiid(pi.getId());
        wxUserExamprocess.setUeExamGrade(2);
        wxUserExamprocessService.addUserExamprocess(wxUserExamprocess);
        finishTask(pi.getId());
        return Const.SUCCESS_RESPONSE;
    }

    /**
     * 获取用户考试流程信息
     *
     * @param uid 用户登录session
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取考试用户信息")
    @GetMapping("/findExamUser")
    public WxUserExamprocess findExamUser(String uid) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        WxUserExamprocess wxUserExamprocess = wxUserExamprocessService.findByOpenid(openid);
        return wxUserExamprocess;
    }

    /**
     * 获取用户预约信息
     *
     * @param uid 用户登录session
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取用户预约信息")
    @GetMapping("/getOrderInfo")
    public WxOrderExam getOrderInfo(String uid) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        WxOrderExam WxOrderExam = wxOrderExamService.findByOpenid(openid);
        return WxOrderExam;
    }


    /**
     * 保存用户预约考试信息
     *
     * @param uid         用户登录session
     * @param wxOrderExam 预约考试表单信息
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户预约信息")
    @GetMapping("/addOrderExam")
    public Map addOrderExam(String uid, WxOrderExam wxOrderExam) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        wxOrderExam.setOeOpenid(openid);
        wxOrderExamService.addOrderExam(wxOrderExam);

        WxUserExamprocess wxUserExamprocess = wxUserExamprocessService.findByOpenid(openid);
        wxUserExamprocess.setUeUserStatus(2);
        wxUserExamprocessService.editButtonStatus(wxUserExamprocess);

        String piid = wxUserExamprocess.getUePiid();
        finishTask(piid);
        return Const.SUCCESS_RESPONSE;
    }


    /**
     * 判断是否到考试时间
     *
     * @param uid 用户登录session
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "判断预约时间")
    @GetMapping("/isNowTime")
    public Integer isNowTime(String uid) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        WxOrderExam wxOrderExam = wxOrderExamService.findByOpenid(openid);
        LocalDateTime orderTime = wxOrderExam.getOeExamtime();
        LocalDateTime now = UDateToLocalTime.getDateToLocalTime(new Date());
        if (orderTime.getYear() == now.getYear() && orderTime.getMonth() == now.getMonth() && orderTime.getDayOfMonth() == now.getDayOfMonth()) {
            return 1;
        }
        return 0;
    }

    /**
     * 用户点击开始考试完成考试节点任务
     *
     * @param uid 用户登录session
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "用户点击开始考试，更改按钮状态")
    @GetMapping("/startExam")
    public Map startExam(String uid) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        WxUserExamprocess wxUserExamprocess = wxUserExamprocessService.findByOpenid(openid);
        wxUserExamprocess.setUeUserStatus(4);
        wxUserExamprocessService.editButtonStatus(wxUserExamprocess);

        String piid = wxUserExamprocess.getUePiid();
        finishTask(piid);
        return Const.SUCCESS_RESPONSE;
    }


    /**
     * 通过流程实例完成任务节点
     *
     * @param piid 流程实例id
     * @throws Exception
     */
    public void finishTask(String piid) throws Exception {
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(piid).list();
        taskService.complete(tasks.get(0).getId());
    }

    /**
     * 更新考试用户观看视频状态
     *
     * @param uid
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "判断视频是否完成")
    @GetMapping("/updateVideoStatus")
    public Map updateVideoStatus(String uid) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        wxUserExamprocessService.editVideoStatus(openid);
        return Const.SUCCESS_RESPONSE;
    }
}
