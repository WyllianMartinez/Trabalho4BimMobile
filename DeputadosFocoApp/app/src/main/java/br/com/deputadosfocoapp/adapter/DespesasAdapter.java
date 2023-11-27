package br.com.deputadosfocoapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import br.com.deputadosfocoapp.R;
import br.com.deputadosfocoapp.model.Deputados;
import br.com.deputadosfocoapp.model.Despesas;
import br.com.deputadosfocoapp.ui.MenuDeputadoApp;

public class DespesasAdapter extends RecyclerView.Adapter<DespesasAdapter.DespesasAdapterViewHolder> {

    private List<Despesas> listaDespesas;
    private Context context;

    public DespesasAdapter(List<Despesas> listaDespesas, Context context) {
        this.listaDespesas = listaDespesas;
        this.context = context;
    }

    @NonNull
    public DespesasAdapter.DespesasAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_despesas, parent, false);
        return new DespesasAdapter.DespesasAdapterViewHolder(view);
    }

    public void onBindViewHolder(@NonNull DespesasAdapter.DespesasAdapterViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Despesas dados = listaDespesas.get(position);

        holder.tvFornecedor.setText(dados.getNomeFornecedor());
        holder.tvAnoMes.setText(dados.getMes() + " - " + dados.getAno());
        holder.tvValor.setText("R$ " + String.valueOf(dados.getValorLiquido()));
        holder.tvTipoDocumento.setText(dados.getTipoDocumento());
        holder.tvTipoDespesa.setText(dados.getTipoDespesa());

    }

    public int getItemCount() {
        return listaDespesas.size();
    }

    public static class DespesasAdapterViewHolder extends RecyclerView.ViewHolder {

        LinearLayout cardDespesas;
        TextView tvTipoDespesa, tvAnoMes, tvFornecedor, tvValor, tvTipoDocumento;

        public DespesasAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            cardDespesas = itemView.findViewById(R.id.cardDespesas);
            tvTipoDespesa = itemView.findViewById(R.id.tvTipoDespesa);
            tvAnoMes = itemView.findViewById(R.id.tvAnoMes);
            tvFornecedor = itemView.findViewById(R.id.tvFornecedor);
            tvValor = itemView.findViewById(R.id.tvValor);
            tvTipoDocumento = itemView.findViewById(R.id.tvTipoDocumento);

        }
    }
}