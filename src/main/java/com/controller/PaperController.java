/**
 * 控制器，控制URL和动作的对应关系
 *
 * spring-mvc.xml做jsp的映射，这个文件做sevlet的映射
 */

package com.controller;

import com.pojo.Paper;
import com.service.PaperService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    @RequestMapping("/allPaper")
    public String list(Model model) {
        List<Paper> list = paperService.queryAllPaper();
        model.addAttribute("list", list); //获取数据集返回到JSP的标签库
        //ViewData["allPaperList"] = list;
        return "allPaper"; // 把 /paper/allPaper 映射到 /WEB-INF/jsp/allPaper.jsp
    }

    @RequestMapping("toAddPaper")
    public String toAddPaper() {
        return "addPaper";
    }

    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        paperService.addPaper(paper);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") Long id) {
        paperService.deletePaperById(id);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("toUpdatePaper")
    public String toUpdatePaper(Model model, Long id) {
        Paper p = paperService.queryById(id);
        model.addAttribute("paper", p);
        return "updatePaper";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(Model model, Paper paper) {
        paperService.updatePaper(paper);
        Paper p = paperService.queryById(paper.getPaperId());
        model.addAttribute("paper", p);
        return "redirect:/paper/allPaper";
    }
}


