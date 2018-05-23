package com.mml.studyapp.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;

import com.mml.studyapp.R;
import com.mml.studyapp.adapter.GXJDMuluListAdapter;
import com.mml.studyapp.adapter.WYMPMuluListAdapter;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.utils.common.ConstmOnItemOnclickListener;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * Created by MLing on 2018/5/10 0010.
 */

public class GXJDMuluActivity extends BaseCompatActivity implements View.OnClickListener {
    private ListView recycler_view;
    private ArrayList<GXJDBean.QmdwBean.DetailBean> muluinfo;
    private GXJDMuluListAdapter mAdapter;

    /**
     * @param titleBar 设置标题栏
     */
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    /**
     * @return 设置页面布局
     */
    @Override
    protected int onCreateViewId() {
        return R.layout.activity_mulu_gxjd;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        recycler_view = (ListView) view.findViewById(R.id.recycler_view);
        view.findViewById(R.id.tv_return).setOnClickListener(this);
    }

    /**
     * 本地传参
     */
    @Override
    protected void getExras() {
        muluinfo = getIntent().getParcelableArrayListExtra("muluinfo");
    }

    /**
     * 监听事件
     */
    @Override
    protected void setListener() {
        if (muluinfo != null) {
            mAdapter = new GXJDMuluListAdapter(muluinfo, this);
            recycler_view.setAdapter(mAdapter);
            mAdapter.setOnGridviewItemClickListener(new ConstmOnItemOnclickListener() {
                @Override
                public void clickItem(View view, int position, int positionChild, int ClickType, String content) {
                    Intent intent = new Intent(GXJDMuluActivity.this, GXJDInfoActivity.class);
                    intent.putExtra("gxjdinfo", muluinfo.get(position).getKkk().get(positionChild));
                    ActivityAnim.intentActivity(GXJDMuluActivity.this, intent);
                }
            });
        }
    }

    /**
     * 获取数据方法，之后，View赋值
     */
    @Override
    protected void fromNetGetData() {

    }

    /**
     * 获取数据方法，之后，View赋值
     */
    @Override
    protected void fromNotMsgReference() {

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_return:
                ActivityAnim.endActivity(this);
                break;
        }
    }
}
