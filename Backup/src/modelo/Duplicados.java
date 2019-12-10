/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.util.Comparator;

/**
 *
 * @author mr_ca
 */
public class Duplicados implements Comparator<File> {
        /**
     * Metodo que compara archivos por tamaño y si son iguales por nombre
     *
     * @param file
     * @param file2
     * @return
     */
    @Override
    public int compare(File file, File file2) {
        if (file.length() > file2.length()) {
            return 1;
        } else if (file.length() < file2.length()) {
            return -1;
        } else {
            return file.getName().compareToIgnoreCase(file2.getName());
        }
    }
    
}
