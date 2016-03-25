package com.ansel.animdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.ansel.animdemo.cusAnim.CusRotateAnim;
import com.ansel.animdemo.cusAnim.TVCloseAnim;
import com.ansel.animdemo.cusAnim.TrembleAnim;

public class AnimActivity extends AppCompatActivity {
    private ImageView iv_anim;
    public static final String TAG = "TAG";
    private String tag;
    private boolean flag = true;// 标记位，轮换展示两种自定义动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "别点了！没卵用！", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        iv_anim = (ImageView) findViewById(R.id.iv_anim);
        tag = getIntent().getStringExtra(TAG);

        anim();

        iv_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim();
            }
        });
    }

    private void anim() {
        if ("btn_set_xml".equals(tag)) {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.viewanim);
            animation.setDuration(5000);
            animation.setFillAfter(false);
            iv_anim.startAnimation(animation);
        } else if ("btn_alpha".equals(tag)) {
            AlphaAnimation alpha = new AlphaAnimation(0, 1);// 0---->1从透明到不透明
            alpha.setDuration(3000);// 设置动画持续时间
            iv_anim.startAnimation(alpha);// 启动动画
        } else if ("btn_scale".equals(tag)) {
            ScaleAnimation scale = new ScaleAnimation(0, 2, 0, 2);
            scale.setDuration(3000);
            iv_anim.startAnimation(scale);
        } else if ("btn_rotate".equals(tag)) {
            RotateAnimation rotate = new RotateAnimation(0, 360,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(3000);
            iv_anim.startAnimation(rotate);
        } else if ("btn_translate".equals(tag)) {
            TranslateAnimation translate = new TranslateAnimation(0, 200, 0, 300);
            translate.setDuration(3000);
            iv_anim.startAnimation(translate);
        } else if ("btn_anim_group".equals(tag)) {
            groupView();
        } else if ("btn_cus_amin_tremble".equals(tag)) {
            // 创建抖一抖动画对象
            final TrembleAnim tremble = new TrembleAnim();
            tremble.setDuration(800);// 持续时间800ms，持续时间越短频率越高
            tremble.setRepeatCount(1);// 重复次数，不包含第一次
            iv_anim.startAnimation(tremble);
        } else if ("btn_cus_amin_tvclose".equals(tag)) {
            if (flag) {
                TVCloseAnim tvAni = new TVCloseAnim();
                tvAni.setFillAfter(false);
                iv_anim.startAnimation(tvAni);
                // 重置标记位
                flag = false;
            } else {
                CusRotateAnim customAni = new CusRotateAnim();
                customAni.setRotateY(30);
                customAni.setFillAfter(false);
                iv_anim.startAnimation(customAni);
                // 重置标记位
                flag = true;
            }
        }
    }

    private void groupView() {
        // 创建动画集合
        AnimationSet aniSet = new AnimationSet(false);//参数：表示是否共享插值器 true：共享    false：不共享

        // 透明度动画
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(4000);
        aniSet.addAnimation(alpha);

        // 旋转动画
        RotateAnimation rotate = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(4000);
        aniSet.addAnimation(rotate);

        // 缩放动画
        ScaleAnimation scale = new ScaleAnimation(1.5f, 0.5f, 1.5f, 0.5f);
        scale.setDuration(4000);
        aniSet.addAnimation(scale);

        // 位移动画
        TranslateAnimation translate = new TranslateAnimation(0, 160, 0, 240);
        translate.setDuration(4000);
        aniSet.addAnimation(translate);

        // 动画监听
        aniSet.setAnimationListener(new Animation.AnimationListener() {
            // 动画开始
            @Override
            public void onAnimationStart(Animation animation) {

            }

            // 动画结束，一般在这里实现页面跳转逻辑
            @Override
            public void onAnimationEnd(Animation animation) {
                // 动画结束后，跳转到主页面
//                startActivity(new Intent(AnimActivity.this, MainActivity.class));
            }

            // 动画重复
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // 把动画设置给iv_anim
        iv_anim.startAnimation(aniSet);
    }

}
