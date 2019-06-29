package be.ipeters;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game {
    // == constants

    private static final Logger log = (Logger) LoggerFactory.getLogger(GameImpl.class);
    // == fields ==
    @Autowired
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // == constructors == ofr construcor based dependency injection, remove for setterbased d i
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    // == public methods ==
    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        // public methods
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        log.debug("remainingGuesses = {}, biggest = {}", remainingGuesses, biggest);
        biggest = numberGenerator.getMaxNumber();
        number= numberGenerator.next();
        log.debug("in the reset the number is {}", number);

    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }
    public int getNumber() {
        return number;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;

    }

    public int getSmallest() {
        return smallest;
    }

    public int getBiggest() {
        return biggest;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }


    public void check() {
        checkValidNumberRange();

        if(validNumberRange){
            if(guess > number){
                biggest = guess -1;
            }

            if(guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuesses--;

    }

    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    public boolean isGameWon() {
        return guess == number;
    }

    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <=0;
    }

    // == private methods
    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
