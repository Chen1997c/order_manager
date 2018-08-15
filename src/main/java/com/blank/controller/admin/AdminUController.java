package com.blank.controller.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.blank.dto.UserDto;
import com.blank.entity.User;
import com.blank.service.UUserService;
import com.blank.util.JsonData;
import com.blank.util.enums.EditEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 功能描述:管理员前端控制器(员工管理)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.07
 */
@Controller
@RequestMapping("/admin")
public class AdminUController {

    @Value("${admin.page.size}")
    private Integer pageSize;

    @Autowired
    private UUserService userService;

    @Value("${spring.user.uploadAvatar.locations}")
    private String path;

    /**
     * 查询员工信息 分页 搜索
     *
     * @param model
     * @param current
     * @param u_name
     * @return
     */
    @RequestMapping("/userList.html")
    public String userManage(Model model, Integer current, String u_name) {
        if (current == null || current <= 0) {
            current = 1;
        }
        Page<UserDto> users = userService.searchByName(current, pageSize, u_name);
        //如果没有记录，则到第一页
        if (users.getRecords().size() == 0) {
            users = userService.searchByName(1, pageSize, u_name);
        }
        model.addAttribute("u_name", u_name);
        model.addAttribute("users", users);
        return "admin/userManage";
    }


    //更新
    @PutMapping("/updateUser")
    @ResponseBody
    public Object updateUser(User user) {
        Integer result = userService.update(user);
        return JsonData.jsonDataResult(result);
    }

    //删除
    @DeleteMapping("/deleteUser")
    @ResponseBody
    public Object deleteUser(Integer id) {
        Integer result = userService.delById(id);
        return JsonData.jsonDataResult(result);
    }

    //增加
    @PostMapping("/addUser")
    @ResponseBody
    public Object addUser(User user) {
        Integer result = userService.add(user);
        return JsonData.jsonDataResult(result);
    }

    //重设密码
    @PutMapping("/resetPass")
    @ResponseBody
    public Object resetPassword(User user) {
        Integer result = userService.resetPassword(user);
        return JsonData.jsonDataResult(result);
    }

    //上传员工头像
    @PostMapping("/uploadAvatar")
    @ResponseBody
    public Object uploadAvatar(MultipartFile file, Integer id) {
        //获取文件大小
        long fileSize = file.getSize();
        if (fileSize > 1024 * 1024 * 3) {
            return JsonData.bulidError(0, "文件大小限制为3MB");
        }
        String fileName = id + "-avatar.jpg";
        File dest = new File(path, fileName);
        try {
            file.transferTo(dest);
            Integer result = userService.updateAvatar("/user_img/" + fileName, id);
            if (result != null)
                return JsonData.buidSuccess(1, EditEnum.SUCCESS.getStateInfo());
            return JsonData.bulidError(0,EditEnum.FAIL.getStateInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonData.bulidError(0, EditEnum.FAIL.getStateInfo());
    }

}
