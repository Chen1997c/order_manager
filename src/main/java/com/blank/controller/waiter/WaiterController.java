package com.blank.controller.waiter;

import com.baomidou.mybatisplus.plugins.Page;
import com.blank.dto.OrderDto;
import com.blank.entity.Dish;
import com.blank.entity.Order;
import com.blank.entity.OrderContent;
import com.blank.service.DDishService;
import com.blank.service.OOrderService;
import com.blank.service.TTableService;
import com.blank.util.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <p>
 * 功能描述:管理员前端控制器(服务员界面)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
@Controller
@RequestMapping("/waiter")
public class WaiterController {

    @Value("${waiter.dish.page.size}")
    private Integer pageSize;

    @Autowired
    private DDishService dishService;

    @Autowired
    private OOrderService orderService;

    @Autowired
    private TTableService tableService;

    /**
     * 返回点餐视图
     *
     * @return
     */
    @RequestMapping("/orderDish.html")
    public String orderDish() {
        return "waiter/orderDish";
    }


    /**
     * 获取限定数量的dish
     *
     * @param limit
     * @param d_name
     * @return
     */
    @GetMapping("/getDishRecords")
    @ResponseBody
    public Object getDish(Integer limit, String d_name) {
        if (limit == null) {
            limit = 1;
        }
        if (limit < 0)
            //搜索时显示全部 设数据不会超过100条
            return dishService.getDishes(1, 100, d_name);
        Page<Dish> dishes = dishService.getDishes(1, limit * pageSize, d_name);
        return dishes;
    }

    /**
     * 获取所有餐桌信息
     *
     * @return
     */
    @GetMapping("/getTables")
    @ResponseBody
    public Object getTables() {
        return tableService.getAllRecords();
    }

    /**
     * 下订单
     *
     * @param orderDto
     * @return
     */
    @PostMapping("/placeOrder")
    @ResponseBody
    public Object placeOrder(@RequestBody OrderDto orderDto) {
        Integer result = orderService.placeOrder(orderDto);
        return JsonData.jsonDataResult(result);
    }

    @GetMapping("/checkTable")
    @ResponseBody
    public Object checkTable(Integer dt_id) {
        Integer result = tableService.checkTable(dt_id);
        if (result == 1)
            result = null;
        return JsonData.jsonDataResult(result);
    }
}
