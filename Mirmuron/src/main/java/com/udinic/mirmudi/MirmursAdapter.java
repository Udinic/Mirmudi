package com.udinic.mirmudi;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Udini on 9/20/13.
 */
public class MirmursAdapter extends BaseAdapter {
    ArrayList<Mirmur> mMirmurs = new ArrayList<Mirmur>();

    private Context mContext;

    public MirmursAdapter(Context c) {
        mContext = c;

        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur1), R.raw.come_on));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur2), R.raw.for_how_many_users));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur3), R.raw.good_ios_design));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur4), R.raw.happend_eventually));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur5), R.raw.in_android_hate));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur6), R.raw.more_devices));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur7), R.raw.never_work));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur8), R.raw.not_gonna_happen));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur9), R.raw.permission));
        mMirmurs.add(new Mirmur(mContext.getString(R.string.mirmur10), R.raw.uninstall));
    }

    public int getCount() {
        return mMirmurs.size();
    }

    public Object getItem(int position) {
        return mMirmurs.get(position);
    }

    public long getItemId(int position) {
        return mMirmurs.get(position).sound;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            textView = (TextView)inflater.inflate(R.layout.item_grid, parent, false);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText((mMirmurs.get(position)).name);
        return textView;
    }

    public static class Mirmur {
        public String name;
        public int sound;

        public Mirmur(String name, int sound) {
            this.name = name;
            this.sound = sound;
        }
    }
}
