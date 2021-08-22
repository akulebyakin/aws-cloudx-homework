package pro.kulebyakin.awscloudxhomework.core.awsxray;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import javax.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsXrayConfig {
    @Bean
    public Filter TracingFilter() {
        return new AWSXRayServletFilter("aws-homework");
    }
}
