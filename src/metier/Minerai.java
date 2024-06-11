package src.metier;

import java.awt.Color;

public enum Minerai 
{
    AL(new Color(227, 240, 126)),
    AG(new Color(150, 150, 150)),
    AU(new Color(215, 200, 10)),
    CO(new Color(165, 32, 32)),
    FE(new Color(255, 165, 0)),
    NI(new Color(30, 30, 230)),
    PT(new Color(230, 30, 230)),
    TI(new Color(30, 230, 30));


    private Color coul;

    private Minerai(Color coul)
    {
        this.coul = coul;
    }

    public Color getCoul() {
        return this.coul;
    }
}
