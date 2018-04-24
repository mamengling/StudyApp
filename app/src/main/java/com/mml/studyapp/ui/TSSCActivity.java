package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.loopj.android.http.RequestParams;
import com.maxi.audiotools.IMAudioManager;
import com.mml.studyapp.R;
import com.mml.studyapp.adapter.TSSCMuluListAdapter;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.TSSCBean;
import com.mml.studyapp.iactivityview.TSSCActivityView;
import com.mml.studyapp.presenter.TSSCActivityPresenter;
import com.mml.studyapp.utils.common.ConstmOnItemOnclickListener;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.List;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:22
 */

public class TSSCActivity extends BaseCompatActivity implements View.OnClickListener, TSSCActivityView {
    private TSSCActivityPresenter mTSSCActivityPresenter;
    private ListView recycler_view;
    private List<TSSCBean.MuluBean> mList;
    private TSSCMuluListAdapter mAdapter;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        mTSSCActivityPresenter = new TSSCActivityPresenter(this);
        IMAudioManager.instance().init(this);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_tssc;
    }

    @Override
    protected void onCreateViewContent(View view) {
        recycler_view = (ListView) view.findViewById(R.id.recycler_view);
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
        mTSSCActivityPresenter.getTSSCMUJsonString(this, "tssc.json");
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

    @Override
    public void excuteSuccessCallBack(TSSCBean mCallBackVo) {
        if (mCallBackVo != null && mCallBackVo.getMulu() != null && mCallBackVo.getMulu().size() > 0) {
            mList = mCallBackVo.getMulu();
            mAdapter = new TSSCMuluListAdapter(mCallBackVo.getMulu(), this);
            recycler_view.setAdapter(mAdapter);
            mAdapter.setOnGridviewItemClickListener(new ConstmOnItemOnclickListener() {
                @Override
                public void clickItem(View view, int position, int positionChild, int ClickType, String content) {
                    if (mList != null && mList.size() > 0) {
                        Intent intent = new Intent(TSSCActivity.this, TSSCInfoActivity.class);
                        intent.putExtra("tsscdate", mList.get(position).getKkk().get(positionChild));
                        ActivityAnim.intentActivity(TSSCActivity.this, intent);
                    }
                }
            });
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
