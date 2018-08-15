package com.blank.controller.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.blank.entity.Dish;
import com.blank.service.DDishService;
import com.blank.util.ExportDishes;
import com.blank.util.JsonData;
import com.blank.util.enums.EditEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 功能描述:管理员前端控制器(菜品管理)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.07
 */
@Controller
@RequestMapping("/admin")
public class AdminDController {

    @Value("${admin.page.size}")
    private Integer pageSize;

    @Value("${spring.dish.img.locations}")
    private String path;

    @Autowired
    private DDishService dishService;

    /**
     * 查询菜品 分页 搜索
     *
     * @param model
     * @param current
     * @param d_name
     * @return
     */
    @RequestMapping("/dishList.html")
    public String showDishes(Model model, Integer current, String d_name) {
        if (current == null || current <= 0) {
            current = 1;
        }
        Page<Dish> dishes = dishService.getDishes(current, pageSize, d_name);
        //如果没有记录，则到第一页
        if (dishes.getRecords().size() == 0) {
            dishes = dishService.getDishes(1, pageSize, d_name);
        }
        model.addAttribute("d_name", d_name);
        model.addAttribute("dishes", dishes);
        return "admin/dishManage";
    }

    //删除
    @DeleteMapping("/deleteDish")
    @ResponseBody
    public Object deleteDish(Integer id) {
        Integer result = dishService.delById(id);
        return JsonData.jsonDataResult(result);

    }

    //更新菜品
    @PutMapping("/updateDish")
    @ResponseBody
    public Object updateDish(Dish dish) {
        Integer result = dishService.updateDish(dish);
        return JsonData.jsonDataResult(result);

    }

    //上传菜品图片
    @PostMapping("/uploadDishImg")
    @ResponseBody
    public Object uploadDishImg(MultipartFile file, Integer id) {
        //获取文件大小
        long fileSize = file.getSize();
        if (fileSize > 1024 * 1024 * 3) {
            return JsonData.bulidError(0, "文件大小限制为3MB");
        }
        String fileName = "dish_" + id + ".jpg";
        File dest = new File(path, fileName);
        try {
            file.transferTo(dest);
            Integer result = dishService.updateDishImg("/dish_img/" + fileName, id);
            if (result != null)
                return JsonData.buidSuccess(1, EditEnum.SUCCESS.getStateInfo());
            return JsonData.bulidError(0,EditEnum.FAIL.getStateInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonData.bulidError(0,EditEnum.FAIL.getStateInfo());
    }

    //添加菜品
    @PostMapping("/addDish")
    @ResponseBody
    public Object addDish(Dish dish){
        Integer result = dishService.addDish(dish);
        return JsonData.jsonDataResult(result);
    }

    //导出到excel
    @PostMapping("/exportDishes")
    @ResponseBody
    public Object exportDishes(HttpServletResponse response){
        List<Dish> dishes = dishService.getAll();
        try {
            ExportDishes.exportDishes(response,dishes);
        } catch (Exception e) {
            return JsonData.bulidError(0,EditEnum.FAIL.getStateInfo());
        }
        return JsonData.buidSuccess(1,EditEnum.SUCCESS.getStateInfo());
    }

}
