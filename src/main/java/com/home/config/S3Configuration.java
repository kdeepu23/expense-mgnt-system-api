package com.home.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClient;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Configuration {

    private static final String ACCESS_KEY = "AKIAU4BDN26I3DRLAJHI";
    private static final String SECRET_KEY = "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";
    //private static final String TOKEN = "IQoJb3JpZ2luX2VjEIv//////////wEaCXVzLWVhc3QtMiJGMEQCIE7nmSRNRYF0ihRjB/Fc+NJiHgIKPYKC79RlAYybRrR1AiAGWOi76fGZOmllcFhW+aynW3SYaqBglYskYeoTfLAIbyryAgiV//////////8BEAAaDDMzNTA4MTc1NjU2MSIMvHoHT7+1dHn5IE7NKsYCXzZWoKJJiDEF0zworrhzuH2wRP/CFaNUAX2V7NawDSjDlOrWOAfRBCaujvw0Rj/Q9hlJ5kC3oqRpLKCXAtSPMDwdpFjyJqj09M6fNfuX6PvY3fXqGlFBC0CYCtdjESTB7a8jZXqQlNW06eHqKomyhKdPLAg7QLDD9BprE0eV9p02qd4MAQry+ZQSCCouce41tSyGid2pLFqkonhD7+APIEromjBqudKuplyRWzjBwdanITfEcpdgPkuVjkuA/SIDL4yY8GvhzKKD0gsf4IWJWjmDafZP4oU5plGmaYEcOjeQC6YLw9Ir9GD8XCuTGyYqQZcdZ0gdhiOSwb2UVX2Q13fjGtZzt0oLBRSkfoDCWNxT1ARIZcfV/++UAO4cYgy4Kg+K1L6eMeJkgQRREFcihu+2XPhqsC94utDq+3oTKf141IbJdmcw9+GGqQY6qAGp3p+iOIAmqzUWifeuWlihzrmUmnF5L6ML6Ux3CS0Lch8u+5aM4IEmnesjoa5MJOxcZZI/NspOpWM8zenUF2ggJMmtdKRDAUfoJxmislMwFEGsU9zXza0/SK8ou9U+qhflBtMKfjeXOqcvxEV7c2i3EAzQAvuXz1REcvmGk6gtcJ0pTfMIvpWH9z0FwRlpj7AWpW9fp8YezQyjXbzMHdIXHCoUGopF3s8=";


    @Bean
    public AmazonS3 getAmazonS3Client() {
        return AmazonS3ClientBuilder
                .standard()
                  .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
                //.withCredentials(new AWSStaticCredentialsProvider(new BasicSessionCredentials(ACCESS_KEY, SECRET_KEY, TOKEN)))
                .withRegion("ca-central-1")
                .build();
    }


    @Bean
    public AmazonIdentityManagement getIAMClient(){
        return AmazonIdentityManagementClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
             //   .withCredentials(new AWSStaticCredentialsProvider(new BasicSessionCredentials(ACCESS_KEY, SECRET_KEY, TOKEN)))
                .build();
    }

}
