package com.ansel.animdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_set_xml, btn_alpha, btn_scale, btn_rotate, btn_translate, btn_anim_group, btn_cus_amin_tremble, btn_cus_amin_tvclose;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        registerListener();
    }

    private void initView() {
        btn_set_xml = (Button) findViewById(R.id.btn_set_xml);
        btn_alpha = (Button) findViewById(R.id.btn_alpha);
        btn_scale = (Button) findViewById(R.id.btn_scale);
        btn_rotate = (Button) findViewById(R.id.btn_rotate);
        btn_translate = (Button) findViewById(R.id.btn_translate);
        btn_anim_group = (Button) findViewById(R.id.btn_anim_group);
        btn_cus_amin_tremble = (Button) findViewById(R.id.btn_cus_amin_tremble);
        btn_cus_amin_tvclose = (Button) findViewById(R.id.btn_cus_amin_tvclose);
    }

    private void registerListener() {
        btn_set_xml.setOnClickListener(this);
        btn_alpha.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_translate.setOnClickListener(this);
        btn_anim_group.setOnClickListener(this);
        btn_cus_amin_tremble.setOnClickListener(this);
        btn_cus_amin_tvclose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_set_xml:
                intent.putExtra(TAG, "btn_set_xml");
                break;
            case R.id.btn_alpha:
                intent.putExtra(TAG, "btn_alpha");
                break;
            case R.id.btn_scale:
                intent.putExtra(TAG, "btn_scale");
                break;
            case R.id.btn_rotate:
                intent.putExtra(TAG, "btn_rotate");
                break;
            case R.id.btn_translate:
                intent.putExtra(TAG, "btn_translate");
                break;
            case R.id.btn_anim_group:
                intent.putExtra(TAG, "btn_anim_group");
                break;
            case R.id.btn_cus_amin_tremble:
                intent.putExtra(TAG, "btn_cus_amin_tremble");
                break;case R.id.btn_cus_amin_tvclose:
                intent.putExtra(TAG, "btn_cus_amin_tvclose");
                break;
        }

        intent.setClass(this, AnimActivity.class);
        startActivity(intent);
    }
}
