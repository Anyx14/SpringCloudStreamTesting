package ca.thompsonem.springcloudtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

@EnableBinding(Source.class)
@SpringBootApplication
public class SpringCloudTestSource {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTestSource.class, args);
    }

    @Bean
    @InboundChannelAdapter(
            value = Source.OUTPUT,
            poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1")
    )
    public MessageSource<String> sendText() {
        return () -> new GenericMessage<>("ArbitraryText");
    }
}
