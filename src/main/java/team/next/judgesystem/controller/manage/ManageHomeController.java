package team.next.judgesystem.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */

@Controller
@RequestMapping(method = RequestMethod.GET)
public class ManageHomeController {
    @RequestMapping(path = "/manage",method = RequestMethod.GET)
    public String home()
    {
        return "/manage/index";
    }
}
