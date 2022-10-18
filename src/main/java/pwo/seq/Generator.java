package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

/**
 * Klasa inicjujaca generator
 * @author patry
 */
public class Generator implements SequenceGenerator{

    /**
     * Numer pierwszego wyrazu ciagu
     */
    protected int lastIndex = 0;

    /**
     * Current - zmienna przechowujaca wartosc aktualnego elementu
     * f_1 - pierwszy wyraz ciagu
     */
    protected BigDecimal current = null,
    f_1 = null,

    /**
     * Drugi wyraz ciagu
     */
    f_2 = null,

    /**
     * Trzeci wyraz ciagu
     */
    f_3 = null;

    
    @Override
    public void reset() {
        lastIndex = 0;
    }

    @Override
    public BigDecimal nextTerm() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BigDecimal getTerm(int i) {
        if (i < 0) throw new IllegalArgumentException();
        if (i < lastIndex) reset();
        while (lastIndex <= i) nextTerm();
        return current;
    }
    
}
