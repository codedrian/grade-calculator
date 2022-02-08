package com.activity.roastactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText etmidTerm, etfinals;
        Button btnView,btnCompute;
        TextView etresult;
        Spinner spinsubject;

        String[] subject={"Java", "Mobile App", "HTML"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmidTerm=(EditText)findViewById(R.id.etMidTerm);
        etfinals=(EditText)findViewById(R.id.etfinals);
        btnView=(Button)findViewById(R.id.btnView);
        etresult=(TextView)findViewById(R.id.etresult);
        spinsubject=(Spinner)findViewById(R.id.spinsubject);
        btnCompute=(Button)findViewById(R.id.btnCompute);

        ArrayAdapter<String> subjectAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,subject);
        spinsubject.setAdapter(subjectAdapter);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double midTerm=Double.parseDouble(etmidTerm.getText().toString());
                double finals=Double.parseDouble(etfinals.getText().toString());
                String subject= spinsubject.getSelectedItem().toString();

                double result = midTerm+finals;
                double average = result / 2;
                Toast toast = Toast.makeText(MainActivity.this, "SUBJECT:" +subject+ "\nMIDTERM:" +midTerm+ "\nFINAL:" +finals+ "\nRESULT:" + average, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double midTerm=Double.parseDouble(etmidTerm.getText().toString());
                Double finals=Double.parseDouble(etfinals.getText().toString());
                String subject= spinsubject.getSelectedItem().toString();

                double result = midTerm+finals;
                double average = result / 2;
                etresult.setText(String.valueOf(average));

            }
        });
        setTitle("Grade Calculator");

    }

    }
