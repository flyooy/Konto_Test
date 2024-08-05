package org.example;

public class Konto {
    String kontoNummer;
    double saldo;

    public Konto(String kontoNummer, double salde) {
        this.kontoNummer = kontoNummer;
        this.saldo = salde;
    }

    public String getKontoNummer() {
        return kontoNummer;
    }

    public void setKontoNummer(String kontoNummer) {
        this.kontoNummer = kontoNummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void gibKontoinformationen() {
        System.out.println("Konto Nummer: " + kontoNummer);
        System.out.println("Konto Stand: " + saldo);
        System.out.println();
    }

    public double einZahlen(double betrag) {
        if (betrag < 0) {
            throw new IllegalArgumentException("Der Einzahlungs ist negativ, bitte geben Sie den richtigen Betrag ein");
        } else {
            saldo += betrag;
            System.out.println("Einzahlung erfolgreich");}

        System.out.println();
            return saldo;
    }
    public double abHeben(double betrag) {
        if (betrag < 0) {
            throw new IllegalArgumentException("Der Abhebungsbetrag ist negativ, bitte geben Sie den richtigen Betrag ein");
        }
        if (saldo > betrag) {
            saldo -= betrag;
            System.out.println("Entzug erfolgreich");
        } else  throw new IllegalArgumentException("Ihr Konto nicht ausreichend gedeckt ist");
            System.out.println();
        return saldo;
    }

    public double uberweisen(Konto empfaenger, double betrag) {
        if (empfaenger == null) {
            throw new IllegalArgumentException("Der Empfaenger konto ist unkorrekt");
        }
        if (betrag < 0)
            throw new IllegalArgumentException("Betrag ist negativ, bitte geben Sie den richtigen Betrag ein");

        if (betrag <= this.saldo) {
            this.saldo -= betrag;
            empfaenger.saldo += betrag;
            System.out.println("Überweisung erfolgreich");
        } else  throw new IllegalArgumentException("Ihr Konto ist nicht ausreichend gedeckt");
        System.out.println();
        return saldo;
    }

}
