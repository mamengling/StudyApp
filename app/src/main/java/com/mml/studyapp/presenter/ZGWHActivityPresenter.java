package com.mml.studyapp.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.bean.JDMZBean;
import com.mml.studyapp.bean.ZGWHBean;
import com.mml.studyapp.iactivityview.JDMZActivityView;
import com.mml.studyapp.iactivityview.ZGWHActivityView;
import com.mml.studyapp.utils.common.AppMethod;

/**
 * Created by MLing on 2018/5/23 0023.
 */

public class ZGWHActivityPresenter {
    private ZGWHActivityView mZGWHActivityView;

    public ZGWHActivityPresenter(ZGWHActivityView mZGWHActivityView) {
        this.mZGWHActivityView = mZGWHActivityView;
    }


    public void getZHWHJsonString(Context mContext, String fileName) {
        String result = AppMethod.initJsonData(mContext, fileName);
        try {
            Gson gson = new Gson();
            ZGWHBean bean = gson.fromJson(result, ZGWHBean.class);
            mZGWHActivityView.excuteSuccessCallBack(bean);
        } catch (Exception e) {
            CallBackVo mCallBackVo = new CallBackVo();
            mCallBackVo.setCode(404);
            mCallBackVo.setMessage(e.getMessage());
            mCallBackVo.setData(null);
            mZGWHActivityView.excuteFailedCallBack(mCallBackVo);
        }
    }
}
