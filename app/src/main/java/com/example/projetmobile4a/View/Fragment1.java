package com.example.projetmobile4a.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;


public class Fragment1 extends Fragment {

    public View view;
    public int i;

    public Fragment1(int i) {
        this.i = i;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        view = inflater.inflate(R.layout.fragment_layout1, container, false); //On suit le style de fragment_layout1
        addInformation(view, i);
        return view;
    }


    private void addInformation(View viewn, int i) {
            //String Nom = getActivity().getIntent().getStringExtra("Nom");

            String JSONkey = getActivity().getIntent().getStringExtra("JSONkey");
            Gson gson = new Gson();
            MyList JSONlist = gson.fromJson(JSONkey, MyList.class);


            Log.d("FRAG1: ImageURL",JSONlist.getImage());
            Log.d("FRAG1: Nom",JSONlist.getName());
            Log.d("FRAG1: Transformation",JSONlist.getTransformation().get(0).getStade());


            setInfo(JSONlist, view, i);

            CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.CollapsingToolBar);
            collapsingToolbarLayout.setTitle(JSONlist.getName());
            collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.collapsedappbar);
            collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);

    }

    private void setInfo(MyList JSONlist, View view, int i){

        TextView DetailNom = view.findViewById((R.id.DetailName));
        DetailNom.setText(JSONlist.getName());

        TextView DetailStatus = view.findViewById((R.id.DetailStatus));
        DetailStatus.setText(JSONlist.getStatus());

        TextView DetailRace = view.findViewById((R.id.DetailRace));
        DetailRace.setText(JSONlist.getRace());

        ImageView DetailImage = view.findViewById(R.id.DetailImage);
        Picasso.get().load(JSONlist.getTransformation().get(i).getImage()).into(DetailImage);
    }

}