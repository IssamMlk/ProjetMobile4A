package com.example.projetmobile4a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.MODE_PRIVATE;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<MyList> listItems;
    private Context context;


    //Constructeur: Permet d'appeler la class dans une autre class
    public RecyclerViewAdapter(List<MyList> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override // On utilise acceuil_layout comme affichge(Les données doivent apparaitre en suivant les régles fixés par ce layout
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.acceuil_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override //On recupere l'index avec position et on affiche le texte et l'image
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyList listItem = listItems.get(position);
        holder.TitreAcceuil.setText(listItem.getName());
        Picasso.get().load(listItem.getImage()).into(holder.ImageAcceuil);
    }

    @Override //On retourne le nombre d'élement à afficher
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {//On recupere ce que l'on souhaite afficher à l'ecran dans le layout

        CircleImageView ImageAcceuil;
        TextView TitreAcceuil;
        public ViewHolder(View itemView) {
            super(itemView);
            ImageAcceuil = itemView.findViewById(R.id.ImageAcceuil);
            TitreAcceuil = itemView.findViewById(R.id.TitreAcceuil);
        }
    }

}
