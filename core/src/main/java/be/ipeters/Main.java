package be.ipeters;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private final static Logger log = (Logger) LoggerFactory.getLogger(Main.class);
    private  static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number Game");

        // create context (container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // call method next()

        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // call reset method
        game.reset();

        log.info("after game.reset() number = {}", number);
        // close context
        context.close();


    }
}
