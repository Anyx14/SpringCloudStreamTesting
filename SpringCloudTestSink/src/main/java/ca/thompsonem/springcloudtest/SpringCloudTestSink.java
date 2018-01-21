package ca.thompsonem.springcloudtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class SpringCloudTestSink {

    private final Logger log = LoggerFactory.getLogger(SpringCloudTestSink.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTestSink.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void recieveMessage(String message) {
        log.info("Another app just sent \"" + message + "\"");
    }

}
