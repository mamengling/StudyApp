package com.mml.studyapp.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.TSSCBean;
import com.mml.studyapp.bean.WYMPBean;
import com.mml.studyapp.iactivityview.TSSCActivityView;
import com.mml.studyapp.iactivityview.WYMPActivityView;
import com.mml.studyapp.utils.common.AppMethod;

/**
 * Created by MLing on 2018/4/26 0026.
 */

public class WYMPActivityPresenter {
    private WYMPActivityView mWYMPActivityView;

    public WYMPActivityPresenter(WYMPActivityView mWYMPActivityView) {
        this.mWYMPActivityView = mWYMPActivityView;
    }

    public void getWYMPJsonString(Context mContext, String fileName) {
        String result = AppMethod.initJsonData(mContext, fileName);
        try {
            Gson gson = new Gson();
            WYMPBean bean = gson.fromJson(result, WYMPBean.class);
            mWYMPActivityView.excuteSuccessCallBack(bean);
        } catch (Exception e) {
            CallBackVo mCallBackVo = new CallBackVo();
            mCallBackVo.setErrcode(404);
            mCallBackVo.setErrmsg(e.getMessage());
            mWYMPActivityView.excuteFailedCallBack(mCallBackVo);
        }

    }
}
