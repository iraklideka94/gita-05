package com.example.homework_5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
EditText edtxt,edtxt2;
Button btn;
String s1, s2;
ImageView imgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt = findViewById(R.id.editTextPhone);
        edtxt2 =findViewById(R.id.editTextTextPersonName);
        btn = findViewById(R.id.button);
        imgBtn = findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = edtxt.getText().toString();
                s2 = edtxt2.getText().toString();
                Intent int1 = new Intent(MainActivity.this,MainActivity2.class);
                int1.putExtra("number", s1);
                int1.putExtra("message",s2);
                startActivity(int1);
            }
        });
    }

    public void takephoto(View view) {
        Intent int2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(int2,5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap a;
        a = (Bitmap) data.getExtras().get("data");
        imgBtn.setImageBitmap(a);
    }
}