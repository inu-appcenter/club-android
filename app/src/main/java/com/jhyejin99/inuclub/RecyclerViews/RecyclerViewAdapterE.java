package com.jhyejin99.inuclub.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jhyejin99.inuclub.R;
import com.jhyejin99.inuclub.Settings.Events.SettingEventDetail;
import com.jhyejin99.inuclub.Settings.SettingEvent;

import java.util.ArrayList;

public class RecyclerViewAdapterE extends RecyclerView.Adapter<RecyclerViewAdapterE.ViewHolder> {
    ArrayList<EventItemData> list;
    Context context;

    public RecyclerViewAdapterE(ArrayList<EventItemData>list){
        this.list=list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView club;
        public TextView eventName;
        public TextView content;
        public TextView day;
        public TextView hour;
        public TextView place;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.club = itemView.findViewById(R.id.home_event_club);
            this.eventName = itemView.findViewById(R.id.home_event_name);
            this.content = itemView.findViewById(R.id.home_event_content);
            this.day = itemView.findViewById(R.id.home_event_day);
            this.hour = itemView.findViewById(R.id.home_event_hour);
            this.place = itemView.findViewById(R.id.home_event_place);
        }
    }
    @NonNull
    @Override
    public RecyclerViewAdapterE.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_event,parent,false);
        RecyclerViewAdapterE.ViewHolder viewHolder = new ViewHolder(view);
        context = view.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterE.ViewHolder holder, int position) {
        final EventItemData eventItem = list.get(position);
        String stringday = String.valueOf(eventItem.getDay());
        String stringhour = String.valueOf(eventItem.getHour());
        holder.club.setText(eventItem.getClub());
        holder.eventName.setText(eventItem.getEventName());
        holder.content.setText(eventItem.getContent());
        holder.day.setText(stringday);
        holder.hour.setText(stringhour);
        holder.place.setText(eventItem.getPlace());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 누른 행사에 대한 행사 상세페이지로 넘어가게
                Intent intent = new Intent(context, SettingEventDetail.class);
                intent.putExtra("제목",eventItem.getEventName());
                intent.putExtra("설명",eventItem.getContent());
                intent.putExtra("장소",eventItem.getPlace());
                intent.putExtra("시작날짜",eventItem.getDay());
                intent.putExtra("시작시간",eventItem.getHour());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
