package be.ipeters;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("generator")
public class NumberGeneratorImpl implements NumberGenerator {
    // == fields --

    private final Random random = new Random();
    private int maxNumber = 100;

    // == public methods
    public int next() {
        return random.nextInt(maxNumber);
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
