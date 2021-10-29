package fr.poo.tp3;

public class ComptePayant extends Compte {
    // Attributs
    private int coutCB;
    private int commission;
    private Float decouvert;

    public ComptePayant(Float solde, Float taux, Float decouvert) {
        super(solde, taux);
        this.decouvert = decouvert;
        coutCB = 5;
        commission = 1;
    }
}
