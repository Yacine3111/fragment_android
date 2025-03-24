package com.example.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CompteurViewModel extends ViewModel {
    private final MutableLiveData<Integer> compteur = new MutableLiveData<>();

    private final MutableLiveData<List<Operation>> historique = new MutableLiveData<>();

    public CompteurViewModel(){
        compteur.setValue(0);

        historique.setValue(new ArrayList<>());
    }

    public LiveData<Integer> getCompteur(){
        return compteur;
    }

    public LiveData<List<Operation>> getHistorique(){
        return historique;
    }

    private void ajouterOperation(OperationType type, int valeur){
        List<Operation> operations = historique.getValue();

        operations.add(new Operation(valeur,type));

        historique.setValue(operations);
    }

    public void incrementerCompteur(){
        int valeurActuelle = compteur.getValue() != null ? compteur.getValue() : 0;

        valeurActuelle+=1;

        compteur.setValue(valeurActuelle);

        ajouterOperation(OperationType.Incrementer,valeurActuelle);

    }
    public void decrementerCompteur(){
        int valeurActuelle = compteur.getValue() != null ? compteur.getValue() : 0;

        valeurActuelle-=1;

        compteur.setValue(valeurActuelle);
        ajouterOperation(OperationType.Decrementer,valeurActuelle);

    }
    public void reinitialiserCompteur(){
        compteur.setValue(0);
        ajouterOperation(OperationType.Reinitialiser,0);

    }

    public int getOperationResId(OperationType operationType){
        switch (operationType){
            case Incrementer:
                return R.string.action_increment;
            case Decrementer:
                return R.string.action_decrement;
            case Reinitialiser:
                return R.string.action_reinitialiser;
            default:
                return R.string.action_invalide;
        }
    }

}
