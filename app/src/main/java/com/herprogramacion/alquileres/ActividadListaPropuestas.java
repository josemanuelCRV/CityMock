package com.herprogramacion.alquileres;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.herprogramacion.alquileres.provider.Contrato;

public class ActividadListaPropuestas
        extends AppCompatActivity implements AdaptadorPropuestas.OnItemClickListener, LoaderManager.LoaderCallbacks<Cursor> {
    public static String ID_PROPUESTA="";

    RecyclerView listaUI;
    LinearLayoutManager linearLayoutManager;
    private AdaptadorPropuestas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_lista_alquileres);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Filtro...", Snackbar.LENGTH_LONG)
                        .setAction("Acción", null).show();
            }
        });

        // Preparar lista
        listaUI = (RecyclerView) findViewById(R.id.lista);
        listaUI.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        listaUI.setLayoutManager(linearLayoutManager);

        adaptador = new AdaptadorPropuestas(this, this);
        listaUI.setAdapter(adaptador);
        // Iniciar loader
        getSupportLoaderManager().restartLoader(1, null, this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actividad_lista_alquileres, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(AdaptadorPropuestas.ViewHolder holder, String idPropuesta) {
        /*Snackbar.make(findViewById(android.R.id.content), ":id = " + idPropuesta,
                Snackbar.LENGTH_LONG).show();*/

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.listcontainer, new DetailFragment(), "detail");
        ID_PROPUESTA=idPropuesta;
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Añade efecto fade out
        ft.addToBackStack("detail");
        ft.commit();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, Contrato.Propuestas.URI_CONTENIDO, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (adaptador != null) {
            adaptador.swapCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
