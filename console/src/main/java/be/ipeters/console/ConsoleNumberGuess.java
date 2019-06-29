package be.ipeters.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsoleNumberGuess {

    @EventListener
    public void startApplicationEvent(ContextRefreshedEvent event) {
        log.info("START: Container ready for use.");
    }
    // == constants
//    private static final Logger log = (Logger) LoggerFactory.getLogger(ConsoleNumberGuess.class);
//    log.info("blah");


}
