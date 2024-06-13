

import java.awt.*;

public enum Region 
{
    ETOILE(Color.YELLOW),
    FLEUR(Color.BLUE),
    LOSANGE(Color.GRAY),
    CARRE(Color.GREEN),
    HEXAGONE(Color.RED),
    ROND(Color.MAGENTA);

    private Color coul;

    private Region(Color coul)
    {
        this.coul = coul; 
    }

    public Color getCoul() {
        return this.coul;
    }
}
