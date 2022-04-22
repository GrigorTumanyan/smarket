package am.smarket.smarket.conroller;

import am.smarket.smarket.model.Category;
import am.smarket.smarket.model.Product;
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
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Value("${image.upload.dir}")
    private String imageUploadDir;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/product/{category_id}")
    public String veggiesFruits(@PathVariable(value = "category_id") int id,ModelMap modelMap) {
        Category category = new Category();
        category.setId(id);
        List<Product> allByCategory_id = productRepository.findAllByCategory(category);
        modelMap.addAttribute("products", allByCategory_id);

        return "products";
    }


    @GetMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable(value = "id") int id, ModelMap modelMap) {

//        Optional<Product> productById = productRepository.findById(id);
        Product productById = productRepository.getOne(id);
//        ArrayList<Product> products = new ArrayList<>();
//        productById.ifPresent(products::add);
        modelMap.addAttribute("productById", productById);
        return "viewProduct";
    }


    @GetMapping("/admin/updateProduct/{id}")
    public String updateProduct(@PathVariable(value = "id") int id, ModelMap modelMap) {
        List<Category> categoryList = categoryRepository.findAll();
        modelMap.addAttribute("allCategory", categoryList);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product productId = optionalProduct.get();
            modelMap.addAttribute("product", productId);
        }
        return "updateProduct";
    }

    @PostMapping("/admin/updateProduct/{id}")
    public String updateProductById(@PathVariable(value = "id") int id, @ModelAttribute(name = "product") Product product,
                                    @RequestParam(name = "picture") MultipartFile multipartFile, ModelMap modelMap) throws IOException {
//        Product productById = productRepository.getOne(id);
//        String fileName = multipartFile.getOriginalFilename();
//        if (multipartFile.isEmpty()) {
//            fileName = productById.getImg_url();
//        }
//        File file = new File(imageUploadDir + multipartFile.getOriginalFilename());
//        if (!file.exists()) {
//            new File(imageUploadDir + productById.getImg_url()).delete();
//            fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
//            multipartFile.transferTo(new File(imageUploadDir + fileName));
//        }
//        product.setImg_url(fileName);
//        product.setId(id);
//        productRepository.save(product);
        Product productById = productRepository.getOne(id);
        String fileName = productById.getImg_url();
        if (!multipartFile.isEmpty()) {
            new File(imageUploadDir + fileName).delete();
            fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(imageUploadDir + fileName));
        }
        product.setImg_url(fileName);
        product.setId(id);
        productRepository.save(product);
        return "redirect:/product/" + product.getCategory().getId();
    }

    @GetMapping("/admin/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id, ModelMap modelMap) {
        productRepository.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/addProduct")
    public String addProductView(ModelMap modelMap) {
        List<Category> categoryList = categoryRepository.findAll();

        modelMap.addAttribute("allCategory", categoryList);
        modelMap.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/admin/addProduct")
    public String addProduct(@ModelAttribute(name = "product") Product product, @RequestParam(name = "picture") MultipartFile multipartFile) throws IOException {
        File file = new File(imageUploadDir);
        if (!file.exists()) {
            file.mkdir();
        }
        String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File(imageUploadDir + fileName));
        product.setImg_url(fileName);
        productRepository.save(product);
        return "redirect:/admin";
    }


}
