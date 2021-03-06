package am.smarket.smarket;

import am.smarket.smarket.model.User;
import am.smarket.smarket.model.UserType;
import am.smarket.smarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class SmarketApplication extends WebMvcConfigurerAdapter  {

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(SmarketApplication.class, args);
    }


//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/");
        bean.setSuffix(".jsp");
        return bean;
    }

//    @Override
//    public void run(String... args) throws Exception {
//        String email = "smarket@gmail.com";
//        User oneByEmail = userRepository.findOneByEmail(email);
//        if (oneByEmail == null) {
//            userRepository.save(User.builder()
//                    .email(email)
//                    .password(new BCryptPasswordEncoder().encode("123456"))
//                    .name("admin")
//                    .surname("admin")
//                    .type(UserType.MANAGER)
//                    .build());
//        }
//    }
}
