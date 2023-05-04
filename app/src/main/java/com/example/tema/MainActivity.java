package com.example.tema;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton radioAcik = (RadioButton) findViewById(R.id.radioLight);
        RadioButton radioKapali = (RadioButton) findViewById(R.id.radioDark);

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        editor  = sharedPreferences.edit();

        int veri = sharedPreferences.getInt("tema", 0);
        if(veri == AppCompatDelegate.MODE_NIGHT_NO){
            radioAcik.setChecked(true);
        }else{
            radioKapali.setChecked(true);
        }
    }

    public void onRadioClick(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radioLight:
                if(checked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putInt("tema", AppCompatDelegate.MODE_NIGHT_NO);
                    editor.apply();
                }
                break;
            case R.id.radioDark:
                if(checked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putInt("tema", AppCompatDelegate.MODE_NIGHT_YES);
                    editor.apply();
                }
                break;
        }
    }
}