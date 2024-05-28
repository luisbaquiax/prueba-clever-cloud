/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baquiax.aprueba;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author Luis
 */
public class Utiles {

    private static final int TAM = 20;

    public void setIconMenuItem(JMenuItem menuItem, String ruta) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        menuItem.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(TAM,
                TAM, Image.SCALE_SMOOTH)));
    }

    public void setIconLabel(JLabel label, String ruta) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(label.getSize().width,
                label.getSize().height, Image.SCALE_SMOOTH)));
    }

    public void setIconLabel(JLabel label, String ruta, int ancho, int alto) {
        ImageIcon icono1 = new ImageIcon(ruta);
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(ancho,
                alto, Image.SCALE_SMOOTH)));
    }

    public ImageIcon getIcon(String ruta, int tam) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        return new ImageIcon(icono1.getImage().getScaledInstance(tam, tam, Image.SCALE_SMOOTH));
    }

}
