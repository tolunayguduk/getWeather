package com.tolunayguduk.hava_durumu;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class login extends AppCompatActivity {
ConstraintLayout l1;
Button btn1;
AutoCompleteTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        l1=findViewById(R.id.l1);

        AutoCompleteTextView textView=(AutoCompleteTextView) findViewById(R.id.auto);
        String[] sehirler=getResources().getStringArray(R.array.sehirler_array);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sehirler);
        textView.setAdapter(adapter);

        initComponents();
        registerEventHandlers();
        txtIsim_onFocusChange();
        
    }
    private void registerEventHandlers() {
        btn1_OnClick();
    }
    private void txtIsim_onFocusChange() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(l1);

                constraintSet.connect(textView.getId(), ConstraintSet.TOP, l1.getId(), ConstraintSet.TOP,0);
                constraintSet.clear(textView.getId(), ConstraintSet.BOTTOM);
                constraintSet.applyTo(l1);
            }
        });
    }
    private void btn1_OnClick() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent=new Intent(login.this,MainActivity.class);
                intent.putExtra("sehir",textView.getText().toString());
                startActivity(intent);

            }
        });
    }
    private void initComponents() {
        l1=findViewById(R.id.l1);
        btn1=findViewById(R.id.btn1);
        textView=findViewById(R.id.auto);
    }
}
