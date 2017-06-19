package am.ak;

import am.ak.aop.NotVeryUsefulAspect;
import am.ak.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * Created by karlen on 6/11/17.
 */
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public NotVeryUsefulAspect notVeryUsefulAspect() {
        return new NotVeryUsefulAspect();
    }

    @Bean
    public User user() {
        return new User();
    }
}
