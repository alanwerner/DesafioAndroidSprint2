package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCountryCovidDataListUseCase;
import com.example.recyclerview.data.GetCovidDataListFromJson;

import java.util.List;

public class ListaPaisesAdapter extends RecyclerView.Adapter<ListaPaisesAdapter.ViewHolder> {

    final private List<CountryCovidData> paises;
    final private Context context;

    public ListaPaisesAdapter(List<CountryCovidData> paises, Context context) {
        this.paises = paises;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pais, parent, false);
        return new ViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPaisesAdapter.ViewHolder holder, int position) {

        CountryCovidData countryCovidData = paises.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView item_pais_NomePais;
        private final TextView fragment_second_UltimaAtualizacao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_pais_NomePais = itemView.findViewById(R.id.item_pais_NomePais);
            fragment_second_UltimaAtualizacao = itemView.findViewById(R.id.fragment_second_UltimaAtualizacao);
        }

        public void vincula (CountryCovidData pais){
            preencheCampos(pais);
        }

        private void preencheCampos(CountryCovidData pais) {
            item_pais_NomePais.setText(pais.getCountryText());
            fragment_second_UltimaAtualizacao.setText(pais.getLastUpdateText());
        }

    }
}
