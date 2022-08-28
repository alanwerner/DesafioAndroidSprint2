package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapter.ListaPaisesAdapter;
import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCovidDataListFromJson;
import com.example.recyclerview.databinding.FragmentFirstBinding;

import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ListaPaisesAdapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<CountryCovidData> listaDadosCovidPais = new GetCovidDataListFromJson().execute(getContext());
        RecyclerView listaPaises = binding.listaPaisesRecyclerView;
        adapter = new ListaPaisesAdapter(listaDadosCovidPais, getContext());
        listaPaises.setAdapter(adapter);
    }

    

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}