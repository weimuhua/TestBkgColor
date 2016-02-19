package com.wayne.testbkgcolor;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mChangeDrBtn;
    private Button mChangeBkgBtn;
    private Button mStartActivityBtn;
    private Button mStartNewActivityBtn;
    private RelativeLayout mHomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout);
        mStartActivityBtn = (Button) findViewById(R.id.start_activity_btn);
        mStartActivityBtn.setOnClickListener(this);
        mChangeBkgBtn = (Button) findViewById(R.id.change_bkg_btn);
        mChangeBkgBtn.setOnClickListener(this);
        mChangeDrBtn = (Button) findViewById(R.id.change_dr_btn);
        mChangeDrBtn.setOnClickListener(this);
        mStartNewActivityBtn = (Button) findViewById(R.id.start_test_activity_btn);
        mStartNewActivityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mChangeBkgBtn) {
            changeBkgColor();
        } else if (v == mStartActivityBtn) {
            startActivity();
        } else if (v == mChangeDrBtn) {
            changeDrawable();
        } else if (v == mStartNewActivityBtn) {
            startNewActivity();
        }
    }

    private void startActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void changeBkgColor() {
        mHomeLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    private void changeDrawable() {
        mHomeLayout.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
    }

    private void startNewActivity() {
        startActivity(new Intent(this, TestActivity.class));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
