package fit.bitjv.bitjvsvobov25semestralniprace;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BiTjvSvobov25SemestralniPraceConfiguration {

    @Bean
    public ModelMapper ModelMapperBean() {
        return new ModelMapper();
    }
}
