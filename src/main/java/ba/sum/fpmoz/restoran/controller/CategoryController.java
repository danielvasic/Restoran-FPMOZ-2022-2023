package ba.sum.fpmoz.restoran.controller;

import ba.sum.fpmoz.restoran.model.Category;
import ba.sum.fpmoz.restoran.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping("/categories")
    public String showCategories (Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryRepo.findAll());
        return "categories";
    }

    @PostMapping("/category/add")
    public String addCategory (Category category) {
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
