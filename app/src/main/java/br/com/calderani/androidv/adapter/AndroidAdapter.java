package br.com.calderani.androidv.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.calderani.androidv.R;
import br.com.calderani.androidv.model.Android;

/**
 * Created by logonrm on 21/06/2017.
 */

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {
    private List<Android> androidList;

    public AndroidAdapter(List<Android> l){
        androidList = l;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View androidView = inflater.inflate(R.layout.android_row, parent, false);

        return new AndroidViewHolder(androidView);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        Android a = androidList.get(position);
        holder.tvTitulo.setText(a.getNome());
        holder.tvTitulo.setText(a.getVersao() + " - " + a.getApi());
        Picasso.with(holder.itemView.getContext())
                .load(a.getUrlImagem())
                .placeholder(R.drawable.ic_loading)  // IMG de Loading
                .error(R.mipmap.ic_launcher)        // IMG de Erro
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivLogo;
        public TextView tvTitulo;
        public TextView tvDescricao;

        public AndroidViewHolder(View itemView) {
            super(itemView);
            ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricao);
        }
    }

    public void update(List<Android> l){
        androidList = l;
        notifyDataSetChanged();
    }
}
