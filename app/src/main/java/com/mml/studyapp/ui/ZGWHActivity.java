package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;

import com.loopj.android.http.RequestParams;
import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.ZGWHBean;
import com.mml.studyapp.iactivityview.ZGWHActivityView;
import com.mml.studyapp.presenter.ZGWHActivityPresenter;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:24
 */

public class ZGWHActivity extends BaseCompatActivity implements View.OnClickListener, ZGWHActivityView {
    private ZGWHActivityPresenter mZGWHActivityPresenter;
    private ArrayList<ZGWHBean.WhzdBean> mList;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        mZGWHActivityPresenter = new ZGWHActivityPresenter(this);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_zgwh;
    }

    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_whzdqj).setOnClickListener(this);
        view.findViewById(R.id.tv_zgwhqj).setOnClickListener(this);
        view.findViewById(R.id.tv_rcshqj).setOnClickListener(this);
        view.findViewById(R.id.tv_zglsqj).setOnClickListener(this);
        view.findViewById(R.id.tv_return).setOnClickListener(this);
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void fromNetGetData() {
        mZGWHActivityPresenter.getZHWHJsonString(this, "zgwh.json");
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
            case R.id.tv_whzdqj://文化制度全景
                Intent intent1 = new Intent(this, ZGWHWhzdMuluActivity.class);
                intent1.putParcelableArrayListExtra("muluinfo", mList.get(0).getDetail());
                intent1.putExtra("mulu", mList.get(0).getMulu());
                ActivityAnim.intentActivity(this, intent1);
                break;
            case R.id.tv_zgwhqj://中国文化全景
                Intent intent2 = new Intent(this, ZGWHZgwhMuluActivity.class);
                intent2.putParcelableArrayListExtra("muluinfo", mList.get(1).getDetail());
                intent2.putExtra("mulu", mList.get(1).getMulu());
                ActivityAnim.intentActivity(this, intent2);
                break;
            case R.id.tv_rcshqj://日常生活全景
                Intent intent3 = new Intent(this, ZGWHRcshMuluActivity.class);
                intent3.putParcelableArrayListExtra("muluinfo", mList.get(2).getDetail());
                intent3.putExtra("mulu", mList.get(2).getMulu());
                ActivityAnim.intentActivity(this, intent3);
                break;
            case R.id.tv_zglsqj://中国历史全景
                Intent intent4 = new Intent(this, ZGWHInfoActivity.class);
                intent4.putExtra("muluinfo", mList.get(3).getDetail().get(0));
                intent4.putExtra("mulu", mList.get(3).getMulu());
                ActivityAnim.intentActivity(this, intent4);
                break;
        }
    }

    /**
     * 获取参数
     *
     * @return
     */
    @Override
    public RequestParams getParamenters() {
        return null;
    }

    /**
     * 显示操作进度
     */
    @Override
    public void showProgress() {

    }

    /**
     * 关闭进度
     */
    @Override
    public void closeProgress() {

    }

    /**
     * 失败回调
     *
     * @param mCallBackVo
     */
    @Override
    public void excuteFailedCallBack(CallBackVo mCallBackVo) {

    }

    @Override
    public void excuteSuccessCallBack(ZGWHBean mCallBackVo) {
        mList = mCallBackVo.getWhzd();
    }
}
