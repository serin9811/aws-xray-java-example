package com.example.xraytest;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.plugins.EC2Plugin;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.net.URL;

@Configuration
public class XrayConfig {

    @Value("${aws.xray.fixed-segment-name}")
    private String fixedSegmentName;

    static {
        AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard();

        URL ruleFile = WebConfig.class.getResource("/sampling-rules.json");
        builder.withSamplingStrategy(new LocalizedSamplingStrategy(ruleFile));

        AWSXRay.setGlobalRecorder(builder.build());
        AWSXRay.beginSegment("Xray Test Begin");

        AWSXRay.endSegment();
    }

    @Bean
    public Filter tracingFilter() {
        return new AWSXRayServletFilter(fixedSegmentName);
    }

}
