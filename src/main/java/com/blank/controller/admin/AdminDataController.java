package com.blank.controller.admin;

import com.blank.service.OOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *     功能描述:管理员前端控制器(统计数据)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.17
 */
@RequestMapping("/admin")
@Controller
public class AdminDataController {

    @Autowired
    private OOrderService orderService;

    @RequestMapping("/operatingData.html")
    public String operatingData() {
        return "admin/operatingData";
    }

    /**
     * 返回最近一周每日的销售额
     *
     * @return
     */
    @GetMapping("/getTotalSales")
    @ResponseBody
    public Object getTotalSales() {
        List<Integer> totalSales = orderService.getSumRecentWeek();
        return totalSales;
    }

    @GetMapping("/getHotDishes")
    @ResponseBody
    public Object getHotDishes() {
        return orderService.getHotDishes();
    }
}
