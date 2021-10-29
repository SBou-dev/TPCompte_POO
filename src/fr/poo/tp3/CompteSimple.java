package fr.poo.tp3;

public class CompteSimple extends Compte {
    // Attributs
    private int commission;

    //Constructeur
    public CompteSimple(Float solde, Float taux) {
        super(solde, taux);
        this.commission = 5;
    }

    // Méthodes
    public boolean verifierSolde(Float montant) {
        return (this.solde - montant) > 0;
    }

    // GETTERS ET SETTERS

    public int getCommission() {
        return commission;
    }

    public CompteSimple setCommission(int commission) {
        this.commission = commission;
        return this;
    }
}
