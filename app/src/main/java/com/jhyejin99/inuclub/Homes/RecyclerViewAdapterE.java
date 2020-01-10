package com.jhyejin99.inuclub.Homes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jhyejin99.inuclub.R;

public class RecyclerViewAdapterE extends RecyclerView.Adapter<RecyclerViewAdapterE.ViewHolder> {

    String[] clublist = {"사우라비","검도부","사우라비","검도부"};
    String[] eventNamelist = {"사우라비행사","검도부행사","사우라비행사","검도부행사"};
    String[] contentlist = {"행사내용","행사내용","행사내용","행사내용"};
    int[] dateList = {11,31,5,2};
    int[] timelist = {22,10,15,8};
    String[] placelist = {"정보대","정보대","정보대","정보대"};

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView club;
        public TextView eventName;
        public TextView content;
        public TextView date;
        public TextView time;
        public TextView place;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.club = itemView.findViewById(R.id.home_event_club);
            this.eventName = itemView.findViewById(R.id.home_event_name);
            this.content = itemView.findViewById(R.id.home_event_content);
            this.date = itemView.findViewById(R.id.home_event_date);
            this.time = itemView.findViewById(R.id.home_event_time);
            this.place = itemView.findViewById(R.id.home_event_place);
        }
    }
    @NonNull
    @Override
    public RecyclerViewAdapterE.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_event,parent,false);
        RecyclerViewAdapterE.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterE.ViewHolder holder, int position) {
        String stringdate = String.valueOf(dateList[position]);
        String stringtime = String.valueOf(timelist[position]);
        holder.club.setText(clublist[position]);
        holder.eventName.setText(eventNamelist[position]);
        holder.content.setText(contentlist[position]);
        holder.date.setText(stringdate);
        holder.time.setText(stringtime);
        holder.place.setText(placelist[position]);
    }

    @Override
    public int getItemCount() {
        return clublist.length;
    }


}
