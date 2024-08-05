package org.example;

public class Bank {
    public void run() {
        Konto Kunde = new Konto( "GB2384931H", 22.0);
        Kunde.gibKontoinformationen();
        Konto Kunde2 = new Konto("GB234451H", 55.0);
        Kunde2.gibKontoinformationen();
        double betrag = 5.0;

        System.out.println("---------abHeben von Kunde 5$----------");
        Kunde.abHeben(betrag);
        System.out.println("---------einZahlen zu Kunde 5$----------");
        Kunde.einZahlen(betrag);

        // Kunde.gibKontoinformationen();

        System.out.println("---------uberweisen von Kunde zu Kunde 2 -> 5$----------");
        Kunde.uberweisen(Kunde2, betrag);

        Kunde.gibKontoinformationen();
        Kunde2.gibKontoinformationen();

    }

}
