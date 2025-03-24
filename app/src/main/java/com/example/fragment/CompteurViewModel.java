package com.example.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompteurViewModel extends ViewModel {
    private final MutableLiveData<Integer> compteur = new MutableLiveData<>();

}
