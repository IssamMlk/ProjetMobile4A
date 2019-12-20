package com.example.projetmobile4a.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private List<MyList> listItems;
    private List<MyList> searchList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {//On recupere ce que l'on souhaite afficher à l'ecran dans le layout

        CircleImageView ImageAcceuil;
        public ViewHolder(View itemView) {
            super(itemView);
            ImageAcceuil = itemView.findViewById(R.id.ImageAcceuil);
        }
    }

    //Constructeur: Permet d'appeler la class dans une autre class
    public RecyclerViewAdapter(List<MyList> listItems, Context context) {
        this.listItems = listItems;
        searchList = new ArrayList<>(listItems);
        this.context = context;
    }

    @Override // On utilise acceuil_layout comme affichge(Les données doivent apparaitre en suivant les régles fixés par ce layout
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.acceuil_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override //On recupere l'index avec position et on affiche le texte et l'image
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final MyList listItem = listItems.get(position);

        Picasso.get().load(listItem.getImage()).into(holder.ImageAcceuil);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listItem.getName(),Toast.LENGTH_SHORT).show();

               Intent intent = new Intent(context, DetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Gson gson = new Gson();
                intent.putExtra("JSONkey", gson.toJson(listItem));
                intent.putExtra("Nom",listItem.getName());
                //intent.putExtra("ImageURL",listItem.getImage());


                context.startActivity(intent);
            }
        });

    }

    @Override //On retourne le nombre d'élement à afficher
    public int getItemCount() {
        return listItems.size();
    }




    @Override
    public Filter getFilter() {
        return myFilter;
    }

    private Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<MyList> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filteredList.addAll(searchList);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(MyList item: searchList){
                    if(item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values=filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listItems.clear();
            listItems.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


}
