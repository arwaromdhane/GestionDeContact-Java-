package com.example.gestiondecontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    public MonAdapter(Context c, ArrayList<Contact> data) {
        this.c = c;
        this.data = data;
    }

    Context c;
 ArrayList <Contact> data = new ArrayList<Contact>();

    @Override
    public int getCount() {
        return  data.size();
    } //nombre des éléments

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {  //on va parser un code xml en java
         LayoutInflater inf =LayoutInflater.from(c);                                   //layoutinflatter objet pour parse
          LinearLayout l = (LinearLayout)inf.inflate(R.layout.layout , null);
          TextView tv1 = l.findViewById(R.id.tv1);                                   // TextView tv = new TextView(c)
           TextView tv2 = l.findViewById(R.id.tv2);                                      // tv.setText(data.get(position).toString());
        TextView tv3 = l.findViewById(R.id.tv3);                          // récuperation des textview
        tv1.setText(data.get(position).nom);
        tv2.setText(data.get(position).);
        tv3.setText(data.get(position).);
        return l;
    }
}
