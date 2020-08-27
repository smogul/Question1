package com.example.idcapture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.idcapture.components.BitmapCompressor;

public class QRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r);
        this.setTitle("QR Code");
        //declare
        Button btnProceed = findViewById(R.id.btnProceed);
        Intent intent = getIntent();
        TextView txtCodeString = findViewById(R.id.txtQRCodeString);
        TextView txtDocType = findViewById(R.id.txtDocumentType);

        //instantiate
        String CodeString = intent.getStringExtra("QRCodeString");
        String DocumentType = intent.getStringExtra("DocumentType");

        //bind
        txtCodeString.setText(CodeString);
        txtDocType.setText(DocumentType);

        btnProceed.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}