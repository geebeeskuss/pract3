package com.example.pract3;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pract3.databinding.FragmentChildBinding;

public class ChildFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChildBinding binding = FragmentChildBinding.inflate(getLayoutInflater());

        binding.sendButton.setOnClickListener(view -> {
            Bundle result = new Bundle();
            result.putString("bundle_key", "Результат переданный от дочернего фрагмента");
            getParentFragmentManager().setFragmentResult("child_r_key", result);
        });

        return binding.getRoot();
    }
}