package com.jhyejin99.inuclub.Settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jhyejin99.inuclub.R;

import java.util.ArrayList;

public class SettingListAdapter extends BaseAdapter {

    private ArrayList<SettingItem> settingItems = new ArrayList<SettingItem>();

    public SettingListAdapter() {

    }

    @Override
    public int getCount() {
        return settingItems.size();
    }

    @Override
    public Object getItem(int position) {
        return settingItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Context context = parent.getContext();

        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.setting_item,parent,false);
        }

        final TextView settingListName = (TextView) convertView.findViewById(R.id.setting_list_item);

        SettingItem settingItem = settingItems.get(position);

        settingListName.setText(settingItem.getName());

        //convertView.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View v) {
          //      settingListName.setTextColor(ContextCompat.getColor(context,R.color.lightSalmon));
          //      settingListName.setTextSize(22);
          //      settingListName.setTypeface(null, Typeface.BOLD);
          //  }
        //});



        return convertView;
    }

    public void addItem(String name) {
        SettingItem settingItem = new SettingItem();
        settingItem.setName(name);
        settingItems.add(settingItem);
    }
}
