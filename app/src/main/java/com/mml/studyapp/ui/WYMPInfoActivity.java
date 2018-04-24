package com.mml.studyapp.ui;
import android.view.View;

import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.utils.widget.TitleBar;

/**
 * Created by MLing on 2018/4/24 0024.
 */

public class WYMPInfoActivity extends BaseCompatActivity {
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_wymp_info;
    }

    @Override
    protected void onCreateViewContent(View view) {

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void fromNetGetData() {

    }

    @Override
    protected void fromNotMsgReference() {

    }
}
