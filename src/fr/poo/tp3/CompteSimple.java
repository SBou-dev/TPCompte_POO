package fr.poo.tp3;

public class CompteSimple extends Compte implements IVerified {
    // Attributs
    private int commission;
    private Float decouvert;

    //Constructeur
    public CompteSimple(Float solde) {
        super(solde);
        this.commission = 5;
        this.decouvert = 0f;
    }

    // Méthodes
    /**
     * Méthode implémenter de l'interface IVerified
     * Méthode qui vérifie que l'opération de retrait est possible: solde final <= 0
     * @param montant
     * @return boolean
     */
    @Override
    public boolean verifierSoldeRetrait(Float montant) {
        return (this.solde - montant - this.commission) >= this.decouvert;
    }

    /**
     * Méthode implémenter de l'interface IVerified
     * Méthode qui vérifie que l'opération de versement est possible: solde final <= 0
     * @param montant
     * @return boolean
     */
    @Override
    public boolean verifierSoldeVersement(Float montant) {
        return (this.solde + montant - this.commission) >= this.decouvert;
    }

    /**
     * Méthode héritée du parent Compte
     * Méthode qui ajoute un montant au solde et retire la commission
     * @param montant
     */
    @Override
    public void versement(Float montant) {
        // On vérifie que le versement est possible
        if(verifierSoldeVersement(montant)){
            // Retire l'intérêt du solde
            this.solde -= this.commission;
            // Ajoute le versement au solde
            this.solde += montant;
            // Met à jour le montant total des intérêts perçu par la banque
            montantTaxe+= this.commission;
            // Met à jour le nombre de transactions
            nbTransaction++;
        }else {
            System.out.println("Transaction impossible !");
        }
    }

    /**
     * Méthode héritée du parent Compte
     * Méthode qui retire un montant au solde et retire la commission
     * @param montant
     */
    @Override
    public void retrait(Float montant){
        // On vérifie que le retrait est possible
        if(verifierSoldeRetrait(montant)){
            // Effectue le retrait sur le compte
            this.solde = this.solde - montant;
            // Effectue le retrait de la commision
            this.solde -= this.commission;
            // Met à jour le montant total des intérêts perçu par la banque
            montantTaxe+= this.commission;
            // Met à jour le nombre de transactions
            nbTransaction++;
        }else {
            System.out.println("Transaction impossible !");
        }
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
