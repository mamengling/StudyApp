package com.mml.studyapp.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.view.View;

import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.utils.runtimepermissions.PermissionsManager;
import com.mml.studyapp.utils.runtimepermissions.PermissionsResultAction;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

public class MainActivity extends BaseCompatActivity implements View.OnClickListener {

    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS;
    public static final String READ_PHONE_STATE = Manifest.permission.RECORD_AUDIO;
    public static final String RECEIVE_BOOT_COMPLETED = Manifest.permission.READ_PHONE_STATE;
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private static final String[] requestPermissions = {
            ACCESS_COARSE_LOCATION,
            ACCESS_FINE_LOCATION,
            READ_PHONE_STATE,
            RECEIVE_BOOT_COMPLETED,
            READ_EXTERNAL_STORAGE,
            WRITE_EXTERNAL_STORAGE
    };
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        requestPermissions();
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.iv_hzzy).setOnClickListener(this);
        view.findViewById(R.id.iv_tssc).setOnClickListener(this);
        view.findViewById(R.id.iv_gxjd).setOnClickListener(this);
        view.findViewById(R.id.iv_wymp).setOnClickListener(this);
        view.findViewById(R.id.iv_jdmz).setOnClickListener(this);
        view.findViewById(R.id.iv_zgwh).setOnClickListener(this);
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void setListener() {
    }
    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(this, requestPermissions,new PermissionsResultAction() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied(String permission) {

            }
        });
    }
    @Override
    protected void fromNetGetData() {

    }

    @Override
    protected void fromNotMsgReference() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_hzzy:
                ActivityAnim.intentActivity(this, HZZYActivity.class, null);
                break;
            case R.id.iv_tssc:
                ActivityAnim.intentActivity(this, TSSCActivity.class, null);
                break;
            case R.id.iv_gxjd:
                ActivityAnim.intentActivity(this, GXJDActivity.class, null);
                break;
            case R.id.iv_wymp:
                ActivityAnim.intentActivity(this, WYMPActivity.class, null);
                break;
            case R.id.iv_jdmz:
                ActivityAnim.intentActivity(this, JDMZActivity.class, null);
                break;
            case R.id.iv_zgwh:
                ActivityAnim.intentActivity(this, ZGWHActivity.class, null);
                break;
        }
    }
}
