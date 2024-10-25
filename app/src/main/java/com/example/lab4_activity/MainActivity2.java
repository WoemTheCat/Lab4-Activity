package com.example.lab4_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private EditText ed_drink;
    private RadioGroup radioGroup, radioGroup2;
    private Button btn_send;

    private String sugar = "無糖";
    private String ice = "去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed_drink = findViewById(R.id.ed_drink);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup2 = findViewById(R.id.radioGroup2);
        btn_send = findViewById(R.id.btn_send);

        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton) {
                sugar = "無糖";
            } else if (i == R.id.radioButton2) {
                sugar = "少糖";
            } else if (i == R.id.radioButton3) {
                sugar = "半糖";
            } else if (i == R.id.radioButton4) {
                sugar = "全糖";
            }
        });

        radioGroup2.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton5) {
                ice = "去冰";
            } else if (i == R.id.radioButton6) {
                ice = "微冰";
            } else if (i == R.id.radioButton7) {
                ice = "少冰";
            } else if (i == R.id.radioButton8) {
                ice = "正常冰";
            }
        });

        btn_send.setOnClickListener(view -> {
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink", ed_drink.getText().toString());
            b.putString("sugar", sugar);
            b.putString("ice", ice);
            i.putExtras(b);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
    }
}