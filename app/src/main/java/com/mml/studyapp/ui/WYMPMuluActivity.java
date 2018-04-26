package com.mml.studyapp.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;

import com.mml.studyapp.R;
import com.mml.studyapp.adapter.WYMPMuluListAdapter;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.WYMPBean;
import com.mml.studyapp.utils.common.ConstmOnItemOnclickListener;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:23
 */

public class WYMPMuluActivity extends BaseCompatActivity implements View.OnClickListener {
    private ListView recycler_view;
    private ArrayList<WYMPBean.GwrmBean> list;
    private WYMPMuluListAdapter mAdapter;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_wymp_mulu;
    }

    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_return).setOnClickListener(this);
        recycler_view = (ListView) view.findViewById(R.id.recycler_view);
    }

    @Override
    protected void getExras() {
        list = getIntent().getParcelableArrayListExtra("list");
    }

    @Override
    protected void setListener() {
        if (list != null) {
            mAdapter = new WYMPMuluListAdapter(list, this);
            recycler_view.setAdapter(mAdapter);
            mAdapter.setOnGridviewItemClickListener(new ConstmOnItemOnclickListener() {
                @Override
                public void clickItem(View view, int position, int positionChild, int ClickType, String content) {
                    Intent intent = new Intent(WYMPMuluActivity.this, WYMPInfoActivity.class);
                    intent.putExtra("tsscdate", list.get(position).getKkk().get(positionChild));
                    ActivityAnim.intentActivity(WYMPMuluActivity.this, intent);
                }
            });
        }
    }

    @Override
    protected void fromNetGetData() {

    }

    @Override
    protected void fromNotMsgReference() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_return:
                ActivityAnim.endActivity(this);
                break;
        }
    }
}
