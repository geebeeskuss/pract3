package com.example.pract3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pract3.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(
                            R.id.second_fragment_container,
                            ChildFragment.class,
                            null
                    )
                    .commit();
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSecondBinding binding = FragmentSecondBinding.inflate(getLayoutInflater());

        getParentFragmentManager().setFragmentResultListener("request_key",
                this, (requestKey, bundle) -> {
                    String result = bundle.getString("bundle_key");
                    binding.textView2.setText(result);
                });

        getChildFragmentManager().setFragmentResultListener("child_r_key",
                this, ((requestKey, result) -> {
                    binding.textView2.setText(result.getString("bundle_key"));
                }));

        return binding.getRoot();
    }
}