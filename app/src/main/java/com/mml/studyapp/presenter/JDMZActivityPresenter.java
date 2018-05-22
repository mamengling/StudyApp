package com.mml.studyapp.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.bean.JDMZBean;
import com.mml.studyapp.iactivityview.JDMZActivityView;
import com.mml.studyapp.utils.common.AppMethod;

/**
 * Created by MLing on 2018/5/22 0022.
 */

public class JDMZActivityPresenter {
    private JDMZActivityView mJDMZActivityView;

    public JDMZActivityPresenter(JDMZActivityView mJDMZActivityView) {
        this.mJDMZActivityView = mJDMZActivityView;
    }


    public void getJDMZJsonString(Context mContext, String fileName) {
        String result = AppMethod.initJsonData(mContext, fileName);
        try {
            Gson gson = new Gson();
            JDMZBean bean = gson.fromJson(result, JDMZBean.class);
            mJDMZActivityView.excuteSuccessCallBack(bean);
        } catch (Exception e) {
            CallBackVo mCallBackVo = new CallBackVo();
            mCallBackVo.setCode(404);
            mCallBackVo.setMessage(e.getMessage());
            mCallBackVo.setData(null);
            mJDMZActivityView.excuteFailedCallBack(mCallBackVo);
        }
    }
}
