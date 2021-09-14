package pro.kulebyakin.awscloudxhomework.core.aws.xray;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import javax.servlet.Filter;

//@Configuration
public class AwsXrayConfig {
    //    @Bean
    public Filter TracingFilter() {
        return new AWSXRayServletFilter("aws-homework");
    }
}
