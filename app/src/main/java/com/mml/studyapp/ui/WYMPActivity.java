package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;

import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:23
 */

public class WYMPActivity extends BaseCompatActivity implements View.OnClickListener{
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_wymp;
    }

    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_return).setOnClickListener(this);
        view.findViewById(R.id.tv_gwrm).setOnClickListener(this);
        view.findViewById(R.id.tv_bpbb).setOnClickListener(this);
        view.findViewById(R.id.tv_gzts).setOnClickListener(this);
        view.findViewById(R.id.tv_nlxl).setOnClickListener(this);
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void fromNetGetData() {

    }

    @Override
    protected void fromNotMsgReference() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_return:
                ActivityAnim.endActivity(this);
                break;
            case R.id.tv_gwrm:
                Intent intentGWRM=new Intent(this,WYMPMuluActivity.class);
                ActivityAnim.intentActivity(this,intentGWRM);
                break;
            case R.id.tv_bpbb:
                Intent intentBPBB=new Intent(this,WYMPMuluActivity.class);
                ActivityAnim.intentActivity(this,intentBPBB);
                break;
            case R.id.tv_gzts:
                Intent intentGZTS=new Intent(this,WYMPMuluActivity.class);
                ActivityAnim.intentActivity(this,intentGZTS);
                break;
            case R.id.tv_nlxl:
                Intent intentNLXL=new Intent(this,WYMPMuluActivity.class);
                ActivityAnim.intentActivity(this,intentNLXL);
                break;
        }
    }
}
