package com.mml.studyapp.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.bean.TSSCBean;
import com.mml.studyapp.iactivityview.GXJDActivityView;
import com.mml.studyapp.iactivityview.TSSCActivityView;
import com.mml.studyapp.utils.common.AppMethod;

/**
 * Created by MLing on 2018/5/10 0010.
 */

public class GXJDActivityPresenter {
    private GXJDActivityView mGXJDActivityView;

    public GXJDActivityPresenter(GXJDActivityView mGXJDActivityView) {
        this.mGXJDActivityView = mGXJDActivityView;
    }

    public void getGXJDMUJsonString(Context mContext, String fileName) {
        String result = AppMethod.initJsonData(mContext, fileName);
        try {
            Gson gson = new Gson();
            GXJDBean bean = gson.fromJson(result, GXJDBean.class);
            mGXJDActivityView.excuteSuccessCallBack(bean);
        } catch (Exception e) {
            CallBackVo mCallBackVo = new CallBackVo();
            mCallBackVo.setErrcode(404);
            mCallBackVo.setErrmsg(e.getMessage());
            mGXJDActivityView.excuteFailedCallBack(mCallBackVo);
        }

    }
}
