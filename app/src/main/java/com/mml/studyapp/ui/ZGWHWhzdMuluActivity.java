package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;

import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.ZGWHBean;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * Created by MLing on 2018/5/23 0023. 文化制度全景
 */

public class ZGWHWhzdMuluActivity extends BaseCompatActivity implements View.OnClickListener {
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
        return R.layout.activity_zgwh_mulu;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_return).setOnClickListener(this);
        view.findViewById(R.id.tv_gdzdygz).setOnClickListener(this);
        view.findViewById(R.id.tv_gdjyykj).setOnClickListener(this);
        view.findViewById(R.id.tv_gdxmhcw).setOnClickListener(this);
        view.findViewById(R.id.tv_gdtwhlf).setOnClickListener(this);
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
            case R.id.tv_gdzdygz:
                Intent intent1 = new Intent(this, ZGWHInfoActivity.class);
                intent1.putExtra("muluinfo", detail.get(0));
                intent1.putExtra("mulu", detail.get(0).getName());
                ActivityAnim.intentActivity(this, intent1);
                break;
            case R.id.tv_gdjyykj:
                Intent intent2 = new Intent(this, ZGWHInfoActivity.class);
                intent2.putExtra("muluinfo", detail.get(1));
                intent2.putExtra("mulu", detail.get(1).getName());
                ActivityAnim.intentActivity(this, intent2);
                break;
            case R.id.tv_gdxmhcw:
                Intent intent3 = new Intent(this, ZGWHInfoActivity.class);
                intent3.putExtra("muluinfo", detail.get(2));
                intent3.putExtra("mulu", detail.get(2).getName());
                ActivityAnim.intentActivity(this, intent3);
                break;
            case R.id.tv_gdtwhlf:
                Intent intent4 = new Intent(this, ZGWHInfoActivity.class);
                intent4.putExtra("muluinfo", detail.get(3));
                intent4.putExtra("mulu", detail.get(3).getName());
                ActivityAnim.intentActivity(this, intent4);
                break;
        }
    }
}
