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

import org.inuappcenter.inuclub.Homes.ClubDetail;
import org.inuappcenter.inuclub.R;

import java.util.ArrayList;

public class RecyclerViewAdapterL extends RecyclerView.Adapter<RecyclerViewAdapterL.viewHolder> {
    ArrayList<ClubListItemData>list;
    Context context;
    public RecyclerViewAdapterL(ArrayList<ClubListItemData>list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerViewAdapterL.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cate_club_list_item,parent,false);
        RecyclerViewAdapterL.viewHolder viewHolder = new viewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterL.viewHolder holder, int position) {
        final ClubListItemData clubListItem = list.get(position);

        holder.clubName.setText(clubListItem.getClubName());
        holder.clubPlace.setText(clubListItem.getClubPlace());
        holder.clubImage.setImageResource(clubListItem.getClubImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 해당 동아리 소개페이지
                Intent intent = new Intent(context, ClubDetail.class);
                intent.putExtra("동아리이름",clubListItem.getClubName());
                intent.putExtra("동아리방",clubListItem.getClubPlace());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public TextView clubName;
        public TextView clubPlace;
        public ImageView clubImage;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            this.clubName = itemView.findViewById(R.id.cate_club_name);
            this.clubPlace = itemView.findViewById(R.id.cate_club_place);
            this.clubImage = itemView.findViewById(R.id.cate_club_image);
        }
    }
}
