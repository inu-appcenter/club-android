package org.inuappcenter.inuclub.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.inuappcenter.inuclub.Homes.CateClubList;
import org.inuappcenter.inuclub.R;

import java.util.ArrayList;

public class RecyclerViewAdapterC extends RecyclerView.Adapter<RecyclerViewAdapterC.ViewHolder> {

    ArrayList<CateItemData> list;
    Context context;

    public RecyclerViewAdapterC(ArrayList<CateItemData>list){
        this.list=list;
    }

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
        final CateItemData cateItem = list.get(position);
        String stringcount = String.valueOf(cateItem.getCount());

        holder.name.setText(cateItem.getName());
        holder.count.setText(stringcount);
        holder.image.setImageResource(cateItem.getImageNum());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                context = view.getContext();
                Intent intent = new Intent(context, CateClubList.class);
                intent.putExtra("카테고리",cateItem.getName());
                intent.putExtra("동아리 개수",cateItem.getCount());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
