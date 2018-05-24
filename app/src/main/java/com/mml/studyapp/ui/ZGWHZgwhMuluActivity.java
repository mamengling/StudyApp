package com.mml.studyapp.ui;

import android.view.View;

import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.ZGWHBean;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * Created by MLing on 2018/5/23 0023. 中国文化全景
 */

public class ZGWHZgwhMuluActivity extends BaseCompatActivity implements View.OnClickListener {
    private ArrayList<ZGWHBean.WhzdBean.DetailBean> detail;
    private String name;
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
        return R.layout.activity_zgwh_mulu_zgwh;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_return).setOnClickListener(this);
        view.findViewById(R.id.tv_dyz).setOnClickListener(this);
        view.findViewById(R.id.tv_dez).setOnClickListener(this);
        view.findViewById(R.id.tv_dsz).setOnClickListener(this);
        view.findViewById(R.id.tv_dszt).setOnClickListener(this);
        view.findViewById(R.id.tv_dwz).setOnClickListener(this);
        view.findViewById(R.id.tv_dlz).setOnClickListener(this);
        view.findViewById(R.id.tv_dqz).setOnClickListener(this);
        view.findViewById(R.id.tv_dbz).setOnClickListener(this);
    }

    /**
     * 本地传参
     */
    @Override
    protected void getExras() {
        detail = getIntent().getParcelableArrayListExtra("muluinfo");
        name = getIntent().getStringExtra("mulu");
    }

    /**
     * 监听事件
     */
    @Override
    protected void setListener() {

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_return:
                ActivityAnim.endActivity(this);
                break;
            case R.id.tv_dyz:
                break;
            case R.id.tv_dez:
                break;
            case R.id.tv_dsz:
                break;
            case R.id.tv_dszt:
                break;
            case R.id.tv_dwz:
                break;
            case R.id.tv_dlz:
                break;
            case R.id.tv_dqz:
                break;
            case R.id.tv_dbz:
                break;
        }
    }
}
