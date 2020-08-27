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

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.setTitle("Green Book ID");

        final BitmapCompressor imageCompressor = new BitmapCompressor();
        //declare
        Button btnProceed = findViewById(R.id.btnProceed);
        Intent intent = getIntent();
        TextView txtCountryOfBirth = findViewById(R.id.txtCountryOfBirth);
        TextView txtDateOfBirth = findViewById(R.id.txtDateOfBirth);
        TextView txtDateOfIssue = findViewById(R.id.txtDateOfIssue);
        TextView txtDocumentNumber= findViewById(R.id.txtDocNumber);
        TextView txtDocumentType = findViewById(R.id.txtDocType);
        TextView txtGivenNames = findViewById(R.id.txtGivenNames);
        TextView txtNationality = findViewById(R.id.txtNationality);
        TextView txtResidenceState = findViewById(R.id.txtResStatus);
        TextView txtIDNumber = findViewById(R.id.txtIdNumber);
        TextView txtSex = findViewById(R.id.txtGender);
        TextView txtNames = findViewById(R.id.txtNames);
        TextView txtSurname = findViewById(R.id.txtSurname);
        ImageView imgCroppedDocumentImage = findViewById(R.id.imageViewCroppedDocumentImage);
        ImageView imgDocumentImage = findViewById(R.id.imageViewDocumentImage);
        ImageView imgPortraitImage = findViewById(R.id.imageViewPortraitImage);


        //instantiate
        String CountryOfBirth = intent.getStringExtra("CountryOfBirth");
        String DateOfBirth = intent.getStringExtra("DateOfBirth");
        String DateOfIssue = intent.getStringExtra("DateOfIssue");
        String DocumentNumber = intent.getStringExtra("DocumentNumber");
        String DocumentType = intent.getStringExtra("DocumentType");
        String GivenNames = intent.getStringExtra("GivenNames");
        String Sex = intent.getStringExtra("Sex");
        String Surname = intent.getStringExtra("Surname");
        String IdNumber = intent.getStringExtra("IDNumber");
        byte[] CroppedDocumentImage = intent.getByteArrayExtra("CroppedDocumentImage");
        byte[] DocumentImage = intent.getByteArrayExtra("DocumentImage");
        byte[] PortraitImage = intent.getByteArrayExtra("PortraitImage");
        String Nationality = intent.getStringExtra("Nationality");
        String ResidenceStatus = intent.getStringExtra("ResidenceStatus");
        String Names = intent.getStringExtra("Names");
        Bitmap croppedDocumentImageConverted = imageCompressor.DecompressPic(CroppedDocumentImage);
        Bitmap documentImageConverted = imageCompressor.DecompressPic(DocumentImage);
        Bitmap portraitImageConverted = imageCompressor.DecompressPic(PortraitImage);

        //bind
        txtCountryOfBirth.setText(CountryOfBirth);
        txtDateOfBirth.setText(DateOfBirth);
        txtDateOfIssue.setText(DateOfIssue);
        txtDocumentNumber.setText(DocumentNumber);
        txtDocumentType.setText(DocumentType);
        txtGivenNames.setText(GivenNames);
        txtSex.setText(Sex);
        txtSurname.setText(Surname);
        imgCroppedDocumentImage.setImageBitmap(croppedDocumentImageConverted);
        imgDocumentImage.setImageBitmap(documentImageConverted);
        imgPortraitImage.setImageBitmap(portraitImageConverted);
        txtNationality.setText(Nationality);
        txtResidenceState.setText(ResidenceStatus);
        txtIDNumber.setText(IdNumber);
        txtNames.setText(Names);

        btnProceed.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


}