package View;

import java.awt.*;

import Model.Virologist;

public class VirologistView extends Drawable{
    private Color color;
    private Virologist virologist;

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(50,50,50,50);
    }
}
