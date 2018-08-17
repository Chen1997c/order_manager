package com.blank.controller.admin;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.blank.controller.BaseController;
import com.blank.entity.Table;
import com.blank.service.TTableService;
import com.blank.util.JsonData;
import com.blank.util.enums.TableInfoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *     功能描述:管理员前端控制器(餐桌管理)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.15
 */
@Controller
@RequestMapping("/admin")
public class AdminTController extends BaseController {

    @Autowired
    private TTableService tableService;

    /**
     * 查询所有餐桌 返回视图
     *
     * @param model
     * @return
     */
    @RequestMapping("/tableList.html")
    public String showTables(Model model) {
        List<Table> tables = tableService.getAllRecords();

        model.addAttribute("tables",tables);
        return "admin/tableManage";
    }

    /**
     * 增加餐桌
     *
     * @param table_number
     * @return
     */
    @PostMapping("/addTable")
    @ResponseBody
    public Object addTable(Integer table_number) {
        Integer result =  tableService.addTable(table_number);
        if(result == null)
            return  JsonData.bulidError(0,TableInfoEnum.INNER_ERROR.getStateInfo());
        if(result < 0)
            return JsonData.bulidError(0,TableInfoEnum.REPEAT.getStateInfo());
        return JsonData.buidSuccess(1,TableInfoEnum.SUCCESS.getStateInfo());
    }

    /**
     * 删除餐桌
     *
     * @param table_id
     * @return
     */
    @DeleteMapping("/deleteTable")
    @ResponseBody
    public Object deleteTable(Integer table_id) {
        Integer result = tableService.removeTableById(table_id);
        return JsonData.jsonDataResult(result);
    }

    /**
     * 修改餐桌的状态(是否被使用)
     *
     * @return
     */
    @PutMapping("/updateSate")
    @ResponseBody
    public Object updateState(Integer dt_id,Integer is_used) {
        Integer result = tableService.updateIsUsed(dt_id,is_used);
        return JsonData.jsonDataResult(result);
    }
}
