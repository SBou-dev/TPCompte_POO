package fr.poo.tp3;

public class ComptePremium extends Compte implements ICreated {
    // Attributs
    private int coutCB;

    public ComptePremium(Float solde) {
        super(solde);
        this.coutCB = 10;
        creationCompte();
    }

    // Méthodes

    /**
     * Méthode implémenter de l'interface ICreated
     * Méthode qui retire 150€ pour l'ouverture
     * et 10€ pour la carte bancaire à la création du compte.
     */
    @Override
    public void creationCompte(){
        this.solde -= 150;
        this.solde-=this.coutCB;
    }

    /**
     * Méthode héritée du parent Compte
     * Méthode qui ajoute un montant au solde
     * @param montant
     */
    @Override
    public void versement(Float montant) {
        this.solde += montant;
        nbTransaction++;
    }

    /**
     * Méthode héritée du parent Compte
     * Méthode qui retire un montant au solde
     * @param montant
     */
    @Override
    public void retrait(Float montant){
        this.solde = this.solde - montant;
        nbTransaction++;
    }
}
