package com.herprogramacion.alquileres.provider;

import android.net.Uri;

import java.util.UUID;

/**
 * Contrato con la estructura de la base de datos y forma de las URIs
 */
public class Contrato {

    interface ColumnasPropuesta {
        String ID_PROPUESTA = "idAlquiler"; // Pk
        String TITULO = "nombre";
        String URL_IMAGEN ="urlImagen";
        String FECHA = "fecha";
        String UBICACION = "ubicacion";
        String DESCRIPCION = "descripcion";
        String STATUS = "status";
        String STATUS_FLAG = "status_flag";
        String FOLLOW = "follow";
        String REPAIRIT = "repairit";
        String CATEGORIA = "categoria";
        String IMG_PARALAX = "image_paralax";
        String LAT = "lat";
        String LON = "lon";
        String USER_NAME = "username";
        String FOTO_USERCOM = "fotousercomm";
        String BODY_COMMENT = "bodycomment";

    }


    // Autoridad del Content Provider
    public final static String AUTORIDAD = "com.herprogramacion.alquileres";

    // Uri base
    public final static Uri URI_CONTENIDO_BASE = Uri.parse("content://" + AUTORIDAD);


    /**
     * Controlador de la tabla "alquiler"
     */
    public static class Propuestas implements ColumnasPropuesta {

        public static final Uri URI_CONTENIDO =
                URI_CONTENIDO_BASE.buildUpon().appendPath(RECURSO_PROPUESTAS).build();

        public final static String MIME_RECURSO =
                "vnd.android.cursor.item/vnd." + AUTORIDAD + "/" + RECURSO_PROPUESTAS;

        public final static String MIME_COLECCION =
                "vnd.android.cursor.dir/vnd." + AUTORIDAD + "/" + RECURSO_PROPUESTAS;


        /**
         * Construye una {@link Uri} para el {@link #ID_PROPUESTA} solicitado.
         */
        public static Uri construirUriPropuesta(String idPropuesta) {
            return URI_CONTENIDO.buildUpon().appendPath(idPropuesta).build();
        }

        public static String generarIdPropuesta() {
            return "A-" + UUID.randomUUID();
        }

        public static String obtenerIdPropuesta(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    // Recursos
    public final static String RECURSO_PROPUESTAS = "propuestas";

}
