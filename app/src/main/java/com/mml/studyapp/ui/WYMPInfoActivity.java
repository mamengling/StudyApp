package com.mml.studyapp.ui;

import android.media.MediaPlayer;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maxi.audiotools.IMAudioManager;
import com.mml.studyapp.R;
import com.mml.studyapp.base.BaseCompatActivity;
import com.mml.studyapp.bean.TSSCBean;
import com.mml.studyapp.bean.WYMPBean;
import com.mml.studyapp.utils.common.VoiceCallBack;
import com.mml.studyapp.utils.common.VoiceManager;
import com.mml.studyapp.utils.widget.ActivityAnim;
import com.mml.studyapp.utils.widget.TitleBar;

/**
 * Created by MLing on 2018/4/24 0024.
 */

public class WYMPInfoActivity extends BaseCompatActivity implements View.OnClickListener {
    private WebView web_view;
    private LinearLayout menuLayout;
    private LinearLayout line_play;
    private ImageView text_play;
    private ImageView tv_luyin;
    private ImageView tv_bofang;
    private WYMPBean.GwrmBean.KkkBean mMuluBean;
    private VoiceManager voiceManager;
    private String mRecPath;
    private LinearLayout mLayoutRecord;
    private RelativeLayout mLayoutPlay;
    private int flag_type;
    private TextView tv_gushi;
    private TextView tv_zhishi;
    private TextView tv_zhiyong;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
        IMAudioManager.instance().init(this);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_wymp_info;
    }

    @Override
    protected void onCreateViewContent(View view) {
        mLayoutRecord = (LinearLayout) findViewById(R.id.layout_record);
        mLayoutPlay = (RelativeLayout) findViewById(R.id.layout_play);
        web_view = (WebView) view.findViewById(R.id.web_view);
        menuLayout = (LinearLayout) view.findViewById(R.id.menuLayout);
        line_play = (LinearLayout) view.findViewById(R.id.line_play);
        text_play = (ImageView) view.findViewById(R.id.text_play);
        tv_luyin = (ImageView) view.findViewById(R.id.tv_luyin);
        tv_bofang = (ImageView) view.findViewById(R.id.tv_bofang);
        view.findViewById(R.id.tv_return).setOnClickListener(this);
        view.findViewById(R.id.tv_zw).setOnClickListener(this);
        view.findViewById(R.id.tv_zs).setOnClickListener(this);
        view.findViewById(R.id.tv_yw).setOnClickListener(this);
        view.findViewById(R.id.tv_bs).setOnClickListener(this);
        tv_gushi = (TextView) view.findViewById(R.id.tv_gushi);
        tv_zhishi = (TextView) view.findViewById(R.id.tv_zhishi);
        tv_zhiyong = (TextView) view.findViewById(R.id.tv_zhiyong);
    }

    @Override
    protected void getExras() {
        mMuluBean = getIntent().getParcelableExtra("tsscdate");
        flag_type = getIntent().getIntExtra("flag_type", 0);
    }

    @Override
    protected void setListener() {
        tv_gushi.setOnClickListener(this);
        tv_zhishi.setOnClickListener(this);
        tv_zhiyong.setOnClickListener(this);
        if (flag_type == 102) {
            tv_gushi.setText("作品简介");
            tv_zhishi.setText("作者简介");
            tv_zhiyong.setText("人物关系");
        }
        if (flag_type == 103) {
            tv_gushi.setText("作品简介");
            tv_zhishi.setText("作者简介");
            tv_zhiyong.setText("人物关系");
        }
        if (flag_type == 104) {
            tv_gushi.setText("文章赏析");
            tv_zhishi.setText("作者简介");
            tv_zhiyong.setVisibility(View.GONE);
            text_play.setVisibility(View.GONE);
        }
        tv_luyin.setOnClickListener(this);
        tv_bofang.setOnClickListener(this);
        voiceManager = new VoiceManager(WYMPInfoActivity.this, "/com.mml.studyapp/audio");
        voiceManager.setVoiceListener(new VoiceCallBack() {
            @Override
            public void voicePath(String path) {
                mRecPath = path;
//                tv_luyin.setVisibility(View.VISIBLE);
//                tv_bofang.setVisibility(View.GONE);
            }

            @Override
            public void recFinish() {
                tv_bofang.setVisibility(View.VISIBLE);
            }
        });
        text_play.setOnClickListener(this);
        web_view.setWebViewClient(new WebViewClient() {
            //覆写shouldOverrideUrlLoading实现内部显示网页
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO 自动生成的方法存根
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings seting = web_view.getSettings();
        seting.setPluginState(WebSettings.PluginState.ON);
        seting.setAllowFileAccess(true);
        seting.setJavaScriptCanOpenWindowsAutomatically(true);
        seting.setDefaultTextEncodingName("utf-8");//设置字符编码
        seting.setSupportZoom(false); // 支持缩放
        seting.setBuiltInZoomControls(true); // 启用内置缩放装置
        seting.setDisplayZoomControls(true);
        seting.setJavaScriptEnabled(true);//设置webview支持javascript脚本
        seting.setUseWideViewPort(true);
        seting.setLoadWithOverviewMode(true);
        seting.setSavePassword(true);
        seting.setSaveFormData(true);
        seting.setGeolocationEnabled(true);
        seting.setGeolocationDatabasePath("/data/data/$packageName/databases/");
        seting.setDomStorageEnabled(true);
        //扩大比例的缩放
        seting.setUseWideViewPort(true);
        //自适应屏幕
        seting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        seting.setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            seting.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        web_view.setInitialScale(10);
        web_view.setVerticalScrollBarEnabled(true);
        web_view.setHorizontalScrollBarEnabled(true);
        web_view.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {

                } else {

                }
            }
        });
        web_view.loadUrl(mMuluBean.getArticle());
    }

    @Override
    protected void fromNetGetData() {

    }

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
                ActivityAnim.endActivity(this);
                IMAudioManager.instance().release();
                break;
            case R.id.tv_zw:
                web_view.loadUrl(mMuluBean.getArticle());
                break;
            case R.id.tv_yw:
                web_view.loadUrl(mMuluBean.getTranslate());
                break;
            case R.id.tv_zs:
                web_view.loadUrl(mMuluBean.getExplain());
                break;
            case R.id.tv_bs:
                web_view.loadUrl(mMuluBean.getRecite());
                break;
            case R.id.tv_gushi:
                if (flag_type == 101) {
                    web_view.loadUrl(mMuluBean.getStory());
                } else if (flag_type == 102) {
                    web_view.loadUrl(mMuluBean.getWorks());
                } else if (flag_type == 103) {
                    web_view.loadUrl(mMuluBean.getWorks());
                } else if (flag_type == 104) {
                    web_view.loadUrl(mMuluBean.getWorks());
                }
                break;
            case R.id.tv_zhishi:
                if (flag_type == 101) {
                    web_view.loadUrl(mMuluBean.getKnowledge());
                } else if (flag_type == 102) {
                    web_view.loadUrl(mMuluBean.getAuthor());
                } else if (flag_type == 103) {
                    web_view.loadUrl(mMuluBean.getAuthor());
                } else if (flag_type == 104) {
                    web_view.loadUrl(mMuluBean.getAuthor());
                }
                break;
            case R.id.tv_zhiyong:
                if (flag_type == 101) {
                    web_view.loadUrl(mMuluBean.getPractise());
                } else if (flag_type == 102) {
                    web_view.loadUrl(mMuluBean.getRelationship());
                } else if (flag_type == 103) {
                    web_view.loadUrl(mMuluBean.getRelationship());
                } else if (flag_type == 104) {

                }

                break;
            case R.id.text_play:
                IMAudioManager.instance().playSound(mMuluBean.getSpeech(), new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(WYMPInfoActivity.this, "播放结束", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.tv_luyin:
                mLayoutRecord.setVisibility(View.VISIBLE);
                mLayoutPlay.setVisibility(View.GONE);
                voiceManager.sessionRecord(true);
                break;
            case R.id.tv_bofang:
                voiceManager.sessionPlay(true, mRecPath);
                mLayoutRecord.setVisibility(View.GONE);
                tv_bofang.setVisibility(View.GONE);
                mLayoutPlay.setVisibility(View.VISIBLE);
                break;
        }
    }
}
