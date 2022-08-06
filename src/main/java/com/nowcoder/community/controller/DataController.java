package com.nowcoder.community.controller;

import com.nowcoder.community.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    // 统计页面
    @RequestMapping(path = "/data", method = {RequestMethod.GET, RequestMethod.POST})
    public String getDataPage() {
        return "/site/admin/data";
    }

    // 统计网站 UV
    @RequestMapping(path = "/data/uv", method = RequestMethod.POST)
    public String getUV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, Model model) {
        System.out.println("开始计算");
        long uv = dataService.calculateUV(startDate, endDate);
        model.addAttribute("uvResult", uv);
        model.addAttribute("uvStartDate", startDate);
        model.addAttribute("uvEndDate", endDate);

        return "forward:/data";
    }

    // 统计 活跃用户
    @RequestMapping(path = "/data/dau", method = RequestMethod.POST)
    public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, Model model) {
        long dau = dataService.calculateDAU(startDate, endDate);
        model.addAttribute("dauResult", dau);
        model.addAttribute("dauStartDate", startDate);
        model.addAttribute("dauEndDate", endDate);

        return "forward:/data";
    }
}
