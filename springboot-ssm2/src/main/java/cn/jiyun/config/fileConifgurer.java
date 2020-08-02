package cn.jiyun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class fileConifgurer  implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private  String filePath;
    @Value("${file.upload.relative.path}")
    private String relativePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //虚拟路径                                 //真实路径a
        registry.addResourceHandler(relativePath).addResourceLocations("file:/"+filePath);


    }
}
