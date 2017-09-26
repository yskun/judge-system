package team.next.judgesystem.controller.manage.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.next.judgesystem.model.UserMEntity;
import team.next.judgesystem.receiver.UserReceiver;
import team.next.judgesystem.repo.UserMRepository;

import java.util.List;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */

@Controller
public class AdministratorController {

    private final UserMRepository userMRepository;

    @Autowired
    public AdministratorController(UserMRepository userMRepository) {
        this.userMRepository = userMRepository;
    }

    @RequestMapping(value = "/manage/admin")
    public String index(ModelMap modelMap) {
        List<UserMEntity> userMEntityList = userMRepository.findAll();
        modelMap.addAttribute("users",userMEntityList);
        return "/manage/administrator/index";
    }

    @RequestMapping(value = "/manage/admin/detail/{user}/")
    public String detail(ModelMap modelMap, @PathVariable("user") String user) {
        UserMEntity userMEntityList = userMRepository.findByEmail(user);
        modelMap.addAttribute("users",userMEntityList);
        return "/manage/administrator/detail";
    }

    @RequestMapping(value = "/manage/admin/del/{user}/")
    public String del(ModelMap modelMap, @PathVariable("user") String user) {
        UserMEntity userMEntityList = userMRepository.findByEmail(user);
        modelMap.addAttribute("users",userMEntityList);
        return "/manage/administrator/del";
    }

    @RequestMapping(value = "/manage/admin/edit/{user}/")
    public String edit(ModelMap modelMap, @PathVariable("user") String user) {
        UserMEntity userMEntityList = userMRepository.findByEmail(user);
        modelMap.addAttribute("users",userMEntityList);
        return "/manage/administrator/edit";
    }

    @RequestMapping(value = "/manage/admin/new")
    public String newUser() {
        return "/manage/administrator/new";
    }

    @RequestMapping(value = "/manage/admin/new",method = RequestMethod.POST)
    public String newUser(UserReceiver userReceiver) {
        UserMEntity userMEntity = new UserMEntity();
        userMEntity.setEmail(userReceiver.getEmail());
        userMEntity.setPassword(userReceiver.getPassword());
        userMEntity.setTel(userReceiver.getTel());
        userMEntity.setUserRole("Admin");
        userMRepository.save(userMEntity);
        return "redirect:/manage/admin";
    }

    @RequestMapping(value = "/manage/admin/edit/{user}/",method = RequestMethod.POST)
    public String editUser(UserReceiver userReceiver, @PathVariable("user") String user) {
        UserMEntity userMEntity = userMRepository.findByEmail(user);
        userMEntity.setPassword(userReceiver.getPassword());
        userMEntity.setTel(userReceiver.getTel());
        userMEntity.setUserRole("Admin");
        userMRepository.save(userMEntity);
        return "redirect:/manage/admin";
    }

    @RequestMapping(value = "/manage/admin/del/{user}/",method = RequestMethod.POST)
    public String delUser( @PathVariable("user") String user) {
        UserMEntity userMEntity = userMRepository.findByEmail(user);
        userMRepository.delete(userMEntity);
        return "redirect:/manage/admin";
    }
}
