package com.kitcheneesta.kitcheneesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.kitcheneesta.kitcheneesta.Model.Data;
import com.kitcheneesta.kitcheneesta.Model.Pages;
import com.kitcheneesta.kitcheneesta.Model.ThemeAdapter;

public class DeliverActivity extends Activity {

    /*private EditText mAddressEdit;
    private EditText mPhoneEdit;
    private Button mContinueButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);
        Intent intent = getIntent();
        mAddressEdit = (EditText) findViewById(R.id.address_edit_text);
        mPhoneEdit = (EditText) findViewById(R.id.phno_edit_text);

        mContinueButton = (Button) findViewById(R.id.nextButton);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.address =  mAddressEdit.getText().toString();
                Data.phno = mPhoneEdit.getText().toString();

                Intent intent = new Intent(DeliverActivity.this, SummaryActivity.class);
                startActivity(intent);
            }
        });
    }*/

    private int [] mLogos;
    private GridView mGridView;
    private int cakeOpt;
    private int creamOpt;
    private int weightOpt;
    private EditText mAddressEdit;
    private EditText mPhEdit;
    private Button mContinueButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);
        Intent intent = getIntent();
        mAddressEdit = (EditText) findViewById(R.id.address_edit_text);
        mPhEdit = (EditText) findViewById(R.id.ph_edit_text);
        mLogos = Pages.deliverPics;
        ThemeAdapter adapter = new ThemeAdapter(this, mLogos);
        mGridView = (GridView) findViewById(R.id.deliverGrid);
        mGridView.setAdapter(adapter);

        mContinueButton = (Button) findViewById(R.id.nextButton);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addressText =  mAddressEdit.getText().toString();
                String phText = mPhEdit.getText().toString();
                Data.address = addressText;
                Data.phno = phText;

                Intent intent = new Intent(DeliverActivity.this, SummaryActivity.class);
                startActivity(intent);
            }
        });
    }



}
