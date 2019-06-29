package be.ipeters.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Container ready for use.");
    }
    // == constants
//    private static final Logger log = (Logger) LoggerFactory.getLogger(ConsoleNumberGuess.class);
//    log.info("blah");


}
