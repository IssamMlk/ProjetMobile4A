package com.example.projetmobile4a.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.projetmobile4a.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;


public class Fragment1 extends Fragment {

    public View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        view = inflater.inflate(R.layout.fragment_layout1, container, false); //On suit le style de fragment_layout1
        addInformation();
        return view;
    }


    private void addInformation() {
        if (getActivity().getIntent().hasExtra("ImageURL") && getActivity().getIntent().hasExtra("Nom")) {
            String ImageURL = getActivity().getIntent().getStringExtra("ImageURL");
            String Nom = getActivity().getIntent().getStringExtra("Nom");
            String Status = getActivity().getIntent().getStringExtra("Status");
            String Race = getActivity().getIntent().getStringExtra("Race");
            String Planete = getActivity().getIntent().getStringExtra("Planete");
            String Univers = getActivity().getIntent().getStringExtra("Univers");
            String Groupe = getActivity().getIntent().getStringExtra("Groupe");
            String Capacite = getActivity().getIntent().getStringExtra("Capacite");
            String Description = getActivity().getIntent().getStringExtra("Description");

            /*Log.d("Detail: ImageURL",getActivity().getIntent().getStringExtra("ImageURL"));
            Log.d("Detail: Nom",getActivity().getIntent().getStringExtra("Nom"));
            Log.d("Detail: Status",getActivity().getIntent().getStringExtra("Status"));
            Log.d("Detail: Race",getActivity().getIntent().getStringExtra("Race"));
            Log.d("Detail: Planete",getActivity().getIntent().getStringExtra("Planete"));
            Log.d("Detail: Groupe", getActivity().getIntent().getStringExtra("Groupe"));*/


            setInfo(ImageURL, Nom, Status, Race, Planete, Univers, Groupe, Capacite, Description);

            CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.CollapsingToolBar);
            collapsingToolbarLayout.setTitle(Nom);
            collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.collapsedappbar);
            collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);

        }
    }

    private void setInfo(String ImageURL, String Nom, String Status, String Race, String Planete,String Univers, String Groupe, String Capacite, String Description ){
        TextView DetailNom = view.findViewById((R.id.DetailName));
        DetailNom.setText(Nom);

        TextView DetailStatus = view.findViewById((R.id.DetailStatus));
        DetailStatus.setText(Status);

        TextView DetailRace = view.findViewById((R.id.DetailRace));
        DetailRace.setText(Race);

        TextView DetailPlanete = view.findViewById((R.id.DetailPlanete));
        DetailPlanete.setText(Planete);

        TextView DetailUnivers = view.findViewById((R.id.DetailUnivers));
        DetailUnivers.setText(Univers);

        TextView DetailGroupe = view.findViewById(R.id.DetailGroupe);
        DetailGroupe.setText(Groupe);

        TextView DetailCapacite = view.findViewById(R.id.DetailCapacite);
        DetailCapacite.setText(Capacite);

        TextView DetailDescription = view.findViewById(R.id.DetailDescription);
        DetailDescription.setText(Description);

        ImageView DetailImage = view.findViewById(R.id.DetailImage);
        Picasso.get().load(ImageURL).into(DetailImage);
    }

}