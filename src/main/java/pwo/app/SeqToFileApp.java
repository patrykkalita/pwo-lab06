package pwo.app;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import pwo.utils.SequenceTools;
import pwo.seq.SeqType;

/**
 * Klasa odpowiedzialna za zapis wyliczonego ciagu do pliku tekstowego
 * @author patryk
 */
public class SeqToFileApp {

    /**
     * Zmienna przechowujaca typ sekwencji
     */
    protected SeqType seqType = null;

    /**
     * Zmienna przechowujaca poczatek przedzialu
     */
    protected Integer from = null,

    /**
     * Zmienna przechowujaca koniec przedzialu
     */
    to = null;

    /**
     * Zmienna przechowujaca nazwe pliku do zapisu
     */
    protected String fileName = null;

    /**
     *
     * @param args
     * @return Zwraca wartosc logiczna mowiaca czy operacja zakoczyla sie powodzeniem
     */
    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException
                | NumberFormatException ex) {
            return false;
        }

        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     *
     * @return Wartosc logiczna informujaca o zakonczeniu operacji
     */
    protected boolean wirteSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(),
                from, to, fileName);
    }

    /**
     *
     * @param args - informacja zwrotna
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }

        if (!wirteSeq()) {
            System.out.println("!Write to the file: "
                    + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}
