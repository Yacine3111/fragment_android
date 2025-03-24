package com.example.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompteurViewModel extends ViewModel {
    private final MutableLiveData<Integer> compteur = new MutableLiveData<>();

    public LiveData<Integer> getCompteur(){
        return compteur;
    }

    public LiveData<Integer> incrementerCompteur(){
        int valeurActuelle = compteur.getValue() != null ? compteur.getValue() : 0;

        valeurActuelle+=1;

        compteur.setValue(valeurActuelle);

        return compteur;
    }
    public LiveData<Integer> decrementerCompteur(){
        int valeurActuelle = compteur.getValue() != null ? compteur.getValue() : 0;

        valeurActuelle-=1;

        compteur.setValue(valeurActuelle);

        return compteur;
    }
    public LiveData<Integer> reinitialiserCompteur(){
        compteur.setValue(0);
        return compteur;
    }

}
