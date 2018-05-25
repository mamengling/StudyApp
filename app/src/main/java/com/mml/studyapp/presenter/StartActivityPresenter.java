package com.mml.studyapp.presenter;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.iactivityview.StartActivityView;
import com.mml.studyapp.utils.common.HttpUtil;
import com.mml.studyapp.utils.common.log.LogUtil;
import com.mml.studyapp.utils.common.log.klog.JsonLog;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by MLing on 2018/5/25 0025.
 */

public class StartActivityPresenter {
    private StartActivityView mStartActivityView;

    public StartActivityPresenter(StartActivityView mStartActivityView) {
        this.mStartActivityView = mStartActivityView;
    }

    public void getVerifyCode(String url) {
        mStartActivityView.showProgress();
        HttpUtil.get(url, mStartActivityView.getParamenters(), new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                mStartActivityView.showProgress();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                mStartActivityView.closeProgress();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                LogUtil.i("putUserInfo", result);
                JsonLog.printJson("putUserInfo", result, this.getRequestURI().toString());
                mStartActivityView.closeProgress();
                try {
                    Gson gson = new Gson();
                    CallBackVo userVo = gson.fromJson(result, CallBackVo.class);
                    if (userVo.getErrcode() == 0) {
                        mStartActivityView.excuteSuccessCallBack(userVo);
                    } else {
                        CallBackVo mCallBackVo = new CallBackVo();
                        mCallBackVo.setErrcode(userVo.getErrcode());
                        mCallBackVo.setErrmsg(userVo.getErrmsg());
                        mStartActivityView.excuteFailedCallBack(mCallBackVo);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                LogUtil.i("putUserInfo", "-----------------" + statusCode + "");
                LogUtil.i("putUserInfo", "-----------------" + error.getMessage() + "");
                mStartActivityView.closeProgress();
                JsonLog.printJson("TAG" + "[onError]", error.getMessage(), "");
                CallBackVo mCallBackVo = new CallBackVo();
                mCallBackVo.setErrcode(404);
                mCallBackVo.setErrmsg("别着急哦~");
                mStartActivityView.excuteFailedCallBack(mCallBackVo);
            }
        });
    }
}
