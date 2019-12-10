package modelo;

import controlador.VentanaPrincipal;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.SwingUtilities;

/**
 *
 * @author Enrique
 */
public class Metodos {

    //<editor-fold defaultstate="collapsed" desc="Codigo viejo que funcionaba regular">
    @Deprecated
    private ArrayList<String> arrayListCopiar = new ArrayList<>();
    @Deprecated
    private ArrayList<String> arrayListNombres = new ArrayList<>();

    /**
     * Metodo para ver que archivos que hay copiar
     *
     * @param ruta la ruta para copiar los archivos
     * @throws IOException
     * @deprecated
     */
    @Deprecated
    public void Listar(String ruta) throws IOException {
        File file = new File(ruta);
        File[] arrayFiles = file.listFiles();
        for (File fichero : arrayFiles) {
            if (fichero.isDirectory()) {
                arrayListCopiar.add(fichero.getCanonicalPath());
                arrayListNombres.add(fichero.getName());
                Listar(fichero.getCanonicalPath());
            } else {
                arrayListNombres.add(fichero.getName());
                arrayListCopiar.add(fichero.getCanonicalPath());
            }
        }
    }

    /**
     * Metodo para ver que archivos que hay copiar metiendole un filtro
     *
     * @param ruta la ruta para copiar los archivos
     * @param filtro extension del archivo que quieres
     * @throws IOException
     * @deprecated
     */
    @Deprecated
    public void Listar(String ruta, FilenameFilter filtro) throws IOException {
        File file = new File(ruta);
        File[] arrayFiles = file.listFiles(filtro);
        for (File fichero : arrayFiles) {
            if (fichero.isDirectory()) {
                Listar(fichero.getCanonicalPath());
            } else {
                arrayListNombres.add(fichero.getName());
                arrayListCopiar.add(fichero.getCanonicalPath());
            }
        }
    }

    /**
     * Metodo en el que se copian los archivos buscados anteriormenete
     *
     * @param destino
     * @throws IOException
     * @deprecated
     */
    @Deprecated
    public void CopiarArchivos(String destino) throws IOException {
        File destiny = new File(destino);
        if (destiny.exists() == false) {
            destiny.mkdirs();
        }
        for (int i = 0; i < arrayListCopiar.size(); i++) {
            File destinoFile = new File(destino, arrayListNombres.get(i));
            File file = new File(arrayListCopiar.get(i));
            Files.copy(file.toPath(), destinoFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

    }

    /**
     * Metodo para borrar los archivos de la arrayList
     *
     * @deprecated
     */
    @Deprecated
    public void BorrarFiles() {
        for (int i = 0; i < arrayListCopiar.size(); i++) {
            File file = new File(arrayListCopiar.get(i));
            file.delete();
        }
    }

//</editor-fold>
    String[] ficheros;

    private VentanaPrincipal ventanaPrincipal;

    /**
     * Metodo para seleccionar los archivos de una ruta de origen y copiarlos a
     * una de destino y borrar despues con un filtro
     *
     * @param origen
     * @param destino
     * @param borrar
     * @param filtro
     * @throws IOException
     */
    public void hacerCopia(File origen, File destino, boolean borrar, FilenameFilter filtro) throws IOException {
        if (origen.isDirectory()) {
            if (!destino.exists()) {
                destino.mkdirs();
            }
            ficheros = origen.list(filtro);
            for (String fichero : ficheros) {
                File ficheroOrigen = new File(origen, fichero);
                File ficheroDestino = new File(destino, fichero);
                hacerCopia(ficheroOrigen, ficheroDestino, borrar, filtro);
                if (borrar == true) {
                    ficheroOrigen.delete();
                }
            }
        } else {
            Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            if (borrar == true) {
                origen.delete();
            }
        }

    }

    /**
     * Metodo para calcular y mostrar el espacio disponible en todos los discos
     * enchufados
     *
     * @return Los Discos y el espacio
     */
    public String calcularEspacio() {
        String size;
        ArrayList<String> text = new ArrayList<>();
        File[] disk = File.listRoots();
        for (File disk1 : disk) {
            long space = disk1.getUsableSpace();
            if (space / 1024 / 1024 / 1024 < 1) {
                space = space / 1024 / 1024;
                size = "MB";
            } else {
                space = space / 1024 / 1024 / 1024;
                size = "GB";
            }
            String e = disk1.getAbsolutePath() + " " + space + size;
            text.add(e);
        }
        return text.toString();
    }

    /**
     *
     * @param valorBarraProgreso
     * @param fichero
     */
    private void updateProgress(int valorBarraProgreso, String fichero) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ventanaPrincipal.actualizarBarra(fichero, valorBarraProgreso);
                ventanaPrincipal.repaint();
            }
        });
    }

}
