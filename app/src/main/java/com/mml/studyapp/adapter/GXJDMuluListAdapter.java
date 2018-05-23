package com.mml.studyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.mml.studyapp.R;
import com.mml.studyapp.base.MyBaseAdapter;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.bean.TSSCBean;
import com.mml.studyapp.utils.common.ConstmOnItemOnclickListener;

import java.util.List;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/20 21:45
 */

public class GXJDMuluListAdapter extends MyBaseAdapter {
    private List<GXJDBean.QmdwBean.DetailBean> mList;
    private Context mContext;
    private ViewHolder holder;
    private GXJDMuluAdapter mAdapter;
    private ConstmOnItemOnclickListener mConstmOnItemOnclickListener;

    public GXJDMuluListAdapter(List data, Context context) {
        super(data, context);
        this.mList = data;
        this.mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.xml_item_tssc_mulu_list_g, null);
            holder = new ViewHolder();
            holder.grid_view = (GridView) convertView.findViewById(R.id.grid_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        mAdapter = new GXJDMuluAdapter(mList.get(position).getKkk(), mContext);
        holder.grid_view.setAdapter(mAdapter);
        holder.grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionChild, long id) {
                mConstmOnItemOnclickListener.clickItem(holder.grid_view, position, positionChild, 1, "");
            }
        });
        return convertView;
    }

    static class ViewHolder {
        GridView grid_view;
    }

    public void setOnGridviewItemClickListener(ConstmOnItemOnclickListener constmOnItemOnclickListener) {
        this.mConstmOnItemOnclickListener = constmOnItemOnclickListener;
    }

}
