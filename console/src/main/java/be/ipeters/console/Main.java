package be.ipeters.console;

import be.ipeters.AppConfig;
import be.ipeters.MessageGenerator;
import be.ipeters.NumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
//    private final static Logger log = (Logger) LoggerFactory.getLogger(Main.class);  // comment because using Lombok

    public static void main(String[] args) {
        log.info("Guess the number Game almost finished");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // call method next()

        int number = numberGenerator.next();

        // log generated number
        log.info("generated number = {}", number);

        // get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
        log.info("getMainMessage= {}", messageGenerator.getResultMessage());

        // call reset method
//        game.reset();

                // close context
        context.close();


    }
}
