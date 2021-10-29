package fr.poo.tp3;

public class ComptePayant extends Compte implements IVerified, ICreated {
    // Attributs
    private int coutCB;
    private int commission;
    private Float decouvert;

    // Constructeur
    public ComptePayant(Float solde, Float decouvert) {
        super(solde);
        this.decouvert = (decouvert > 0 ? -decouvert: decouvert); // On enregistre un découvert négatif
        this.coutCB = 5;
        this.commission = 1;
        creationCompte();
    }

    // Méthodes

    /**
     * Méthode implémenter de l'interface ICreated
     * Méthode qui retire 50€ pour l'ouverture
     * et 5€ pour la carte bancaire à la création du compte.
     */
    public void creationCompte(){
        this.solde -= 50;
        this.solde-=this.coutCB;
    }

    /**
     * Méthode implémenter de l'interface IVerified
     * Méthode qui vérifie que l'opération de retrait est possible: solde final <= 0
     * @param montant
     * @return boolean
     */
    @Override
    public boolean verifierSoldeRetrait(Float montant) {
        return (this.solde - montant - this.commission) >= (this.decouvert);
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
        if(verifierSoldeVersement(montant)){
            this.solde -= this.commission;
            this.solde += montant;
            montantTaxe+= this.commission;
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
        if(verifierSoldeRetrait(montant)){
            this.solde = this.solde - montant;
            this.solde -= this.commission;
            montantTaxe+= this.commission;
            nbTransaction++;
        }else {
            System.out.println("Transaction impossible !");
        }
    }

    // GETTERS ET SETTERS

    public int getCoutCB() {
        return coutCB;
    }

    public void setCoutCB(int coutCB) {
        this.coutCB = coutCB;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public Float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Float decouvert) {
        this.decouvert = decouvert;
    }

    // ToString


    @Override
    public String toString() {
        return "ComptePayant{" +
                "code=" + code +
                ", solde=" + solde +
                ", coutCB=" + coutCB +
                ", commission=" + commission +
                ", decouvert=" + decouvert +
                '}';
    }
}
