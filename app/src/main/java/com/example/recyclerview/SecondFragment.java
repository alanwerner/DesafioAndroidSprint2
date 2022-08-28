package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle pacoteDeDados = getArguments();
        CountryCovidData dadosCovidPais = (CountryCovidData) pacoteDeDados.getSerializable("dadosPais");

        TextView nomePaisDado = binding.fragmentSecondNomePais;
        nomePaisDado.setText(dadosCovidPais.getCountryText());


        if (!dadosCovidPais.getLastUpdate().equals("")){
            binding.fragmentSecondUltimaAtualizacaoDados.setText(dadosCovidPais.getLastUpdate());
        } else {
            binding.fragmentSecondUltimaAtualizacaoDados.setVisibility(View.GONE);
            binding.fragmentSecondUltimaAtualizacaoTexto.setVisibility(View.GONE);
        }

        if (!dadosCovidPais.getActiveCasesText().equals("")){
            binding.fragmentSecondCasosAtivosDados.setText(dadosCovidPais.getActiveCasesText());
        } else {
            binding.fragmentSecondCasosAtivosDados.setVisibility(View.GONE);
            binding.fragmentSecondCasosAtivosTexto.setVisibility(View.GONE);
        }

        if (!dadosCovidPais.getNewCasesText().equals("")){
            binding.fragmentSecondNovosCasosDados.setText(dadosCovidPais.getNewCasesText());
        } else {
            binding.fragmentSecondNovosCasosDados.setVisibility(View.GONE);
            binding.fragmentSecondNovosCasosTexto.setVisibility(View.GONE);
        }

        if (!dadosCovidPais.getNewDeathsText().equals("")){
            binding.fragmentSecondNovasMortesDados.setText(dadosCovidPais.getNewDeathsText());
        } else {
            binding.fragmentSecondNovasMortesDados.setVisibility(View.GONE);
            binding.fragmentSecondNovasMortesTexto.setVisibility(View.GONE);
        }

        if (!dadosCovidPais.getTotalCasesText().equals("")){
            binding.fragmentSecondTotalDeCasosDados.setText(dadosCovidPais.getTotalCasesText());
        } else {
            binding.fragmentSecondTotalDeCasosDados.setVisibility(View.GONE);
            binding.fragmentSecondTotalDeCasosTexto.setVisibility(View.GONE);
        }

        if (!dadosCovidPais.getTotalDeathsText().equals("")){
            binding.fragmentSecondTotalDeMortesDados.setText(dadosCovidPais.getTotalDeathsText());
        } else {
            binding.fragmentSecondTotalDeMortesDados.setVisibility(View.GONE);
            binding.fragmentSecondTotalDeMortesTexto.setVisibility(View.GONE);
        }

        if (!dadosCovidPais.getTotalRecoveredText().equals("")){
            binding.fragmentSecondTotalDeRecuperadosDados.setText(dadosCovidPais.getTotalRecoveredText());
        } else {
            binding.fragmentSecondTotalDeRecuperadosDados.setVisibility(View.GONE);
            binding.fragmentSecondTotalDeRecuperadosTexto.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}