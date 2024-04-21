package com.example.lab15;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button bdatchik;
    private Button bcompas;
    private Button btemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bdatchik=findViewById(R.id.bdatchik);
        bcompas=findViewById(R.id.bcompas);
        btemp=findViewById(R.id.bos);
        btemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });
        bcompas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
        bdatchik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}