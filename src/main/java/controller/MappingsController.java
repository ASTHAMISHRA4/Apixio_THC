package controller;

import dao.MappingsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.HCC;
import pojo.ICD;
import pojo.Mappings;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MappingsController {

    MappingsDao mappingsDao = MainController.ctx.getBean(MappingsDao.class);

    @RequestMapping(value = "/addmapping", method = RequestMethod.GET)
    public String showForm(@Valid @ModelAttribute("mappings") Mappings mappings, BindingResult result, ModelMap model) {
        return "addmapping";
    }

    @RequestMapping(value = "/addnewmapping", method = RequestMethod.POST)
    public String addmapping(@Valid @ModelAttribute("mappings") Mappings mappings, BindingResult result, ModelMap model) {
        model.addAttribute("index", mappings.getIndex());
        model.addAttribute("fromCode", mappings.getFromCode());
        model.addAttribute("toCode", mappings.getToCode());
        model.addAttribute("fromSystem", mappings.getFromSystem());
        model.addAttribute("toSystem", mappings.getToSystem());
        mappingsDao.setMapping(mappings);
        return "success";
    }

    @RequestMapping(value = "/deletemapping", method = RequestMethod.GET)
    public String deleteMapping(@Valid @ModelAttribute("mappings") Mappings mappings, BindingResult result, ModelMap model) {
        return "deletemapping";
    }

    @RequestMapping(value = "/deletemappingbyindex", method = RequestMethod.POST)
    public String deleteMappingByIndex(@Valid @ModelAttribute("mappings") Mappings mappings, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("index", mappings.getIndex());
        model.addAttribute("fromCode", mappings.getFromCode());
        model.addAttribute("toCode", mappings.getToCode());
        model.addAttribute("fromSystem", mappings.getFromSystem());
        model.addAttribute("toSystem", mappings.getToSystem());
        mappingsDao.deleteMapping(mappings.getIndex());
        return "deleteSuccess";
    }

    @RequestMapping(value = "/getmappedhccform", method = RequestMethod.GET)
    public String showHccMappingForm(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model) {
        return "getmappedhccform";
    }

    @RequestMapping(value="/getMappedHcc", method = RequestMethod.POST)
    public String listHccMapping(@Valid @ModelAttribute("icd") ICD icd, BindingResult result, ModelMap model){
        List<HCC> hccList = mappingsDao.getMappedHCC(icd);
        model.addAttribute("lists", hccList);
        return "showallhcc";
    }

    @RequestMapping(value = "/getmappedicdform", method = RequestMethod.GET)
    public String showIcdMappingForm(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model) {
        return "getmappedicdform";
    }

    @RequestMapping(value="/getMappedIcd", method = RequestMethod.POST)
    public String listIcdMapping(@Valid @ModelAttribute("hcc") HCC hcc, BindingResult result, ModelMap model){
        List<ICD> icdList = mappingsDao.getMappedICD(hcc);
        model.addAttribute("lists", icdList);
        return "showallicd";
    }
}
