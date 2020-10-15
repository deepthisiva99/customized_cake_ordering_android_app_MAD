package com.kitcheneesta.kitcheneesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

import com.kitcheneesta.kitcheneesta.Model.Data;

public class SliderActivity extends Activity  {
    String[] country;
    Button mfinalizeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        mfinalizeButton = (Button) findViewById(R.id.finalizeButton);
        mfinalizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.extraFlag=1;
                Intent intent = new Intent(SliderActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });
    }
}

