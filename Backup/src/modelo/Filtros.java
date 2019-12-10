package modelo;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Enrique
 */
public class Filtros {

    FilenameFilter filtroImagenes = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".jpeg") || name.endsWith(".jpg") || name.endsWith(".webp") || name.endsWith(".tiff") || name.endsWith(".exif") || name.endsWith(".dds") || name.endsWith(".psd") || name.endsWith(".raw") || name.endsWith(".bmp") || name.endsWith(".heif") || name.endsWith(".indd");
        }
    };

    FilenameFilter filtroVideos = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".webm") || name.endsWith(".mkv") || name.endsWith(".flv") || name.endsWith(".vob") || name.endsWith(".ogv") || name.endsWith(".ogg") || name.endsWith(".drc") || name.endsWith(".gif") || name.endsWith(".gifv") || name.endsWith(".mng") || name.endsWith(".avi") || name.endsWith(".mts") || name.endsWith(".m2ts") || name.endsWith(".ts") || name.endsWith(".mov") || name.endsWith(".qt") || name.endsWith(".wmv") || name.endsWith(".yuv") || name.endsWith(".rm") || name.endsWith(".rmvb") || name.endsWith(".asf") || name.endsWith(".amv") || name.endsWith(".mp4") || name.endsWith(".m4p") || name.endsWith(".mpg") || name.endsWith(".mp2") || name.endsWith(".mpeg") || name.endsWith(".mpe") || name.endsWith(".mpv") || name.endsWith(".m2v") || name.endsWith(".m4v") || name.endsWith(".svi") || name.endsWith(".3gp") || name.endsWith(".3g2") || name.endsWith(".mxf") || name.endsWith(".roq") || name.endsWith(".nsv") || name.endsWith(".f4v") || name.endsWith(".f4p") || name.endsWith(".f4a");
        }

    };

    FilenameFilter filtroDocumentos = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".doc") || name.endsWith(".docx") || name.endsWith(".pdf") || name.endsWith(".ppt") || name.endsWith(".docm") || name.endsWith(".dotx") || name.endsWith(".txt") || name.endsWith(".otd") || name.endsWith(".rtf") || name.endsWith(".zip") || name.endsWith(".rar") || name.endsWith(".rar4") || name.endsWith(".7z");
        }
    };

    public FilenameFilter getFiltroImagenes() {
        return filtroImagenes;
    }

    public FilenameFilter getFiltroVideos() {
        return filtroVideos;
    }

    public FilenameFilter getFiltroDocumentos() {
        return filtroDocumentos;
    }

}
