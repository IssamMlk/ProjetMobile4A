package com.example.projetmobile4a.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmobile4a.Model.MyTransformationList;
import com.example.projetmobile4a.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TabTransformationAdapter extends RecyclerView.Adapter<TabTransformationAdapter.ViewHolder>{

    private List<String> listItems;
    private Context context;

    public TabTransformationAdapter(List<String> listItems, Context context) {
        this.listItems = listItems;
        this.context=context;
    }


    @Override
    public TabTransformationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater
                .inflate(R.layout.testlayout, parent, false);
        TabTransformationAdapter.ViewHolder viewHolder = new TabTransformationAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( TabTransformationAdapter.ViewHolder holder, int position) {
        final String listItem = listItems.get(position);
        holder.Stade.setText(listItem);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Stade;

        public ViewHolder(View itemView) {
            super(itemView);
            Stade = itemView.findViewById(R.id.cell_txt_classes_role);
           //Log.d("TABLEAU", String.valueOf(DetailStade));
        }
    }
}
