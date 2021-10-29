package fr.poo.tp3;

public class Main {
    public static void main(String[] args) {
        // *************** Création et comptage de comptes *************** //
        Compte compteSimple = new CompteSimple(1000f);
        Compte comptePayant = new ComptePayant(1055f, 500f);
        Compte comptePremium = new ComptePremium(1160f);
        System.out.println("Nombre de comptes crées : " + Compte.getNbCompte());
        // Résultat attendu : 3

        // *************** Opérations : retraits et versements *************** //
        // compteSimple fait un retrait de 200€ :
        compteSimple.retrait(200f);
        System.out.println("Solde du compteSimple après retrait de 200€ : " + compteSimple.getSolde());
        // Résultat attendu : 795 (-200 - 5 commission)

        // comptePayant fait un retrait de 300€ :
        comptePayant.retrait(300f);
        System.out.println("Solde du comptePayant après retrait de 300€ : " + comptePayant.getSolde());
        // Résultat attendu : 644 (-300 - 1 commission // Solde initial : 1000 )

        // compteSimple fait un retrait de 400€ :
        comptePremium.retrait(400f);
        System.out.println("Solde du comptePremium après retrait de 400€ : " + comptePremium.getSolde());
        // Résultat attendu : 600 (-400 // Solde initial: 1000)

        /***********************************************************************************/

        // Versement de 200€ à CompteSimple
        compteSimple.versement(200f);
        System.out.println("Solde du compteSimple après versemment de 200€ : " + compteSimple.getSolde());
        // Résultat attendu : 990 (+200 - 5 commission // Solde initial: 795)

        // Versement de 200€ à ComptePayant
        comptePayant.versement(200f);
        System.out.println("Solde du comptePayant après versemment de 200€ : " + comptePayant.getSolde());
        // Résultat attendu : 898 (+200 -1 commission // Solde initial: 699)

        // Versement de 200€ à ComptePremium
        comptePremium.versement(200f);
        System.out.println("Solde du comptePremium après versemment de 200€ : " + comptePremium.getSolde());
        // Résultat attendu : 800 (+200 // Solde initial: 600)

        // Nombre de transactions effectuée
        System.out.println("Nombre de transaction : " + Compte.getNbTransaction());
        // Résultat attendu : 6

        // Commission perçue par la banque
        System.out.println("Commission perçue : " + Compte.getMontantTaxe());
        // Resultat attendu : 12.0

        // Découverts :
        // CompteSimple : transaction impossible < 0
        System.out.print("Découvert sur un compte simple : ");
        compteSimple.retrait(1200f);

        // ComptePayant : transaction impossible < -500
        System.out.print("Découvert sur un compte payant : ");
        comptePayant.retrait(2000f);

        // ComptePayant : transaction possible > -500
        System.out.print("Découvert sur un compte payant : ");
        comptePayant.retrait(1200f);
        System.out.println(comptePayant.getSolde());

        // ComptePremium : transaction possible
        System.out.print("Découvert sur un compte premium : ");
        comptePremium.retrait(120000f);
        System.out.println(comptePremium.getSolde());









    }
}
