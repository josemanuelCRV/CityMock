package com.herprogramacion.alquileres.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import com.herprogramacion.alquileres.provider.BaseDatos.Tablas;
import com.herprogramacion.alquileres.provider.Contrato.Propuestas;


/**
 * {@link ContentProvider} que encapsula el acceso a la base de datos de apartamentos
 */
public class ProviderApartamentos extends ContentProvider {

    // Comparador de URIs
    public static final UriMatcher uriMatcher;

    // Casos
    public static final int PROPUESTAS = 100;
    public static final int PROPUESTAS_ID = 101;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(Contrato.AUTORIDAD, "propuestas", PROPUESTAS);
        uriMatcher.addURI(Contrato.AUTORIDAD, "propuestas/*", PROPUESTAS_ID);
    }

    private BaseDatos bd;
    private ContentResolver resolver;


    @Override
    public boolean onCreate() {
        bd = new BaseDatos(getContext());
        resolver = getContext().getContentResolver();
        return true;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case PROPUESTAS:
                return Propuestas.MIME_COLECCION;
            case PROPUESTAS_ID:
                return Contrato.Propuestas.MIME_RECURSO;
            default:
                throw new IllegalArgumentException("Tipo desconocido: " + uri);
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // Obtener base de datos
        SQLiteDatabase db = bd.getWritableDatabase();
        // Comparar Uri
        int match = uriMatcher.match(uri);

        Cursor c;

        switch (match) {
            case PROPUESTAS:
                // Consultando todos los registros
                c = db.query(Tablas.PROPUESTAS_TB, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, Contrato.Propuestas.URI_CONTENIDO);
                break;
            case PROPUESTAS_ID:
                // Consultando un solo registro basado en el Id del Uri
                String idPropuesta = Propuestas.obtenerIdPropuesta(uri);
                c = db.query(Tablas.PROPUESTAS_TB, projection,
                        Propuestas.ID_PROPUESTA + "=" + "\'" + idPropuesta + "\'"
                                + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;
            default:
                throw new IllegalArgumentException("URI no soportada: " + uri);
        }
        return c;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }
}
