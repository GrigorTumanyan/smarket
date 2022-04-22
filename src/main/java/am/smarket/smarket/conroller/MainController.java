package am.smarket.smarket.conroller;

import am.smarket.smarket.model.Category;
import am.smarket.smarket.model.User;
import am.smarket.smarket.model.UserType;
import am.smarket.smarket.repository.CategoryRepository;
import am.smarket.smarket.repository.ProductRepository;
import am.smarket.smarket.repository.UserRepository;
import am.smarket.smarket.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String mainPage(ModelMap modelMap) {
//        modelMap.addAttribute("user", new User());
//        List<Category> categories = new ArrayList<>();
//        List<Category> subCategory = new ArrayList<>();
//        List<Category> secondSubCategory = new ArrayList<>();
//        List<Category> thirdSubCategory = new ArrayList<>();
//        List<Category> categoryList = categoryRepository.findAll();
//        for (Category category : categoryList) {
//            if (category.getId().equals(category.getParent())) {
//                categories.add(category);
//            }
//            if (category.getParent() == 0) {
//                subCategory.add(category);
//            }
//            for (Category parentCategory : categoryList) {
//                if (category.getId().equals(parentCategory.getParent())&&category.getParent()==0){
//                    secondSubCategory.add(parentCategory);
//                }
//                if (category.getId().equals(parentCategory.getParent())&&category.getParent()!=0&& !(category.getId().equals(category.getParent()))){
//                    thirdSubCategory.add(parentCategory);
//                }
//            }
//        }
//        modelMap.addAttribute("categorys", categories);
//        modelMap.addAttribute("secondSubCategorys", secondSubCategory);
//        modelMap.addAttribute("thirdSubCategory", thirdSubCategory);
//        modelMap.addAttribute("subCategorys", subCategory);
        Map<Integer, List<Category>> category = new HashMap<>();
        Map<Integer, List<Category>> subCategory = new HashMap<>();
        List<Category> topCategory = categoryRepository.findAllByParent(0);
        for (Category nextCategory : topCategory) {
            List<Category> allByParent = categoryRepository.findAllByParent(nextCategory.getId());
            if (allByParent.size() != 0) {
                category.put(nextCategory.getId(), allByParent);
            }
        }
//        for (Map.Entry<Integer, List<Category>> integerListEntry : category.entrySet()) {
//            for (Category value : integerListEntry.getValue()) {
//                List<Category> allByParent = categoryRepository.findAllByParent(value.getId());
//                if (allByParent.size() != 0){
//                    subCategory.put(value.getId(), allByParent);
//                }
//            }
//            Category next = integerListEntry.getValue().iterator().next();
//            List<Category> allByParent = categoryRepository.findAllByParent(id);
//            if (allByParent.size() != 0){
//                subCategory.put(integerListEntry.getValue().iterator().next().getId(), allByParent);
//            }



        List<Category> allById = categoryRepository.findAllById(1);
        return "index";

         
    }
    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        CurrentUser principal = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.getUser().getType() == UserType.MANAGER) {
            return "redirect:/admin";
        }
        return "redirect:/";
    }


    @GetMapping("/login")
    public String login(ModelMap modelMap) {
//        modelMap.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/register")
    public String reg(@ModelAttribute(name = "user") User user) {
        user.setType(UserType.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login?error")
    public String loginError() {
        return "error";
    }


}
