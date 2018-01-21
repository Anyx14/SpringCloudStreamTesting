package ca.thompsonem.springcloudtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
@SpringBootApplication
public class SpringCloudTestProcessor {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTestProcessor.class, args);
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

}
