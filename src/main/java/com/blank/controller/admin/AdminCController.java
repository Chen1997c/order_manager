package com.blank.controller.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.blank.controller.BaseController;
import com.blank.entity.Custom;
import com.blank.service.CCustomService;
import com.blank.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 功能描述:管理员前端控制器(顾客管理)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
@Controller
@RequestMapping("/admin")
public class AdminCController extends BaseController {

    @Value("${admin.page.size}")
    private Integer pageSize;

    @Autowired
    private CCustomService customService;

    /**
     * 查询客户 分页 搜索
     *
     * @param model
     * @param current
     * @param c_name
     * @return
     */
    @RequestMapping("/customList.html")
    public String showDishes(Model model,Integer current, String c_name) {
        if (current == null || current <= 0) {
            current = 1;
        }
        Page<Custom> customs = customService.getCustoms(current, pageSize, c_name);
        //如果没有记录，则到第一页
        if (customs.getRecords().size() == 0) {
            customs = customService.getCustoms(1, pageSize, c_name);
        }
        model.addAttribute("c_name", c_name);
        model.addAttribute("customs", customs);
        return "admin/customManage";
    }

    /**
     * 删除客户
     *
     * @param id
     * @return
     */
    @DeleteMapping("deleteCustom")
    @ResponseBody
    public Object deleteCustom(Integer id) {
        Integer result = customService.delById(id);
        return JsonData.jsonDataResult(result);
    }

    /**
     * 添加客户
     *
     * @param custom
     * @return
     */
    @PostMapping("/addCustom")
    @ResponseBody
    public Object addCustom(Custom custom){
        Integer result = customService.addCustom(custom);
        return JsonData.jsonDataResult(result);
    }

    /**
     * 更新客户
     *
     * @param custom
     * @return
     */
    @PutMapping("/updateCustom")
    @ResponseBody
    public Object updateCustom(Custom custom) {
        Integer result = customService.updateCustom(custom);
        return JsonData.jsonDataResult(result);
    }

}
