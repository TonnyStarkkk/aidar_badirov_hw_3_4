package com.example.aidar_badirov_hw_3_4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aidar_badirov_hw_3_4.databinding.FragmentContinentBinding;

import java.util.ArrayList;

public class ContinentFragment extends Fragment implements OnClick{
    private FragmentContinentBinding binding;
    private ArrayList<String> continentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        ContinentAdapter continentAdapter = new ContinentAdapter(continentList, this);
        binding.rvContinent.setAdapter(continentAdapter);
    }

    private void loadData() {
        continentList.add("Eurasia");
        continentList.add("Africa");
        continentList.add("Australia");
        continentList.add("North America");
        continentList.add("South America");
    }

    @Override
    public void click(int position) {
        Bundle bundle = new Bundle();
        String continent = continentList.get(position);
        bundle.putString("Continent", continent);
        CountryFragment countryFragment = new CountryFragment();
        countryFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, countryFragment).addToBackStack(null).commit();
    }
}