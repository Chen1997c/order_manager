package com.blank.controller.cooker;

import com.blank.dto.OrderContentDto;
import com.blank.service.OOrderService;
import com.blank.util.JsonData;
import com.blank.util.enums.CookEnum;
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
 *     功能描述:后厨前端控制器
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.16
 */
@Controller
@RequestMapping("/cooker")
public class CookerController {

    @Autowired
    private OOrderService orderService;

    /**
     * 后厨视图
     *
     * @return
     */
    @RequestMapping("/kitchen.html")
    public String kitchenView(Model model) {
        List<OrderContentDto> unCookOrders = orderService.getUnCookOrder();
        model.addAttribute("unCookOrders", unCookOrders);
        return "cooker/kitchen";
    }

    /**
     * 烹饪
     *
     * @param oc_id
     * @return
     */
    @PutMapping("/cook")
    @ResponseBody
    public Object cook(Integer oc_id) {
        Integer result = orderService.cookById(oc_id);
        if(result == null)
            return JsonData.bulidError(0,CookEnum.INNER_ERROR.getStateInfo());
        if(result <= 0)
            return JsonData.bulidError(0,CookEnum.COOK_FAIL.getStateInfo());
        return JsonData.buidSuccess(1,CookEnum.SUCCESS.getStateInfo());
    }

    /**
     * 传菜
     *
     * @param oc_id
     * @return
     */
    @PutMapping("/publish")
    @ResponseBody
    public Object publish(Integer oc_id) {
        Integer result = orderService.publishById(oc_id);
        if(result == null)
            return JsonData.bulidError(0,CookEnum.INNER_ERROR.getStateInfo());
        if(result <= 0)
            return JsonData.bulidError(0,CookEnum.PUBLISH_FAIL.getStateInfo());
        return JsonData.buidSuccess(1,CookEnum.SUCCESS.getStateInfo());
    }

    /**
     * 删除
     *
     * @param oc_id
     * @return
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public Object delete(Integer oc_id) {
        Integer result = orderService.deleteContentById(oc_id);
        if(result>0)
            return JsonData.buidSuccess(1,CookEnum.SUCCESS.getStateInfo());
        return JsonData.bulidError(0,CookEnum.INNER_ERROR.getStateInfo());
    }

}
