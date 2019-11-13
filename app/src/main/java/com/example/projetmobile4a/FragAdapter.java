package com.example.projetmobile4a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> myFragList = new ArrayList<>();

    // Notre constructeur, pour pouvoir l'utiliser dans d'autre class
    public FragAdapter( FragmentManager fm) {
        super(fm);
    }

    @Override //On récupere l'index dans notre tableau de fragment
    public Fragment getItem(int position) {
        return myFragList.get(position);
    }

    @Override // On récupere la taille du tableau, ici 3 car 3 fragments
    public int getCount() {
        return myFragList.size();
    }

    public void addFragment(Fragment fragment){ //On ajoute le fragment à la list des fragments(le tableau)
        myFragList.add(fragment);
    }
}
