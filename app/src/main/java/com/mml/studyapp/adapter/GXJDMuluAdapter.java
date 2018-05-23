package com.mml.studyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mml.studyapp.R;
import com.mml.studyapp.base.MyBaseAdapter;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.bean.TSSCBean;

import java.util.List;

/**
 * Created by MLing on 2018/5/10 0010.
 */

public class GXJDMuluAdapter extends MyBaseAdapter {
    private List<GXJDBean.QmdwBean.DetailBean.KkkBean> mList;
    private Context mContext;
    private ViewHolder holder;

    public GXJDMuluAdapter(List data, Context context) {
        super(data, context);
        this.mList = data;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.xml_item_tssc_mulu_list, null);
            holder = new ViewHolder();
            holder.tv_mulu_name = (TextView) convertView.findViewById(R.id.tv_mulu_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_mulu_name.setText(mList.get(position).getId() + mList.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        TextView tv_mulu_name;
    }
}
