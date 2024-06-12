package src.ihm.PlateauIndividuel;

import javax.swing.*;
import java.awt.*;

public class FrameIndi extends JFrame {

    private PanelMine panelMine;
    private PanelPrincipal panelPrincipal;

    private JLabel piecePosImage;
    private JLabel nbPiecePos;

    private JPanel panelCptPiecePos;

    public FrameIndi() {
        this.setLayout(new BorderLayout());
        this.setTitle("yudgeuj");

        this.panelCptPiecePos = new JPanel();
        this.panelMine = new PanelMine();
        this.panelPrincipal = new PanelPrincipal();

        this.panelCptPiecePos.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.piecePosImage = new JLabel();
        this.nbPiecePos = new JLabel("x4");
        this.nbPiecePos.setFont(new Font("7898", Font.PLAIN, 40));

        this.piecePosImage.setIcon(new ImageIcon("../images/pointPoss.png"));

        this.add(this.panelMine, BorderLayout.EAST);
        this.add(this.panelPrincipal, BorderLayout.CENTER);

        this.add(this.panelCptPiecePos, BorderLayout.SOUTH);

        this.panelCptPiecePos.add(this.piecePosImage);
        this.panelCptPiecePos.add(this.nbPiecePos);

        System.out.println(this.getSize());

        this.setSize(1080, 600);
        this.setVisible(true);

        System.out.println(this.panelPrincipal.getWidth() + this.panelMine.getWidth());
        System.out.println(this.panelPrincipal.getHeight() + this.panelCptPiecePos.getHeight());
    }

    public static void main(String[] args) {
        new FrameIndi();
    }
}