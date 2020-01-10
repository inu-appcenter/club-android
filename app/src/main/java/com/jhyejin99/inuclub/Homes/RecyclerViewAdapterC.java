package com.jhyejin99.inuclub.Homes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jhyejin99.inuclub.R;

public class RecyclerViewAdapterC extends RecyclerView.Adapter<RecyclerViewAdapterC.ViewHolder> {

    String[] namelist = {"스포츠","종교","문화","봉사","취미/전시","교양/학술"};
    int[] imagelist = {R.drawable.soccer2x,R.drawable.pray2x,R.drawable.party2x,R.drawable.love2x,R.drawable.card2x,R.drawable.soccer2x};
    int[] countlist = {10,2,3,4,15,6};

    public class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView name;
        public TextView count;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.cate_name);
            this.count = view.findViewById(R.id.cate_count);
            this.image = view.findViewById(R.id.cate_image);
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapterC.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cate,parent,false);
        RecyclerViewAdapterC.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String countString = String.valueOf(countlist[position]);

        holder.name.setText(namelist[position]);
        holder.count.setText(countString);
        holder.image.setImageResource(imagelist[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return namelist.length;
    }
}
