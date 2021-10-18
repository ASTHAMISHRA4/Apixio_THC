package controller;

import config.BeanConfiguration;
import dao.HCCDao;
import daoimpl.HCCDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.HCC;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class HCCController {

    HCCDao hccDao = MainController.ctx.getBean(HCCDaoImpl.class);

    @RequestMapping(value = "/showhccform", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("hcc", "hcc", new HCC());
    }

    @RequestMapping(value = "/addhcc", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("index", hcc.getIndex());
        model.addAttribute("children", hcc.getChildren());
        model.addAttribute("raf", hcc.getRaf());
        model.addAttribute("code", hcc.getCode());
        model.addAttribute("description", hcc.getDescription());
        hccDao.setHCC(hcc);
        return "success";
    }

    @RequestMapping(value="/showallhcc", method = RequestMethod.GET)
    public String listAllHcc(Model model){
        List<HCC> list = hccDao.getAllHCC();
        model.addAttribute("lists", list);

        return "showallhcc";
    }

    @RequestMapping(value = "/showallhccfromcode", method = RequestMethod.GET)
    public String showHccCodeForm(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        return "showallhccfromcode";
    }

    @RequestMapping(value="/showhccfromcode", method = RequestMethod.POST)
    public String listHccFromCode(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model){
        List<HCC> hccList = hccDao.getHCCFromCode(hcc.getCode());
        model.addAttribute("lists", hccList);
        return "showallhcc";
    }

    @RequestMapping(value = "/showallhccfromindex", method = RequestMethod.GET)
    public String showHccIndexForm(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        return "showallhccfromindex";
    }

    @RequestMapping(value="/showhccfromindex", method = RequestMethod.POST)
    public String listHccFromIndex(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model){
        HCC hccList = hccDao.getHCC(hcc.getIndex());
        model.addAttribute("lists", Arrays.asList(hccList));
        return "showallhcc";
    }

    @RequestMapping(value = "/deletehcc", method = RequestMethod.GET)
    public String deleteHcc(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        return "deletehcc";
    }

    @RequestMapping(value = "/deletehccbyindex", method = RequestMethod.POST)
    public String deleteHccByIndex(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("index", hcc.getIndex());
        model.addAttribute("children", hcc.getChildren());
        model.addAttribute("raf", hcc.getRaf());
        model.addAttribute("code", hcc.getCode());
        model.addAttribute("description", hcc.getDescription());
        hccDao.deleteHCC(hcc.getIndex());
        return "deleteSuccess";
    }

    @RequestMapping(value = "/gethccchildrenform", method = RequestMethod.GET)
    public String getHccChildrenForm(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        return "gethccchildrenform";
    }

    @RequestMapping(value="/gethccchildren", method = RequestMethod.POST)
    public String getHccChildren(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model){
        List<HCC> hccList = hccDao.getChilden(hcc);
        model.addAttribute("lists", hccList);
        return "showallhcc";
    }

    @RequestMapping(value = "/gethccparentform", method = RequestMethod.GET)
    public String getHccParentForm(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        return "gethccparentform";
    }

    @RequestMapping(value="/gethccparent", method = RequestMethod.POST)
    public String getHccParent(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model){
        List<HCC> hccList = hccDao.getParent(hcc);
        model.addAttribute("lists", hccList);
        return "showallhcc";
    }
}
