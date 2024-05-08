package vip.example.buxarkaanand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vip.example.buxarkaanand.model.AppSetting;
import vip.example.buxarkaanand.service.DataService;

@Controller
public class SettingsController {

   @Autowired
   DataService service;

    @GetMapping("/admin/settings")
    public String showSettings(Model model) {
        // Check if settings exist in the database
        AppSetting appSetting = service.getAppSByKey();
        if (appSetting == null) {
            // If settings do not exist, create a new AppSetting object
            appSetting = new AppSetting();
            appSetting.setKey("setting");
        }
        // Add AppSetting object to the model
        model.addAttribute("appSetting", appSetting);
        return "setting.jsp";
    }

    @PostMapping("/admin/saveSettings")
    public String saveSettings(@ModelAttribute AppSetting appSetting,Model model) {
        // Check if settings exist in the database
        AppSetting existingSetting = service.getAppSByKey();
        if (existingSetting != null) {
            // If settings exist, update the existing settings with new values
            if (appSetting.getUpiId() != null) {
                existingSetting.setUpiId(appSetting.getUpiId());
            }
            if (appSetting.getAddress() != null) {
                existingSetting.setAddress(appSetting.getAddress());
            }
            if (appSetting.getFacebookLink() != null) {
                existingSetting.setFacebookLink(appSetting.getFacebookLink());
            }
            if (appSetting.getTwitterLink() != null) {
                existingSetting.setTwitterLink(appSetting.getTwitterLink());
            }
            if (appSetting.getInstagramLink() != null) {
                existingSetting.setInstagramLink(appSetting.getInstagramLink());
            }
            if (appSetting.getLinkedinLink() != null) {
                existingSetting.setLinkedinLink(appSetting.getLinkedinLink());
            }
            if (appSetting.getPhoneNo() != null) {
                existingSetting.setPhoneNo(appSetting.getPhoneNo());
            }
            if (appSetting.getEmail() != null) {
                existingSetting.setEmail(appSetting.getEmail());
            }
            appSetting.setKey("setting");
            service.saveApp(existingSetting);
        } else {
        	appSetting.setKey("setting");
            service.saveApp(appSetting);
        }
        model.addAttribute("appSetting", appSetting);
        return "redirect:/settings";
    }
}