package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;

import com.loopj.android.http.RequestParams;
import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.bean.JDMZBean;
import com.mml.studyapp.iactivityview.JDMZActivityView;
import com.mml.studyapp.presenter.JDMZActivityPresenter;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:23
 */

public class JDMZActivity extends BaseCompatActivity implements View.OnClickListener, JDMZActivityView {
    private JDMZActivityPresenter mJDMZActivityPresenter;
    private ArrayList<JDMZBean.JdmzBean> mList;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        mJDMZActivityPresenter = new JDMZActivityPresenter(this);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_jdmz;
    }

    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_rtjd).setOnClickListener(this);
        view.findViewById(R.id.tv_xdmz).setOnClickListener(this);
        view.findViewById(R.id.tv_gdmz).setOnClickListener(this);
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
        mJDMZActivityPresenter.getJDMZJsonString(this, "jdmz.json");
    }

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
            case R.id.tv_rtjd:
                Intent intent1 = new Intent(this, JDMZMuluActivity.class);
                intent1.putParcelableArrayListExtra("muluinfo", mList.get(0).getDetail());
                intent1.putExtra("mulu", mList.get(0).getMulu());
                ActivityAnim.intentActivity(this, intent1);
                break;
            case R.id.tv_xdmz:
                Intent intent2 = new Intent(this, JDMZMuluActivity.class);
                intent2.putParcelableArrayListExtra("muluinfo", mList.get(1).getDetail());
                intent2.putExtra("mulu", mList.get(1).getMulu());
                ActivityAnim.intentActivity(this, intent2);
                break;
            case R.id.tv_gdmz:
                Intent intent3 = new Intent(this, JDMZMuluActivity.class);
                intent3.putParcelableArrayListExtra("muluinfo", mList.get(2).getDetail());
                intent3.putExtra("mulu", mList.get(2).getMulu());
                ActivityAnim.intentActivity(this, intent3);
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
    public void excuteSuccessCallBack(JDMZBean mCallBackVo) {
        mList = mCallBackVo.getJdmz();
    }
}
