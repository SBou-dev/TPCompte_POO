package fr.poo.tp3;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
    // Attribut
    protected int code;
    protected Float solde;
    // Attributs statics
    protected static int nbCompte;
    protected static int nbTransaction;
    protected static Float montantTaxe = 0f;
    // Liste des comptes
    protected static List<Compte> comptes = new ArrayList<>();

    // Constructeur
    public Compte(Float solde) {
        nbCompte++;
        this.code = nbCompte;
        this.solde = solde;
    }

    // Méthodes
    public abstract void versement(Float montant);

    public abstract void retrait(Float montant) ;

    // GETTERS ET SETTERS
    public int getCode() {
        return code;
    }

    public Compte setCode(int code) {
        this.code = code;
        return this;
    }

    public Float getSolde() {
        return solde;
    }

    public Compte setSolde(Float solde) {
        this.solde = solde;
        return this;
    }

    // GETTERS des attributs static
    public static int getNbCompte() {
        return nbCompte;
    }

    public static int getNbTransaction() {
        return nbTransaction;
    }

    public static Float getMontantTaxe() {
        return montantTaxe;
    }

    public static List<Compte> getComptes() {
        return comptes;
    }

    public static void setComptes(List<Compte> comptes) {
        Compte.comptes = comptes;
    }

    // toString
    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", solde=" + solde +
                '}';
    }
}
