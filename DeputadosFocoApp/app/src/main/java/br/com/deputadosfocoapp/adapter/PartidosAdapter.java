package br.com.deputadosfocoapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.deputadosfocoapp.R;
import br.com.deputadosfocoapp.model.Despesas;
import br.com.deputadosfocoapp.model.Partidos;

public class PartidosAdapter extends RecyclerView.Adapter<PartidosAdapter.PartidosAdapterViewHolder> {

    private List<Partidos> listaPartidos;
    private Context context;

    public PartidosAdapter(List<Partidos> listaPartidos, Context context) {
        this.listaPartidos = listaPartidos;
        this.context = context;
    }

    @NonNull
    public PartidosAdapter.PartidosAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_partidos, parent, false);
        return new PartidosAdapter.PartidosAdapterViewHolder(view);
    }

    public void onBindViewHolder(@NonNull PartidosAdapter.PartidosAdapterViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Partidos dados = listaPartidos.get(position);

        holder.tvNome.setText(dados.getNome());
        holder.tvSigla.setText(dados.getSigla());
        holder.TvIdPartido.setText(String.valueOf(dados.getId()));

    }

    public int getItemCount() {
        return listaPartidos.size();
    }

    public static class PartidosAdapterViewHolder extends RecyclerView.ViewHolder {

        LinearLayout cardPartidos;
        TextView tvNome, tvSigla, TvIdPartido;

        public PartidosAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            cardPartidos = itemView.findViewById(R.id.cardPartidos);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvSigla = itemView.findViewById(R.id.tvSigla);
            TvIdPartido = itemView.findViewById(R.id.TvIdPartido);

        }
    }
}