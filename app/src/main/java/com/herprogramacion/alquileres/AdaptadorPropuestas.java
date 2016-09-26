package com.herprogramacion.alquileres;

import android.content.Context;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.herprogramacion.alquileres.DTO.Proposal;


/**
 * Adaptador con un cursor para poblar la lista de alquileres desde SQLite
 */
public class AdaptadorPropuestas extends RecyclerView.Adapter<AdaptadorPropuestas.ViewHolder> {
    private final Context contexto;
    private Cursor items;

    private OnItemClickListener escucha;

    interface OnItemClickListener {
        public void onClick(ViewHolder holder, String idPropuesta);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        // Referencias UI
        TextView viewTitle;
         TextView viewUbicacion;
         TextView viewBody;
         ImageView viewFoto;
         TextView viewFecha;
         TextView viewEstado;
         ImageView viewFlagState;
         TextView viewFollowers;
         TextView viewRepairit;
         FloatingActionButton viewFabFollow;


         ViewHolder(View itemView) {
            super(itemView);
            viewTitle = (TextView) itemView.findViewById(R.id.titulo);
            viewFoto = (ImageView) itemView.findViewById(R.id.foto);
            viewFecha = (TextView) itemView.findViewById(R.id.fecha);
            viewUbicacion = (TextView) itemView.findViewById(R.id.ubicacion);
            viewBody = (TextView) itemView.findViewById(R.id.descripcion);
            viewEstado = (TextView) itemView.findViewById(R.id.status);
            viewFlagState = (ImageView) itemView.findViewById(R.id.status_flag);
            viewFollowers = (TextView) itemView.findViewById(R.id.followers);
            viewRepairit = (TextView) itemView.findViewById(R.id.repairers);
            viewFabFollow = (FloatingActionButton) itemView.findViewById(R.id.btnFollow);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            escucha.onClick(this, obtenerIdAlquiler(getAdapterPosition()));

        }
    }

    private String obtenerIdAlquiler(int posicion) {
        if (items != null) {
            if (items.moveToPosition(posicion)) {
                Proposal proposal= new Proposal();
                fillProposal(proposal);
                DetailFragment.Proposal = proposal;
                return items.getString(ConsultaPropuestas.ID_PROPUESTA);
            }
        }

        return null;
    }

    private void fillProposal(Proposal proposal) {
        proposal.setID_PROPUESTA(items.getString(ConsultaPropuestas.ID_PROPUESTA));
        proposal.setTITULO(items.getString(ConsultaPropuestas.TITULO));
        proposal.setURL_IMAGEN(items.getString(ConsultaPropuestas.URL_IMAGEN));
        proposal.setFECHA(items.getString(ConsultaPropuestas.FECHA));
        proposal.setUBICACION(items.getString(ConsultaPropuestas.UBICACION));
        proposal.setDESCRIPCION(items.getString(ConsultaPropuestas.DESCRIPCION));
        proposal.setSTATUS(items.getString(ConsultaPropuestas.STATUS));
        proposal.setFOLLOW(items.getString(ConsultaPropuestas.FOLLOW));
        proposal.setREPAIRIT(items.getString(ConsultaPropuestas.REPAIRIT));
        proposal.setIMG_PARALAX(items.getString(ConsultaPropuestas.IMG_PARALAX));
        proposal.setCATEGORIA(items.getString(ConsultaPropuestas.CATEGORIA));
        proposal.setLAT(items.getString(ConsultaPropuestas.LAT));
        proposal.setLON(items.getString(ConsultaPropuestas.LON));
        proposal.setUSER_NAME(items.getString(ConsultaPropuestas.USER_NAME));
        proposal.setFOTO_USERCOM(items.getString(ConsultaPropuestas.FOTO_USERCOM));
        proposal.setBODY_COMMENT(items.getString(ConsultaPropuestas.BODY_COMMENT));
    }

    AdaptadorPropuestas(Context contexto, OnItemClickListener escucha) {
        this.contexto = contexto;
        this.escucha = escucha;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_alquiler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        items.moveToPosition(position);

        String s;

        // Asignación UI
        s = items.getString(ConsultaPropuestas.TITULO);
        holder.viewTitle.setText(s);

        s = items.getString(ConsultaPropuestas.URL_IMAGEN);
        Glide.with(contexto).load(s).centerCrop().into(holder.viewFoto);

        s = items.getString(ConsultaPropuestas.FECHA);
        holder.viewFecha.setText(s);

        s = items.getString(ConsultaPropuestas.UBICACION);
        holder.viewUbicacion.setText(s);

        s = items.getString(ConsultaPropuestas.DESCRIPCION);
        holder.viewBody.setText(s);

        s = items.getString(ConsultaPropuestas.STATUS);
        holder.viewEstado.setText(s);

        s = items.getString(ConsultaPropuestas.STATUS_FLAG);
        Glide.with(contexto).load(s).centerCrop().into(holder.viewFlagState);

        s = items.getString(ConsultaPropuestas.FOLLOW);
        holder.viewFollowers.setText(String.format("Seguir %s", s));

        s = items.getString(ConsultaPropuestas.REPAIRIT);
        holder.viewRepairit.setText(String.format("Repair it %s", s));

    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor) {
        if (nuevoCursor != null) {
            items = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public Cursor getCursor() {
        return items;
    }

    interface ConsultaPropuestas {
        int ID_PROPUESTA = 1;
        int TITULO = 2;
        int URL_IMAGEN = 3;
        int FECHA = 4;
        int UBICACION = 5;
        int DESCRIPCION = 6;
        int STATUS = 7;
        int STATUS_FLAG = 8;
        int FOLLOW = 9;
        int REPAIRIT = 10;
        int IMG_PARALAX = 11;
        int CATEGORIA = 12;
        int LAT = 13;
        int LON = 14;
        int USER_NAME = 15;
        int FOTO_USERCOM = 16;
        int BODY_COMMENT = 17;



    }
}
