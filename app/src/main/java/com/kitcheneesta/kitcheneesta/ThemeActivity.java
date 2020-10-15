package com.kitcheneesta.kitcheneesta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.kitcheneesta.kitcheneesta.Model.Data;
import com.kitcheneesta.kitcheneesta.Model.OrderObject;
import com.kitcheneesta.kitcheneesta.Model.Pages;
import com.kitcheneesta.kitcheneesta.Model.ThemeAdapter;

import java.io.FileNotFoundException;


public class ThemeActivity extends Activity {

    private int [] mLogos;
    private GridView mGridView;
    private int cakeOpt;
    private int creamOpt;
    private int weightOpt;
    private EditText mThemeEdit;
    private EditText mTitleEdit;
    private Button mContinueButton;
    private Button mDrawButton;
    private Button msliderButton;
    Bitmap bmp;
    Bitmap alteredBitmap;
    ImageView choosenImageView;
    ImageView extraImageView;
    Bitmap mImage1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        Intent intent = getIntent();
        cakeOpt = intent.getIntExtra("cakeOpt", 2);
        creamOpt = intent.getIntExtra("creamOpt", 2);
        weightOpt = intent.getIntExtra("weightOpt", 0);
        Toast.makeText(this, " " + cakeOpt + " " + creamOpt, Toast.LENGTH_LONG).show();
       choosenImageView = (ImageView) this.findViewById(R.id.EditedImage);
        extraImageView = (ImageView) this.findViewById(R.id.ExtraImage);
        mThemeEdit = (EditText) findViewById(R.id.theme_edit_text);
        mTitleEdit = (EditText) findViewById(R.id.cake_edit_text);
        mLogos = Pages.themePics;
       ThemeAdapter adapter = new ThemeAdapter(this, mLogos);
        mGridView = (GridView) findViewById(R.id.themeGrid);
       mGridView.setAdapter(adapter);
       choosenImageView.setImageBitmap(Data.cake);
       extraImageView.setImageResource(Data.extra);
        mDrawButton = (Button) findViewById(R.id.drawButton);
        mDrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.customizeFlag=1;
                Intent intent = new Intent(ThemeActivity.this, SampleActivity.class);
                startActivity(intent);
            }
        });
        msliderButton = (Button) findViewById(R.id.sliderButton);
        msliderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemeActivity.this, SliderActivity.class);
                startActivity(intent);
            }
        });


        mContinueButton = (Button) findViewById(R.id.nextButton);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String themeText =  mThemeEdit.getText().toString();
                String titleText = mTitleEdit.getText().toString();
                Data.cakeText = titleText;
                Data.cakeTheme = themeText;

                Intent intent = new Intent(ThemeActivity.this, DeliverActivity.class);
                startActivity(intent);
            }
        });
    }


}
