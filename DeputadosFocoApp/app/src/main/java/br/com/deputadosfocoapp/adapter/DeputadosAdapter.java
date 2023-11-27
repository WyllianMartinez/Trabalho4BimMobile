package br.com.deputadosfocoapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import br.com.deputadosfocoapp.ui.MenuGastosApp;

public class DeputadosAdapter extends RecyclerView.Adapter<DeputadosAdapter.DeputadosViewHolder> {

    private List<Deputados> listaDeputados;
    private Context context;

    public DeputadosAdapter(List<Deputados> listaDeputados, Context context) {
        this.listaDeputados = listaDeputados;
        this.context = context;
    }

    @NonNull
    public DeputadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_deputados, parent, false);
        return new DeputadosViewHolder(view);
    }

    public void onBindViewHolder(@NonNull DeputadosViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Deputados dados = listaDeputados.get(position);

        Glide.with(context)
                .load(dados.getUrlFoto())
                .apply(new RequestOptions().placeholder(R.drawable.semfoto))
                .into(holder.imgDeputado);

        holder.tvNome.setText(dados.getNome());
        holder.tvEstado.setText(dados.getSiglaUf());
        holder.tvEmail.setText(dados.getEmail());
        holder.tvIdLegislatura.setText(dados.getIdLegislatura());
        holder.tvPartido.setText(dados.getSiglaPartido());

        holder.cardGenerico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(context, MenuGastosApp.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id_deputado", Integer.valueOf(dados.getId()));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.e("Error", "" + e.getMessage());
                }
            }
        });

    }

    public int getItemCount() {
        return listaDeputados.size();
    }

    public void atualizarLista(List<Deputados> novaLista) {
        listaDeputados.clear();
        listaDeputados.addAll(novaLista);
        notifyDataSetChanged();
    }

    public static class DeputadosViewHolder extends RecyclerView.ViewHolder {

        LinearLayout cardGenerico;
        TextView tvNome;
        TextView tvEmail;
        TextView tvIdLegislatura;
        TextView tvEstado;
        TextView tvPartido;

        ImageView imgDeputado;
        public DeputadosViewHolder(@NonNull View itemView) {
            super(itemView);
            cardGenerico = itemView.findViewById(R.id.cardGenerico);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvIdLegislatura = itemView.findViewById(R.id.tvIdLegislatura);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            tvPartido = itemView.findViewById(R.id.tvPartido);
            imgDeputado = itemView.findViewById(R.id.imgPessoa);

        }
    }
}
