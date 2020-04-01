package cn.proflu.profluweb.controller.wx;

import cn.proflu.profluweb.common.utils.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 部署流程接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-13
 */
@RestController
@RequestMapping("/wxapp/process")
@Api(value = "部署流程", tags = "部署流程的接口")
public class WxExamProcessController {

    /**
     * 部署流程定义service
     */
    @Resource
    private RepositoryService repositoryService;

    /**
     * 部署流程
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "部署考试流程")
    @GetMapping("/ProcessDeployment")
    public Map ProcessDeployment()throws Exception{
        Deployment deployment=repositoryService
                                    .createDeployment()
                                    .name("考试流程")
                                    .addClasspathResource("diagrams/exam.bpmn")
                                    .addClasspathResource("diagrams/exam.png")
                                    .deploy();
        return Const.SUCCESS_RESPONSE;
    }
}
