package com.example.net;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.vholder> {
    ArrayList<Product> ls;
    public Adapter(ArrayList<Product> ls)
    {
        this.ls=ls;
    }

    @NonNull
    @Override
    public vholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        Log.e("okok:","create chua loi");
        return new vholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull vholder holder, int position) {
        Product pr= ls.get(position);
        holder.tvID.setText("ID: "+String.valueOf(pr.getId()));
        holder.tvName.setText("Name: "+String.valueOf(pr.getName()));
        holder.tvDes.setText("Mo ta: "+String.valueOf(pr.getDescription()));
        holder.btnMake.setText("San xuat: "+String.valueOf(pr.getMake()));
        Picasso.get()
                .load(pr.getImage())
                .resize(200, 200)// resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(holder.img);

    }
    @Override
    public int getItemCount() {
        return ls.size();
    }

    class vholder extends RecyclerView.ViewHolder
    {
        TextView tvID,tvName,tvDes;
        ImageView img;
        Button btnMake;
        public vholder(View view)
        {
            super(view);
            tvID=view.findViewById(R.id.tv_id);
            tvName=view.findViewById(R.id.tv_name);
            tvDes=view.findViewById(R.id.tv_des);
            btnMake=view.findViewById(R.id.btn_make);
            img=view.findViewById(R.id.img);
        }
    }
}
