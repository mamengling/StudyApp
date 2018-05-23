package com.mml.studyapp.ui;

import android.content.Intent;
import android.view.View;

import com.maxi.audiotools.IMAudioManager;
import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.GXJDBean;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * Created by MLing on 2018/5/10 0010.
 */

public class GXJDXSactivity extends BaseCompatActivity implements View.OnClickListener{
    private ArrayList<GXJDBean.QmdwBean> mList;

    /**
     * @param titleBar 设置标题栏
     */
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    /**
     * @return 设置页面布局
     */
    @Override
    protected int onCreateViewId() {
        return R.layout.activity_gxjd_yuandian;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_yijing).setOnClickListener(this);
        view.findViewById(R.id.tv_lunyu).setOnClickListener(this);
        view.findViewById(R.id.tv_mengzi).setOnClickListener(this);
        view.findViewById(R.id.tv_daxue).setOnClickListener(this);
        view.findViewById(R.id.tv_zhongyong).setOnClickListener(this);
        view.findViewById(R.id.tv_laozi).setOnClickListener(this);
        view.findViewById(R.id.tv_zhuangzi).setOnClickListener(this);
        view.findViewById(R.id.tv_sunzibingfa).setOnClickListener(this);
        view.findViewById(R.id.tv_shijing).setOnClickListener(this);
        view.findViewById(R.id.tv_return).setOnClickListener(this);
    }

    /**
     * 本地传参
     */
    @Override
    protected void getExras() {
        mList = getIntent().getParcelableArrayListExtra("sxyd");
    }

    /**
     * 监听事件
     */
    @Override
    protected void setListener() {

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
        switch (v.getId()){
            case R.id.tv_return:
                ActivityAnim.endActivity(this);
                break;
            case R.id.tv_yijing:
                Intent intent1=new Intent(this,GXJDMuluActivity.class);
                intent1.putParcelableArrayListExtra("muluinfo",mList.get(0).getDetail());
                ActivityAnim.intentActivity(this,intent1);
                break;
            case R.id.tv_lunyu:
                Intent intent2=new Intent(this,GXJDMuluActivity.class);
                intent2.putParcelableArrayListExtra("muluinfo",mList.get(1).getDetail());
                ActivityAnim.intentActivity(this,intent2);
                break;
            case R.id.tv_mengzi:
                Intent intent3=new Intent(this,GXJDMuluActivity.class);
                intent3.putParcelableArrayListExtra("muluinfo",mList.get(2).getDetail());
                ActivityAnim.intentActivity(this,intent3);
                break;
            case R.id.tv_daxue:
                Intent intent4=new Intent(this,GXJDMuluActivity.class);
                intent4.putParcelableArrayListExtra("muluinfo",mList.get(3).getDetail());
                ActivityAnim.intentActivity(this,intent4);
                break;
            case R.id.tv_zhongyong:
                Intent intent5=new Intent(this,GXJDMuluActivity.class);
                intent5.putParcelableArrayListExtra("muluinfo",mList.get(4).getDetail());
                ActivityAnim.intentActivity(this,intent5);
                break;
            case R.id.tv_laozi:
                Intent intent6=new Intent(this,GXJDMuluActivity.class);
                intent6.putParcelableArrayListExtra("muluinfo",mList.get(5).getDetail());
                ActivityAnim.intentActivity(this,intent6);
                break;
            case R.id.tv_zhuangzi:
                Intent intent7=new Intent(this,GXJDMuluActivity.class);
                intent7.putParcelableArrayListExtra("muluinfo",mList.get(6).getDetail());
                ActivityAnim.intentActivity(this,intent7);
                break;
            case R.id.tv_sunzibingfa:
                Intent intent8=new Intent(this,GXJDMuluActivity.class);
                intent8.putParcelableArrayListExtra("muluinfo",mList.get(7).getDetail());
                ActivityAnim.intentActivity(this,intent8);
                break;
            case R.id.tv_shijing:
                Intent intent9=new Intent(this,GXJDMuluActivity.class);
                intent9.putParcelableArrayListExtra("muluinfo",mList.get(8).getDetail());
                ActivityAnim.intentActivity(this,intent9);
                break;
        }
    }
}
