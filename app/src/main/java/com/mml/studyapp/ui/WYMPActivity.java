package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;

import com.loopj.android.http.RequestParams;
import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.WYMPBean;
import com.mml.studyapp.iactivityview.WYMPActivityView;
import com.mml.studyapp.presenter.WYMPActivityPresenter;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:23
 */

public class WYMPActivity extends BaseCompatActivity implements View.OnClickListener, WYMPActivityView {
    private WYMPActivityPresenter mWYMPActivityPresenter;
    private ArrayList<WYMPBean.GwrmBean> gwrm;
    private ArrayList<WYMPBean.GwrmBean> bpbb;
    private ArrayList<WYMPBean.GwrmBean> kzts;
    private ArrayList<WYMPBean.GwrmBean> nlxl;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        mWYMPActivityPresenter = new WYMPActivityPresenter(this);
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
        mWYMPActivityPresenter.getWYMPJsonString(this, "wymp.json");
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
            case R.id.tv_gwrm:
                Intent intentGWRM = new Intent(this, WYMPMuluActivity.class);
                intentGWRM.putParcelableArrayListExtra("list",gwrm);
                ActivityAnim.intentActivity(this, intentGWRM);
                break;
            case R.id.tv_bpbb:
                Intent intentBPBB = new Intent(this, WYMPMuluActivity.class);
                intentBPBB.putParcelableArrayListExtra("list",bpbb);
                ActivityAnim.intentActivity(this, intentBPBB);
                break;
            case R.id.tv_gzts:
                Intent intentGZTS = new Intent(this, WYMPMuluActivity.class);
                intentGZTS.putParcelableArrayListExtra("list",kzts);
                ActivityAnim.intentActivity(this, intentGZTS);
                break;
            case R.id.tv_nlxl:
                Intent intentNLXL = new Intent(this, WYMPMuluActivity.class);
                intentNLXL.putParcelableArrayListExtra("list",nlxl);
                ActivityAnim.intentActivity(this, intentNLXL);
                break;
        }
    }

    @Override
    public void excuteSuccessCallBack(WYMPBean mCallBackVo) {
        if (mCallBackVo != null) {
            if (mCallBackVo.getBpbb() != null && mCallBackVo.getBpbb().size() > 0) {
                bpbb = mCallBackVo.getBpbb();
            }
            if (mCallBackVo.getBpbb() != null && mCallBackVo.getBpbb().size() > 0) {
                gwrm = mCallBackVo.getGwrm();
            }
            if (mCallBackVo.getBpbb() != null && mCallBackVo.getBpbb().size() > 0) {
                kzts = mCallBackVo.getKzts();
            }
            if (mCallBackVo.getBpbb() != null && mCallBackVo.getBpbb().size() > 0) {
                nlxl = mCallBackVo.getNlxl();
            }
        }
    }

    @Override
    public RequestParams getParamenters() {
        return null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void excuteFailedCallBack(CallBackVo mCallBackVo) {

    }
}
