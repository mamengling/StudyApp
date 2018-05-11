package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;

import com.loopj.android.http.RequestParams;
import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.iactivityview.GXJDActivityView;
import com.mml.studyapp.presenter.GXJDActivityPresenter;
import com.mml.studyapp.presenter.TSSCActivityPresenter;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:22
 */

public class GXJDActivity extends BaseCompatActivity implements View.OnClickListener, GXJDActivityView {
    private GXJDActivityPresenter mGXJDActivityPresenter;
    private GXJDBean mGXJDBean;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        mGXJDActivityPresenter = new GXJDActivityPresenter(this);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_gxjd_indzex;
    }

    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.line_qimeng).setOnClickListener(this);
        view.findViewById(R.id.line_sixiang).setOnClickListener(this);
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
        mGXJDActivityPresenter.getGXJDMUJsonString(this, "gxjd.json");
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
            case R.id.line_qimeng:
                Intent intent1 = new Intent(this, GXJDQMactivity.class);
                intent1.putParcelableArrayListExtra("qmdw",mGXJDBean.getQmdw());
                ActivityAnim.intentActivity(this, intent1);
                break;
            case R.id.line_sixiang:
                Intent intent2 = new Intent(this, GXJDXSactivity.class);
                intent2.putParcelableArrayListExtra("sxyd",mGXJDBean.getSxyd());
                ActivityAnim.intentActivity(this, intent2);
                break;
        }
    }

    @Override
    public void excuteSuccessCallBack(GXJDBean mCallBackVo) {
        mGXJDBean = mCallBackVo;
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
}
