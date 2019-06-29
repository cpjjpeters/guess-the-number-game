package be.ipeters.console;

import be.ipeters.Game;
import be.ipeters.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Slf4j
public class ConsoleNumberGuess {
    // == constants
//    private static final Logger log = (Logger) LoggerFactory.getLogger(ConsoleNumberGuess.class);
//    log.info("blah");

    // == fields
    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;
    @EventListener(ContextRefreshedEvent.class)

    // == events
    public void startApplication() { //(ContextRefreshedEvent event) weg, maar added in @Eventlistener
        log.info("START: Container ready for use.");
        Scanner scanner = new Scanner((System.in));
        while (true){
            System.out.println(messageGenerator.getMainMessage() );
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");
                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }

        }
    }


}
