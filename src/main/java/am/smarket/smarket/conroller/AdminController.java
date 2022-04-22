package am.smarket.smarket.conroller;

import am.smarket.smarket.model.Category;
import am.smarket.smarket.model.Product;
import am.smarket.smarket.model.User;
import am.smarket.smarket.repository.CategoryRepository;
import am.smarket.smarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    @Value("${image.upload.dir}")
    private String imageUploadDir;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;




    @GetMapping("/admin")
    public String admin(ModelMap modelMap) {
        List<Product> allProducts = productRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        modelMap.addAttribute("allCategory", categoryList);
        modelMap.addAttribute("products", allProducts);

        return "adminPage";
    }


}
