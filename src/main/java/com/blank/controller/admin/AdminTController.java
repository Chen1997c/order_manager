package com.blank.controller.admin;

import com.blank.entity.Table;
import com.blank.service.TTableService;
import com.blank.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class AdminTController {

    @Autowired
    private TTableService tableService;

    @RequestMapping("/tableList.html")
    public String showTables(Model model) {
        List<Table> tables = tableService.getAllRecords();

        model.addAttribute("tables",tables);
        return "/admin/tableManage";
    }

    @PostMapping("/addTable")
    @ResponseBody
    public Object addTable(Integer table_number) {
        Integer result =  tableService.addTable(table_number);
        return JsonData.jsonDataResult(result);
    }
}
