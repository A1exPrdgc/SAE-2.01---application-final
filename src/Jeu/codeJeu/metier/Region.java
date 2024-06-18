package codeJeu.metier;

import java.awt.*;

public enum Region 
{
    VILLE(Color.BLACK, "NR"),
    ETOILE(Color.YELLOW, "Jaune"),
    FLEUR(Color.BLUE, "Bleu"),
    LOSANGE(Color.GRAY, "Gris"),
    CARRE(Color.GREEN, "Vert"),
    HEXAGONE(Color.RED, "Rouge"),
    ROND(Color.MAGENTA, "Marron");

    private Color coul;
    private String nomCoul;

    private Region(Color coul, String nomCoul)
    {
        this.nomCoul = nomCoul;
        this.coul = coul; 
    }

    public Color getCoul() {
        return this.coul;
    }

    public String getNomCoul() {
        return this.nomCoul;
    }
}
