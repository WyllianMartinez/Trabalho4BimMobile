package br.com.deputadosfocoapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.deputadosfocoapp.MenuDeputadoApp;
import br.com.deputadosfocoapp.R;
import br.com.deputadosfocoapp.model.Deputados;

public class DeputadosCardAdapter extends RecyclerView.Adapter<DeputadosCardAdapter.EscoltaViewHolder> {

    private List<Deputados> listaDeputados;
    private Context context;

    public DeputadosCardAdapter(List<Deputados> listaDeputados, Context context) {
        this.listaDeputados = listaDeputados;
        this.context = context;
    }

    @NonNull
    public EscoltaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_list_card_app, parent, false);
        return new EscoltaViewHolder(view);
    }

    public void onBindViewHolder(@NonNull EscoltaViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Deputados dados = listaDeputados.get(position);

        holder.cardGenerico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Deputados deputadosClicado = listaDeputados.get(position);
                    Intent intent = new Intent(context, MenuDeputadoApp.class);
                    intent.putExtra("id_deputado", deputadosClicado.getId());
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.e("Error", "" + e.getMessage());
                }
            }
        });

        // Convertendo int para String
        holder.txtDados1.setText(String.valueOf(dados.getIdLegislatura()));
        holder.txtDados3.setText(dados.getEmail());

    }

    public int getItemCount() {
        return listaDeputados.size();
    }

    public void atualizarLista(List<Deputados> novaLista) {
        listaDeputados.clear();
        listaDeputados.addAll(novaLista);
        notifyDataSetChanged();
    }

    public static class EscoltaViewHolder extends RecyclerView.ViewHolder {

        LinearLayout cardGenerico;
        TextView txtDados1;
        TextView txtDados3;
        TextView txtDados5;
        TextView txtDados7;


        public EscoltaViewHolder(@NonNull View itemView) {
            super(itemView);
            cardGenerico = itemView.findViewById(R.id.cardGenerico);
            txtDados1 = itemView.findViewById(R.id.txtDados1);
            txtDados3 = itemView.findViewById(R.id.txtDados3);
            txtDados5 = itemView.findViewById(R.id.txtDados5);
            txtDados7 = itemView.findViewById(R.id.txtDados7);

        }
    }
}
