package com.herprogramacion.alquileres.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.herprogramacion.alquileres.provider.Contrato.Propuestas;

/**
 * Clase auxiliar para controlar accesos a la base de datos SQLite
 */
public class BaseDatos extends SQLiteOpenHelper {

    static final int VERSION = 1;

    //static final String NOMBRE_BD = "alquileres.db";
    static final String NOMBRE_BD = "propuestas.db";


    interface Tablas {
        //String APARTAMENTO = "alquiler";
        String PROPUESTAS_TB = "propuesta";
    }

    public BaseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(

                "CREATE TABLE " + Tablas.PROPUESTAS_TB + "("
                        + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + Propuestas.ID_PROPUESTA + " TEXT UNIQUE NOT NULL,"
                        + Propuestas.TITULO + " TEXT NOT NULL,"
                        + Propuestas.URL_IMAGEN + " TEXT NOT NULL,"
                        + Propuestas.FECHA + " TEXT NOT NULL,"
                        + Propuestas.UBICACION + " TEXT NOT NULL,"
                        + Propuestas.DESCRIPCION + " TEXT NOT NULL,"
                        + Propuestas.STATUS + " TEXT NOT NULL,"
                        + Propuestas.STATUS_FLAG + " TEXT NOT NULL,"
                        + Propuestas.FOLLOW + " INTEGER NOT NULL,"
                        + Propuestas.REPAIRIT + " INTEGER NOT NULL,"
                        + Propuestas.IMG_PARALAX + " TEXT NOT NULL,"
                        + Propuestas.CATEGORIA + " TEXT NOT NULL,"
                        + Propuestas.LAT + " REAL NOT NULL,"
                        + Propuestas.LON + " REAL NOT NULL,"
                        + Propuestas.USER_NAME + " TEXT NOT NULL,"
                        + Propuestas.FOTO_USERCOM + " TEXT NOT NULL,"
                        + Propuestas.BODY_COMMENT + " TEXT NOT NULL)");


        // Registro ejemplo #1
        ContentValues valores = new ContentValues();
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "Dia sin coches");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/09/diasincoches-hackityapp.jpg");
        valores.put(Propuestas.FECHA, "22/09/2016 - 12:02");
        valores.put(Propuestas.UBICACION, "Plaza Puerta del Sol, 11, 28013 Madrid, Spain");
        valores.put(Propuestas.DESCRIPCION, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo.\");");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_open");
        valores.put(Propuestas.FOLLOW, "1");
        valores.put(Propuestas.REPAIRIT, "0");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/09/diasincoches-hackityapp.jpg");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "Maria");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);

        // Registro ejemplo #2
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "¡Peligro! Peatones");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/09/image.jpg");
        valores.put(Propuestas.FECHA, "23/09/2016 - 17:28");
        valores.put(Propuestas.UBICACION, "Calle Párroco Eusebio Cuenca, 26, 28045 Madrid, Spain");
        valores.put(Propuestas.DESCRIPCION, "Este paso de peatones tiene mucho peligro para cruzar ya que, como ven en la foto, hay un lado en el que pueden aparcar los coches y hay menos visibilidad, además de que se sitúa después de una curva.");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_close");
        valores.put(Propuestas.FOLLOW, "2");
        valores.put(Propuestas.REPAIRIT, "0");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/09/image.jpg");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "juan");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);

        // Registro ejemplo #3
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "«Bricomanía» | Arte en las carreteras");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/08/zzzz_2.jpg");
        valores.put(Propuestas.FECHA, "23/08/2016 - 11:50");
        valores.put(Propuestas.UBICACION, "Plaza Puerta del Sol, 11, 28013 Madrid, Spain");
        valores.put(Propuestas.DESCRIPCION, "Es una iniciativa que pretende difundir por España el arte de vanguardia, sobre camiones de mercancías que hacen rutas comerciales.\");");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_open");
        valores.put(Propuestas.FOLLOW, "0");
        valores.put(Propuestas.REPAIRIT, "0");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/08/zzzz_2.jpg");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "juan");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);

        // Registro ejemplo #4
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "Derroche de agua y peligro");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/08/zzz_3.jpg");
        valores.put(Propuestas.FECHA, "19/08/2016 - 15:12");
        valores.put(Propuestas.UBICACION, "Plaza de San Juan de la Cruz, 2-3, 28003 Madrid, Spain");
        valores.put(Propuestas.DESCRIPCION, "En la plaza frente al Ministerio de Medioambiente -en su isleta lateral-, se aprecia que el riego por aspersión encharca grandes zonas de la carretera, suponiendo un derroche innecesario.");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_open");
        valores.put(Propuestas.FOLLOW, "4");
        valores.put(Propuestas.REPAIRIT, "1");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/08/zzz_3.jpg");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "juan");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);


        // Registro ejemplo #5
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "Sin bordillo y asfalto en mal estado.");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/07/zzz_2.jpg");
        valores.put(Propuestas.FECHA, "05/07/2016 - 16:01");
        valores.put(Propuestas.UBICACION, "Calle de Candilejas, 5, 28018 Madrid, Spain");
        valores.put(Propuestas.DESCRIPCION, "Mediana en Candilejas -cruce con Avenida de Palomeras Bajas-.28018 Madrid.");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_open");
        valores.put(Propuestas.FOLLOW, "2");
        valores.put(Propuestas.REPAIRIT, "0");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/07/zzz_2.jpg");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "juan");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);

        // Registro ejemplo #6
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "!Avenida San Diego 83 -¿3a reparación?-");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/06/zzz_1.jpg");
        valores.put(Propuestas.FECHA, "24/06/2016 - 18:38");
        valores.put(Propuestas.UBICACION, "Av. de San Diego, 83, 28018 Madrid, Madrid, Spain, ");
        valores.put(Propuestas.DESCRIPCION, "Baldosas rotas. Bolardo tapado con una baldosa sin poner = volver a gastar en reparar baldosas.");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_open");
        valores.put(Propuestas.FOLLOW, "2");
        valores.put(Propuestas.REPAIRIT, "1");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/06/zzz_1.jpg");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "juan");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);

        // Registro ejemplo #7
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "!¿Bolardo arrancado?: Se oculta con algo de cemento ¡y ya está!.. -2ª-");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/07/zzz_5.jpg");
        valores.put(Propuestas.FECHA, "11/07/2016 - 15:23");
        valores.put(Propuestas.UBICACION, "Calle del Dr. Bellido, 37, 28018 Madrid, Spain");
        valores.put(Propuestas.DESCRIPCION, "Viene de: https://www.hackityapp.com/es/propuestas/spain/comunidad-de-madrid/madrid/doctor-bellido-37-bolard");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_open");
        valores.put(Propuestas.FOLLOW, "3");
        valores.put(Propuestas.REPAIRIT, "1");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/07/zzz_5.jpg");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "juan");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);


        // Registro ejemplo #8
        valores.put(Propuestas.ID_PROPUESTA, Propuestas.generarIdPropuesta());
        valores.put(Propuestas.TITULO, "Paso cebra al mercadona");
        valores.put(Propuestas.URL_IMAGEN, "https://www.hackityapp.com/sites/pro/files/proposals/2016/07/paso%20de%20cebra.png");
        valores.put(Propuestas.FECHA, "30/06/2016 - 19:37");
        valores.put(Propuestas.UBICACION, "Calle de Sta. María, 64-66, 28229 Villanueva del Pardillo, Madrid, Spain, ");
        valores.put(Propuestas.DESCRIPCION, "Propongo mover el paso de cebra de la calle San Pablo a la altura de la calle Santa Maria para poder cruzar al mercadona. En su posicion actual no es util.");
        valores.put(Propuestas.STATUS, "Abierta");
        valores.put(Propuestas.STATUS_FLAG, "flag_open");
        valores.put(Propuestas.FOLLOW, "1");
        valores.put(Propuestas.REPAIRIT, "0");
        valores.put(Propuestas.IMG_PARALAX, "https://www.hackityapp.com/sites/pro/files/proposals/2016/07/paso%20de%20cebra.png");
        valores.put(Propuestas.CATEGORIA, "Movilidad");
        valores.put(Propuestas.LAT, "40.2657");
        valores.put(Propuestas.LON, "-3.2657");
        valores.put(Propuestas.USER_NAME, "juan");
        valores.put(Propuestas.FOTO_USERCOM, "https://www.hackityapp.com/modules/custom/hck_comment/img/default-avatar.png");
        valores.put(Propuestas.BODY_COMMENT, "Hoy se celebra el día sin coches. Me gustaría que se celebrara más a menudo y que la gente pudiera moverse más en bici, transporte público o caminando");
        db.insertOrThrow(Tablas.PROPUESTAS_TB, null, valores);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + Tablas.PROPUESTAS_TB);
        } catch (SQLiteException e) {
            // Manejo de excepciones
        }
        onCreate(db);
    }
}
