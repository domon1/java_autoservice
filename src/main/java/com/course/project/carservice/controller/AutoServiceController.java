package com.course.project.carservice.controller;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.service.ServicesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autoservice")
public class AutoServiceController {
    private final ServicesService servicesService;

    public AutoServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    // Все сервисы по категории (permit all)
    @GetMapping("{id}")
    public String getServicesList(Model model, @PathVariable Long id) {
        model.addAttribute("services", servicesService.findAllByCategory(id));
        return "userServices";
    }

    // Создание сервиса
    @PostMapping("newService")
    public String newService(AutoService autoService) {
        servicesService.save(autoService);
        return "redirect:/manager";
    }

    // Обновление сервиса
    @PostMapping("{id}")
    public String editService(@RequestParam Long id, @ModelAttribute("service") AutoService autoService) {
        servicesService.update(id, autoService);
        return "redirect:/manager";
    }

    // Удаление сервиса
    @GetMapping("delete/{id}")
    public String deleteService(@PathVariable("id") Long id) {
        servicesService.delete(id);
        return "redirect:/manager";
    }
}
