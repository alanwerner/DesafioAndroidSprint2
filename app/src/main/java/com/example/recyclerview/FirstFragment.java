package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapter.ListaPaisesAdapter;
import com.example.recyclerview.adapter.listener.OnItemClickListener;
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
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(CountryCovidData pais, int posicao) {
                Fragment fragment = new SecondFragment();
                Bundle pacoteDeDados = new Bundle();
                CountryCovidData dadosCovidPais = listaDadosCovidPais.get(posicao);
                pacoteDeDados.putSerializable("dadosPais", dadosCovidPais);
                fragment.setArguments(pacoteDeDados);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, pacoteDeDados);
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}