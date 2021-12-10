package com.eveliinaheino.peippo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Luokka sisältää adapterin, jolla ListView saa tarvitsemansa tiedot.
 * @author Katja
 */

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<TipTitle> titles;

    public CustomBaseAdapter(Context context, List<TipTitle> titles){
        this.context = context;
        this.titles = titles;
    }

    /* holder for things in listview layout */
    private class ViewHolder {
        TextView title;
        TextView description;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater infl = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = infl.inflate(R.layout.layout_tip_list, null);
            holder = new ViewHolder();

            holder.title = (TextView) convertView.findViewById(R.id.tipTitle);
            holder.description = (TextView) convertView.findViewById((R.id.tipDescription));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TipTitle tipTitle = (TipTitle) getItem(position);

        holder.title.setText(tipTitle.getName());
        holder.description.setText(tipTitle.getDescription());

        return convertView;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return titles.indexOf(titles.get(position));
    }
}
