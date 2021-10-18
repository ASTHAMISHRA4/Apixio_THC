package controller;

import dao.ICDDao;
import daoimpl.ICDDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.HCC;
import pojo.ICD;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class ICDController {

    ICDDao icdDao = MainController.ctx.getBean(ICDDaoImpl.class);

    @RequestMapping(value = "/showicdform", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("icd", "icd", new ICD());
    }

    @RequestMapping(value = "/addicd", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("index", icd.getIndex());
        model.addAttribute("code", icd.getCode());
        model.addAttribute("description", icd.getDescription());
        icdDao.setICD(icd);
        return "success";
    }

    @RequestMapping(value="/showallicd", method = RequestMethod.GET)
    public String listAllICD(Model model){
        List<ICD> list = icdDao.getAllICD();
        model.addAttribute("lists", list);

        return "showallicd";
    }

    @RequestMapping(value = "/showallicdfromcode", method = RequestMethod.GET)
    public String showIcdCodeForm(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model) {
        return "showallicdfromcode";
    }

    @RequestMapping(value="/showicdfromcode", method = RequestMethod.POST)
    public String listIcdFromCode(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model){
        List<ICD> icdList = icdDao.getICDFromCode(icd.getCode());
        model.addAttribute("lists", icdList);
        return "showallicd";
    }

    @RequestMapping(value = "/showallicdfromindex", method = RequestMethod.GET)
    public String showIcdIndexForm(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model) {
        return "showallicdfromindex";
    }

    @RequestMapping(value="/showicdfromindex", method = RequestMethod.POST)
    public String listIcdFromIndex(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model){
        ICD icdList = icdDao.getICD(icd.getIndex());
        model.addAttribute("lists", Arrays.asList(icdList));
        return "showallicd";
    }

    @RequestMapping(value = "/deleteicd", method = RequestMethod.GET)
    public String deleteIcd(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model) {
        return "deleteicd";
    }

    @RequestMapping(value = "/deleteicdbyindex", method = RequestMethod.POST)
    public String deleteIcdByIndex(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("index", icd.getIndex());
        model.addAttribute("code", icd.getCode());
        model.addAttribute("description", icd.getDescription());
        icdDao.deleteICD(icd.getIndex());
        return "deleteSuccess";
    }
}
