package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa pomagajaca wyliczyc ciag Lucasa
 * @author patryk
 */
public class LucasGenerator extends FibonacciGenerator {

    /**
     * Metoda inicjalizujaca obecny oraz drugi wyraz ciagu
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }

}
