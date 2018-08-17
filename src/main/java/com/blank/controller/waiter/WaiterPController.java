package com.blank.controller.waiter;

import com.blank.dto.OrderDto;
import com.blank.service.OOrderService;
import com.blank.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *     功能描述:服务员前端控制器(结账)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.16
 */
@Controller
@RequestMapping("/waiter")
public class WaiterPController {

    @Autowired
    private OOrderService orderService;

    /**
     * 返回结账视图
     *
     * @param model
     * @return
     */
    @RequestMapping("/payList.html")
    public String settle(Model model) {
        List<OrderDto> ordersInfo = orderService.getOrdersInfo();
        model.addAttribute("ordersInfo", ordersInfo);
        return "waiter/payList";
    }

    /**
     * 删除订单
     *
     * @param o_id
     * @return
     */
    @DeleteMapping("/deleteOrder")
    @ResponseBody
    public Object deleteOrder(Integer o_id) {
        Integer result = orderService.delteOrderById(o_id);
        return JsonData.jsonDataResult(result);
    }

    /**
     * 支付
     *
     * @param o_id
     * @return
     */
    @PutMapping("/payOrder")
    @ResponseBody
    public Object payOrder(Integer o_id,Integer table_id) {
        Integer result = orderService.payOrder(o_id,table_id);
        return JsonData.jsonDataResult(result);
    }
}
