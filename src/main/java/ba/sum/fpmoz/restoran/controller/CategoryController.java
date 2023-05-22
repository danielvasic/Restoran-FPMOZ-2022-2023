package ba.sum.fpmoz.restoran.controller;

import ba.sum.fpmoz.restoran.model.Category;
import ba.sum.fpmoz.restoran.model.UserDetails;
import ba.sum.fpmoz.restoran.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping("/categories")
    public String showCategories (Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) auth.getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("added", false);
        return "categories";
    }

    @PostMapping("/category/add")
    public String addCategory (@Valid Category category, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) auth.getPrincipal();
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            model.addAttribute("category", category);
            model.addAttribute("categories", categoryRepo.findAll());
            model.addAttribute("added", true);
            return "categories";
        }
        categoryRepo.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/category/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException());
        model.addAttribute("category", category);
        return "category_edit";
    }

    @PostMapping("category/edit/{id}")
    public String editCategory (@PathVariable("id") Long id, @Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", category);
            return "category_edit";
        }
        categoryRepo.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Pogrešan ID"));
        categoryRepo.delete(category);
        return "redirect:/categories";
    }
}
