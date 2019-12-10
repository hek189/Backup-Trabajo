/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenete;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author mr_ca
 */
public class JButtonMagico extends JButton implements Serializable {

    private Color colorRatonEncima;

    public JButtonMagico() {
        Color colorOg = getBackground();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorRatonEncima);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorOg);
            }

        });
    }

    public Color getColorRatonEncima() {
        return colorRatonEncima;
    }

    public void setColorRatonEncima(Color colorRatonEncima) {
        this.colorRatonEncima = colorRatonEncima;
    }

}
