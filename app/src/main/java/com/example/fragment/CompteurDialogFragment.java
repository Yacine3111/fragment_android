package com.example.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CompteurDialogFragment extends DialogFragment {
    public static String TAG = "CompteurDialogFragment";
    private final Operation operation;

    public CompteurDialogFragment(Operation operation) {
        this.operation = operation;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(String.format(getString(R.string.dialog_operation), operation.heure, operation.resultat))
                .setPositiveButton(getString(R.string.action_ok), (dialog, which) -> {
                })
                .create();
    }
}
