package com.example.sangjin_lee.typokeyboard;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    int width;
    int height;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        tv.setText("x=>"+width+",y=>"+height);

        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        apply = (Button) findViewById(R.id.apply);
        option1.setOnClickListener(optionOnClickListener);
        option2.setOnClickListener(optionOnClickListener);
        option3.setOnClickListener(optionOnClickListener);
        apply.setOnClickListener(OptionOnClickListener);
        option1.setChecked(true);


    }

    RadioButton.OnClickListener optionOnClickListener
            = new RadioButton.OnClickListener() {

        public void onClick(View v) {
            //Toast.makeText(
            //        MainActivity.this,
            //        "Option 1 : " + option1.isChecked() + "\n"
            //                + "Option 2 : " + option2.isChecked() + "\n"
            //                + "Option 3 : " + option3.isChecked(),
            //        Toast.LENGTH_SHORT).show();

        }

    };

    Button.OnClickListener OptionOnClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            if(option1.isChecked()) {
                Intent intent = new Intent(MainActivity.this,typoKeyboard.class);
                intent.putExtra("keyname", "qwerty");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Option 1 : apply", Toast.LENGTH_SHORT).show();
            }
            if(option2.isChecked())
                Toast.makeText(MainActivity.this, "Option 2 : apply", Toast.LENGTH_SHORT).show();
            if(option3.isChecked())
                Toast.makeText(MainActivity.this, "Option 3 : apply", Toast.LENGTH_SHORT).show();
        }
    };

}
