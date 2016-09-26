package com.herprogramacion.alquileres;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.herprogramacion.alquileres.DTO.Proposal;
import com.herprogramacion.alquileres.UI.AdaptadorComment;
/*import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.labs.josemanuel.reportcenter.Controler.JsonConstants;
import com.labs.josemanuel.reportcenter.Controler.PropuestaHandler;
import com.labs.josemanuel.reportcenter.Infrastructure.Infrastructure;
import com.labs.josemanuel.reportcenter.Model.Propuesta;
import com.labs.josemanuel.reportcenter.Model.RandomHero;
import com.labs.josemanuel.reportcenter.Model.Taxonomia;
import com.labs.josemanuel.reportcenter.Model.User;
import com.labs.josemanuel.reportcenter.R;
import com.labs.josemanuel.reportcenter.ui.AdaptadorComment;
import com.labs.josemanuel.reportcenter.ui.InteractiveScrollView;
*/

public class DetailFragment extends Fragment {


    /**
     * Etiqueta de depuración
     */
    public static final String TAG = DetailFragment.class.getSimpleName();
    public static  Proposal Proposal=null;


    /*
    Instancias de Views
     */
    private ImageView bgCategoria;
    private ImageView viewCabeceraDetalle;
    private TextView viewTituloDetalle;
    private TextView viewDescripcionDetalle;
    private TextView viewFechaDetalle;
    private TextView viewCategoriaDetalle;
    private TextView viewDireccion;
    private TextView viewEstado;
    private ImageView viewFlagState;
    private String abierta = "1";
    private ImageButton editButton;
    private String extra;
    private ScrollView panoflasquesomos;

    private ImageView viewImageParalax;


    // para identificacion de usuario
    private TextView viewUsername;
    private ImageView viewFoto;


    // inicializadas en el constructor de clase.
    private Double lat;
    private Double lon;

    AdaptadorComment mAdapter;

    /*
    instancia global del administrador
     */
    private RecyclerView.LayoutManager lManager;
    // scroll con acción Interactiva
    private InteractiveScrollView scrollView;
    // contenedor de los comentarios
    private LinearLayout comentariosContainer;
    private ImageButton btnVolver;

    // instancia SupportMapFragment para el mapa
     private MapFragment mSupportMapFragment;

    // Propuesta seleccionada
    // private Propuesta PropSeleecionada = Infrastructure.getPropuestaSeleccionada();


    // CONSTRUCTOR DE CLASE
    // inicializadas las variables que recogen la localización
    public DetailFragment() {
        /*lon = Double.valueOf(PropSeleecionada.getLoc().getLongitude());
        lat = Double.valueOf(PropSeleecionada.getLoc().getLatitude());*/
    }

    // crea instancia de Detail_Fragment
    public static DetailFragment createInstance(String idNodo) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();

       // bundle.putString(JsonConstants.NID, idNodo);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // infla la vista con el fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);


        // vinculando los componentes de la vista
        //  bgCategoria = (ImageView) v.findViewById(R.id.bg_category);  // preparada para taxonomy
        //  viewCabeceraDetalle = (ImageView) v.findViewById(R.id.cabecera);

        // nuevo para usuario nombre y foto
        viewUsername = (TextView) v.findViewById(R.id.username_detail);
        viewFoto = (ImageView) v.findViewById(R.id.fotouser_detail);


        viewTituloDetalle = (TextView) v.findViewById(R.id.titulo);
        viewDescripcionDetalle = (TextView) v.findViewById(R.id.descripcion);
        viewFechaDetalle = (TextView) v.findViewById(R.id.fecha);
        viewCategoriaDetalle = (TextView) v.findViewById(R.id.categoria);
        viewDireccion = (TextView) v.findViewById(R.id.direccion);
        viewEstado = (TextView) v.findViewById(R.id.estado);
        viewFlagState = (ImageView) v.findViewById(R.id.flag_category); // Flag / Flag_Check_Done


        editButton = (ImageButton) v.findViewById(R.id.fab); // boton para Editar Propuesta
//        btnVolver = (ImageButton) v.findViewById(R.id.btnBack); // sin uso ahora el Fab

        // Scroll general que contiene los Datos Detalle Propuesta + Contenedor Comentarios
        panoflasquesomos = (ScrollView) v.findViewById(R.id.panoflasquesomos);

        mSupportMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapwhere);
        //loadMap();




        viewImageParalax = (ImageView) v.findViewById(R.id.image_paralax);


        // Contenedor Comentarios que muestra las Cards
        comentariosContainer = (LinearLayout) v.findViewById(R.id.comentariosContainer);

        // Aplica InteractiveScrollView al scroll en el que se muestran las cards de comentarios
        scrollView = (InteractiveScrollView) v.findViewById(R.id.comentarios);

        // adapter recoge el Comentario seleccionado
        mAdapter = new AdaptadorComment(getContext(), Proposal);

        // introduce en el scroll la propuesta seleccionada almacenada en el adaptador
        scrollView.setAdapter(mAdapter);


        // Usar un administrador para LinearLayout y aplicarlo al scroll
        lManager = new LinearLayoutManager(getContext());
        scrollView.setLayoutManager(lManager);

        // Hace visible el contenedor de los comentarios
        comentariosContainer.setVisibility(View.VISIBLE);

        // Obtener extra del intent de envío
        //extra = getArguments().getString(Constantes.EXTRA_ID);

        // Cargar datos desde el web service
        cargarDatos();


        loadImageParallax();// Cargar Imagen


        return v;


    } // fin onCreate

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        loadMap();
    }

    private void loadMap() {
        if (mSupportMapFragment == null) {
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
            mSupportMapFragment = MapFragment.newInstance();
            fragmentTransaction.replace(R.id.mapwhere, mSupportMapFragment).commit();
        }

        if (mSupportMapFragment != null) {
            mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    if (googleMap != null) {

                        googleMap.getUiSettings().setAllGesturesEnabled(true);

                        // -> marker_latlng recoge la latitud y longitud en formato double//
                        LatLng marker_latlng = new LatLng(Double.parseDouble(Proposal.getLAT()), Double.parseDouble(Proposal.getLON()));
                        // configurando la vista del mapa, setea posición, mueve la camara,aplica zoom, coloca título y controles
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(marker_latlng).zoom(15.0f).build();
                        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                        googleMap.moveCamera(cameraUpdate);
                        googleMap.addMarker(new MarkerOptions().position(marker_latlng).title(Proposal.getTITULO()));
                        googleMap.getUiSettings().setCompassEnabled(true);
                        googleMap.getUiSettings().setZoomControlsEnabled(true);

                    }
                }
            });

        }
    }

    /**
     * Obtiene los datos desde el servidor
     */
    public void cargarDatos() {

        /**
         * SETEA LOS VALORES
         *
         */
        // TITULO
       viewTituloDetalle.setText(Proposal.getTITULO());

        // DESCRIPCION
        viewDescripcionDetalle.setText(Proposal.getDESCRIPCION());

        // FECHA
        viewFechaDetalle.setText(Proposal.getFECHA());

        // DIRECCION
        viewDireccion.setText(Proposal.getUBICACION());

        // CATEGORIA
        viewCategoriaDetalle.setText(Proposal.getCATEGORIA());

        // ESTADO -  abierta/cerrada
        if (abierta.equals(Proposal.getSTATUS())) {
            viewEstado.setText("Abierta");
            viewFlagState.setImageResource(R.drawable.ic_bookmark); // cambia la bandera
        } else {
            viewEstado.setText("Cerrada");
            viewFlagState.setImageResource(R.drawable.bookmark_check);
        }
        viewUsername.setText(Proposal.getUSER_NAME());
        Glide.with(this)
                .load(Proposal.getFOTO_USERCOM())
                .centerCrop()
                .into(viewFoto);
        loadMap();
    }


    /**
     * Se carga una imagen aleatoria para el detalle
     */
    public void loadImageParallax() {
        if (Proposal.getURL_IMAGEN() != null)
            Glide.with(this)
                    .load(Proposal.getURL_IMAGEN())
                    .centerCrop()
                    .into(viewImageParalax);

    }


}
