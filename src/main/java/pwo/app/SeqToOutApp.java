package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa wyswietlajaca wyrazu obliczonegi ciagu w konsoli
 * @author patry
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     *
     * @param args
     * @return Wartosc logiczna
     */
    @Override
    protected boolean getArgs(String[] args) {
        if (super.getArgs(args)) {
            return true;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     *
     * @return Wartosc logiczna informujaca to akcji zakonczonej powodzeniem
     */
    @Override
    protected boolean wirteSeq() {
        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));

        return true;
    }

    /**
     *
     * @param args - Ciag znakow informujacy o niepowodzeniu
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }

        wirteSeq();
    }

}
