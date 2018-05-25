package com.mml.studyapp.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.TSSCBean;
import com.mml.studyapp.iactivityview.TSSCActivityView;
import com.mml.studyapp.utils.common.AppMethod;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:45
 */

public class TSSCActivityPresenter {
    private TSSCActivityView mTSSCActivityView;

    public TSSCActivityPresenter(TSSCActivityView mTSSCActivityView) {
        this.mTSSCActivityView = mTSSCActivityView;
    }

    public void getTSSCMUJsonString(Context mContext, String fileName) {
        String result = AppMethod.initJsonData(mContext, fileName);
        try {
            Gson gson = new Gson();
            TSSCBean bean = gson.fromJson(result, TSSCBean.class);
            mTSSCActivityView.excuteSuccessCallBack(bean);
        } catch (Exception e) {
            CallBackVo mCallBackVo = new CallBackVo();
            mCallBackVo.setErrcode(404);
            mCallBackVo.setErrmsg(e.getMessage());
            mTSSCActivityView.excuteFailedCallBack(mCallBackVo);
        }

    }
}
