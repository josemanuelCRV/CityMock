package com.herprogramacion.alquileres.UI;

/**
 * Created by JMC on 25/05/2016.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.herprogramacion.alquileres.DTO.Proposal;
import com.herprogramacion.alquileres.DetailFragment;
import com.herprogramacion.alquileres.R;

import java.util.Random;


/*
         Adaptador del RecyclerView que rellena la lista
        */
public class AdaptadorComment extends RecyclerView.Adapter<AdaptadorComment.ViewHolder> {
    private final Context contexto;
    private Proposal comment;


    //Constructor de la clase
    public AdaptadorComment(Context contexto, Proposal comments) {
        this.contexto = contexto;
        this.comment = comments;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // Referencias UI
        public ImageView viewImagenUser; //inyecta foto del usuario
        public TextView viewName;
        public TextView viewTimestamp;
        public TextView viewBodyComment;
        public TextView viewCid;


        @TargetApi(Build.VERSION_CODES.M)
        public ViewHolder(View v) {
            super(v);
            viewImagenUser = (ImageView) v.findViewById(R.id.fotoGravatar);
            viewName = (TextView) v.findViewById(R.id.name);
            viewCid = (TextView) v.findViewById(R.id.cid);
            viewTimestamp = (TextView) v.findViewById(R.id.timestamp);
            viewBodyComment = (TextView) v.findViewById(R.id.body);




            //extraemos el drawable en un bitmap
            /*Drawable originalDrawable = v.getResources().getDrawable(RandomHero.getHero().getResourceId());*/
            Drawable originalDrawable = v.getResources().getDrawable(R.drawable.photo_profile);
            Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

            //creamos el drawable redondeado
            RoundedBitmapDrawable roundedDrawable =
                    RoundedBitmapDrawableFactory.create(v.getResources(), originalBitmap);

            //asignamos el CornerRadius
            roundedDrawable.setCornerRadius(originalBitmap.getHeight());

            // seteamos el contenido mas abajo
            viewImagenUser.setImageDrawable(roundedDrawable);

        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_comment, parent, false);
        return new ViewHolder(v);
    }

    /*
    método moveToPosition() dentro de onBindViewHolder() para acceder a la posición del cursor dependiendo del parámetro position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {




       /* //Los recursos de una aplicación Android son integer de longitud 10, por tanto para cargar la imagen de un randonHero, guardada en memoria, es necesaria
        //hacer la comprobación, para realizar el casteo correspondiente
        if(comment.getPic_user().length()==10)
           Glide.with(contexto).load(Integer.parseInt(comment.getPic_user())).into(holder.viewImagenUser);
           // holder.viewImagenUser.setImageDrawable(roundImage);

        else
            Glide.with(contexto).load(comment.getPic_user()).into(holder.viewImagenUser);
            // holder.viewImagenUser.setImageDrawable(roundImage);
        */


        holder.viewName.setText(DetailFragment.Proposal.getUSER_NAME());
        holder.viewTimestamp.setText(DetailFragment.Proposal.getFECHA());
        holder.viewBodyComment.setText(DetailFragment.Proposal.getBODY_COMMENT()); // Consultar en api el username del id
        holder.viewCid.setText(String.valueOf((int)Math.floor(Math.random()*10)));


    }


    // Obtén la cantidad de ítems con el método getCount() del cursor.
    @Override
    public int getItemCount() {
        return 1;
    }


}

