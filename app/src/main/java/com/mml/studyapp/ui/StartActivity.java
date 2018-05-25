package com.mml.studyapp.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;
import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.CallBackVo;
import com.mml.studyapp.iactivityview.StartActivityView;
import com.mml.studyapp.presenter.StartActivityPresenter;
import com.mml.studyapp.utils.common.AppMethod;
import com.mml.studyapp.utils.common.Constants;
import com.mml.studyapp.utils.common.SharePreferenceUtil;
import com.mml.studyapp.utils.common.UserConfig;
import com.mml.studyapp.utils.common.log.LogUtil;
import com.mml.studyapp.utils.dialogutils.MDialog;
import com.mml.studyapp.utils.runtimepermissions.PermissionsManager;
import com.mml.studyapp.utils.runtimepermissions.PermissionsResultAction;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

/**
 * Created by MLing on 2018/5/25 0025.
 */

public class StartActivity extends BaseCompatActivity implements View.OnClickListener, StartActivityView {
    private StartActivityPresenter mStartActivityPresenter;
    private TextView tv_device_number;
    private AppCompatEditText edt_device_code;
    private View rootLayout;
    private String inputNumber;
    private String inputCode;

    /**
     * @param titleBar 设置标题栏
     */
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        mStartActivityPresenter = new StartActivityPresenter(this);
    }

    /**
     * @return 设置页面布局
     */
    @Override
    protected int onCreateViewId() {
        return R.layout.activity_start;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_return).setOnClickListener(this);
        view.findViewById(R.id.btn_ok).setOnClickListener(this);
        tv_device_number = (TextView) view.findViewById(R.id.tv_device_number);
        edt_device_code = (AppCompatEditText) view.findViewById(R.id.edt_device_code);
        rootLayout = view.findViewById(R.id.rootLayout);
    }

    /**
     * 本地传参
     */
    @Override
    protected void getExras() {

    }

    /**
     * 监听事件
     */
    @Override
    protected void setListener() {
        if (Build.VERSION.SDK_INT >= 23) {
            LogUtil.i("PUTTAG","========================1");
            requestPermissions();
        }else {
            tv_device_number.setText(AppMethod.getDeviceIMEI(StartActivity.this));
            LogUtil.i("PUTTAG","========================2");
        }
        if (SharePreferenceUtil.getBoolean(StartActivity.this, UserConfig.USER_DEVICE_IMEI_CODE, false)) {
            ActivityAnim.intentActivity(this, MainActivity.class, null);
            finish();
        }
    }

    /**
     * 获取数据方法，之后，View赋值
     */
    @Override
    protected void fromNetGetData() {

    }

    /**
     * 获取数据方法，之后，View赋值
     */
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
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            case R.id.btn_ok:
                inputSuccess();
                break;
        }
    }

    private void inputSuccess() {
        inputNumber = tv_device_number.getText().toString();
        inputCode = edt_device_code.getText().toString();
        if (TextUtils.isEmpty(inputNumber)) {
            MDialog.getInstance(this).showToast(rootLayout, "设备信息读取失败！");
            return;
        }

        if (TextUtils.isEmpty(inputCode)) {
            MDialog.getInstance(this).showToast(rootLayout, "请填写注册码！");
            return;
        }
        mStartActivityPresenter.getVerifyCode(Constants.BASE_URL_ONLY);
    }

    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
                tv_device_number.setText(AppMethod.getDeviceIMEI(StartActivity.this));
            }

            @Override
            public void onDenied(String permission) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        PermissionsManager.getInstance().notifyPermissionsChange(permissions, grantResults);
        tv_device_number.setText(AppMethod.getDeviceIMEI(StartActivity.this));
    }

    /**
     * 获取参数
     *
     * @return
     */
    @Override
    public RequestParams getParamenters() {
        RequestParams params = AppMethod.getMapParams();
        params.put("dnumber", inputNumber);
        params.put("sid", inputCode);
        return params;
    }

    /**
     * 显示操作进度
     */
    @Override
    public void showProgress() {
//        MDialog.getInstance(this).showProgressDialog();
    }

    /**
     * 关闭进度
     */
    @Override
    public void closeProgress() {
//        MDialog.getInstance(this).closeProgressDialog();
    }

    /**
     * 失败回调
     *
     * @param mCallBackVo
     */
    @Override
    public void excuteFailedCallBack(CallBackVo mCallBackVo) {
        MDialog.getInstance(this).showToast(rootLayout, mCallBackVo.getErrmsg());
    }

    @Override
    public void excuteSuccessCallBack(CallBackVo mCallBackVo) {
        SharePreferenceUtil.setValue(StartActivity.this, UserConfig.USER_DEVICE_IMEI_CODE, true);
        ActivityAnim.intentActivity(this, MainActivity.class, null);
        finish();
    }
}
