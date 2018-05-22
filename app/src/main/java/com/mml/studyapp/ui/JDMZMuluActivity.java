package com.mml.studyapp.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.JDMZBean;
import com.mml.studyapp.utils.common.GlideUtils;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * Created by MLing on 2018/5/22 0022.
 */

public class JDMZMuluActivity extends BaseCompatActivity implements View.OnClickListener {
    private ArrayList<JDMZBean.JdmzBean.DetailBean> detail;
    private String name;
    private ImageView image_01, image_02, image_03, image_04, image_05, image_06, image_07, image_08, image_09, image_10, image_11, image_12, image_13, image_14;

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
        return R.layout.activity_mulu_jdmz;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        view.findViewById(R.id.tv_return).setOnClickListener(this);
        image_01 = (ImageView) view.findViewById(R.id.image_01);
        image_02 = (ImageView) view.findViewById(R.id.image_02);
        image_03 = (ImageView) view.findViewById(R.id.image_03);
        image_04 = (ImageView) view.findViewById(R.id.image_04);
        image_05 = (ImageView) view.findViewById(R.id.image_05);
        image_06 = (ImageView) view.findViewById(R.id.image_06);
        image_07 = (ImageView) view.findViewById(R.id.image_07);
        image_08 = (ImageView) view.findViewById(R.id.image_08);
        image_09 = (ImageView) view.findViewById(R.id.image_09);
        image_10 = (ImageView) view.findViewById(R.id.image_10);
        image_11 = (ImageView) view.findViewById(R.id.image_11);
        image_12 = (ImageView) view.findViewById(R.id.image_12);
        image_13 = (ImageView) view.findViewById(R.id.image_13);
        image_14 = (ImageView) view.findViewById(R.id.image_14);
    }

    /**
     * 本地传参
     */
    @Override
    protected void getExras() {
        detail = getIntent().getParcelableArrayListExtra("muluinfo");
        name = getIntent().getStringExtra("mulu");
    }

    /**
     * 监听事件
     */
    @Override
    protected void setListener() {
        image_01.setOnClickListener(this);
        image_02.setOnClickListener(this);
        image_03.setOnClickListener(this);
        image_04.setOnClickListener(this);
        image_05.setOnClickListener(this);
        image_06.setOnClickListener(this);
        image_07.setOnClickListener(this);
        image_08.setOnClickListener(this);
        image_09.setOnClickListener(this);
        image_10.setOnClickListener(this);
        image_11.setOnClickListener(this);
        image_12.setOnClickListener(this);
        image_13.setOnClickListener(this);
        image_14.setOnClickListener(this);
        if (detail != null) {
            if (TextUtils.equals("儿童经典", name)) {
                image_01.setVisibility(View.VISIBLE);
                image_02.setVisibility(View.VISIBLE);
                image_03.setVisibility(View.VISIBLE);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(0).getImg(), image_01, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(1).getImg(), image_02, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(2).getImg(), image_03, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
            } else if (TextUtils.equals("现当代名著", name)) {
                image_01.setVisibility(View.VISIBLE);
                image_02.setVisibility(View.VISIBLE);
                image_03.setVisibility(View.VISIBLE);
                image_04.setVisibility(View.VISIBLE);
                image_05.setVisibility(View.VISIBLE);
                image_06.setVisibility(View.VISIBLE);
                image_07.setVisibility(View.VISIBLE);
                image_08.setVisibility(View.VISIBLE);
                image_09.setVisibility(View.VISIBLE);
                image_10.setVisibility(View.VISIBLE);
                image_11.setVisibility(View.VISIBLE);
                image_12.setVisibility(View.VISIBLE);
                image_13.setVisibility(View.VISIBLE);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(0).getImg(), image_01, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(1).getImg(), image_02, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(2).getImg(), image_03, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(3).getImg(), image_04, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(4).getImg(), image_05, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(5).getImg(), image_06, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(6).getImg(), image_07, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(7).getImg(), image_08, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(8).getImg(), image_09, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(9).getImg(), image_10, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(10).getImg(), image_11, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(11).getImg(), image_12, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(12).getImg(), image_13, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
            } else if (TextUtils.equals("古典名著", name)) {
                image_01.setVisibility(View.VISIBLE);
                image_02.setVisibility(View.VISIBLE);
                image_03.setVisibility(View.VISIBLE);
                image_04.setVisibility(View.VISIBLE);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(0).getImg(), image_01, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(1).getImg(), image_02, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(2).getImg(), image_03, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, detail.get(3).getImg(), image_04, R.mipmap.jdmz_mulu_logo, GlideUtils.LOAD_BITMAP);

            }
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_return:
                ActivityAnim.endActivity(this);
                break;
            case R.id.image_01:
                Intent intent = new Intent(this, JDMZInfoActivity.class);
                intent.putExtra("muluinfo", detail.get(0));
                ActivityAnim.intentActivity(this, intent);
                break;
            case R.id.image_02:
                Intent intent1 = new Intent(this, JDMZInfoActivity.class);
                intent1.putExtra("muluinfo", detail.get(1));
                ActivityAnim.intentActivity(this, intent1);
                break;
            case R.id.image_03:
                Intent intent2 = new Intent(this, JDMZInfoActivity.class);
                intent2.putExtra("muluinfo", detail.get(2));
                ActivityAnim.intentActivity(this, intent2);
                break;
            case R.id.image_04:
                Intent intent3 = new Intent(this, JDMZInfoActivity.class);
                intent3.putExtra("muluinfo", detail.get(3));
                ActivityAnim.intentActivity(this, intent3);
                break;
            case R.id.image_05:
                Intent intent4 = new Intent(this, JDMZInfoActivity.class);
                intent4.putExtra("muluinfo", detail.get(4));
                ActivityAnim.intentActivity(this, intent4);
                break;
            case R.id.image_06:
                Intent intent5 = new Intent(this, JDMZInfoActivity.class);
                intent5.putExtra("muluinfo", detail.get(5));
                ActivityAnim.intentActivity(this, intent5);
                break;
            case R.id.image_07:
                Intent intent6 = new Intent(this, JDMZInfoActivity.class);
                intent6.putExtra("muluinfo", detail.get(6));
                ActivityAnim.intentActivity(this, intent6);
                break;
            case R.id.image_08:
                Intent intent7 = new Intent(this, JDMZInfoActivity.class);
                intent7.putExtra("muluinfo", detail.get(7));
                ActivityAnim.intentActivity(this, intent7);
                break;
            case R.id.image_09:
                Intent intent8 = new Intent(this, JDMZInfoActivity.class);
                intent8.putExtra("muluinfo", detail.get(8));
                ActivityAnim.intentActivity(this, intent8);
                break;
            case R.id.image_10:
                Intent intent9 = new Intent(this, JDMZInfoActivity.class);
                intent9.putExtra("muluinfo", detail.get(9));
                ActivityAnim.intentActivity(this, intent9);
                break;
            case R.id.image_11:
                Intent intent10 = new Intent(this, JDMZInfoActivity.class);
                intent10.putExtra("muluinfo", detail.get(10));
                ActivityAnim.intentActivity(this, intent10);
                break;
            case R.id.image_12:
                Intent intent11 = new Intent(this, JDMZInfoActivity.class);
                intent11.putExtra("muluinfo", detail.get(11));
                ActivityAnim.intentActivity(this, intent11);
                break;
            case R.id.image_13:
                Intent intent12 = new Intent(this, JDMZInfoActivity.class);
                intent12.putExtra("muluinfo", detail.get(12));
                ActivityAnim.intentActivity(this, intent12);
                break;
            case R.id.image_14:
                Intent intent13 = new Intent(this, JDMZInfoActivity.class);
                intent13.putExtra("muluinfo", detail.get(13));
                ActivityAnim.intentActivity(this, intent13);
                break;
        }
    }
}
