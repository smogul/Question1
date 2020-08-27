package com.example.idcapture;

import androidx.appcompat.app.AppCompatActivity;
import  android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.idcapture.components.BitmapCompressor;
import com.example.idcapture.constants.Constant;
import com.example.identitydocumentsdk.SybrinSmartIdentification;
import com.example.identitydocumentsdk.SybrinSmartIdentificationInterface;
import com.example.identitydocumentsdk.models.IDModel;
import com.example.identitydocumentsdk.utils.DocTypeProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
this.setTitle("Sybrin Systems");
        Constant constant = new Constant();
        final  String license = constant.getLicense();
        final BitmapCompressor imageCompressor = new BitmapCompressor();
        Button btnIdCard = findViewById(R.id.btnIdCard);
        Button btnIdBook = findViewById(R.id.btnIdBook);
        Button btnPassport = findViewById(R.id.btnPassport);
        final Button btnQrCode = findViewById(R.id.btnQrCode);

        final TextView txtOut = findViewById(R.id.output);

        btnIdBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SybrinSmartIdentification ssi = SybrinSmartIdentification.getInstance(MainActivity.this);
                ssi.setListener(new SybrinSmartIdentificationInterface() {
                    @Override
                    public void onDataReturned(IDModel idModel) {
                       //  txtOut.setText(idModel.toString());
                        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

                        intent.putExtra("CountryOfBirth",idModel.CountryOfBirth);
                        intent.putExtra("DateOfBirth",idModel.DateOfBirth);
                        intent.putExtra("DateOfIssue",idModel.DateOfIssue);
                        intent.putExtra("DocumentNumber",idModel.DocumentNumber);
                        intent.putExtra("DocumentType",idModel.DocumentType);
                        intent.putExtra("GivenNames",idModel.GivenNames);
                        intent.putExtra("IDNumber",idModel.IDNumber);
                        intent.putExtra("Names",idModel.Names);
                        intent.putExtra("Nationality",idModel.Nationality);
                        intent.putExtra("ResidenceStatus",idModel.ResidenceStatus);
                        intent.putExtra("Sex",idModel.Sex);
                        intent.putExtra("Surname",idModel.Surname);

                        //first compress bitmap
                        byte[] compressCroppedDocumentImage = imageCompressor.CompressPic(idModel.CroppedDocumentImage);
                        byte[] compressDocumentImage = imageCompressor.CompressPic(idModel.DocumentImage);
                        byte[] compressPortraitImage = imageCompressor.CompressPic(idModel.PortraitImage);

                        intent.putExtra("CroppedDocumentImage",compressCroppedDocumentImage);
                        intent.putExtra("DocumentImage",compressDocumentImage);
                        intent.putExtra("PortraitImage",compressPortraitImage);

                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(String s) {
                        txtOut.setText(s);
                    }
                });
                ssi.startSmartIdentification(license, DocTypeProvider.GreenBookID,"South Africa");


            }
        });

        btnIdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SybrinSmartIdentification ssi = SybrinSmartIdentification.getInstance(MainActivity.this);
                ssi.setListener(new SybrinSmartIdentificationInterface() {
                    @Override
                    public void onDataReturned(IDModel idModel) {
                        //txtOut.setText(idModel.);
                        Intent intent = new Intent(MainActivity.this,IDCardActivity.class);
                        intent.putExtra("CountryOfBirth",idModel.CountryOfBirth);
                        intent.putExtra("DateOfBirth",idModel.DateOfBirth);
                        intent.putExtra("DateOfIssue",idModel.DateOfIssue);
                        intent.putExtra("DocumentNumber",idModel.DocumentNumber);
                        intent.putExtra("DocumentType",idModel.DocumentType);
                        intent.putExtra("GivenNames",idModel.GivenNames);
                        intent.putExtra("IDNumber",idModel.IDNumber);
                        intent.putExtra("Names",idModel.Names);
                        intent.putExtra("Nationality",idModel.Nationality);
                        intent.putExtra("ResidenceStatus",idModel.ResidenceStatus);
                        intent.putExtra("Sex",idModel.Sex);
                        intent.putExtra("Surname",idModel.Surname);

                        //first compress bitmap
                        byte[] compressCroppedDocumentImage = imageCompressor.CompressPic(idModel.CroppedDocumentImage);
                        byte[] compressDocumentImage = imageCompressor.CompressPic(idModel.DocumentImage);
                        byte[] compressPortraitImage = imageCompressor.CompressPic(idModel.PortraitImage);

                        intent.putExtra("CroppedDocumentImage",compressCroppedDocumentImage);
                        intent.putExtra("DocumentImage",compressDocumentImage);
                        intent.putExtra("PortraitImage",compressPortraitImage);

                       startActivity(intent);

                    }

                    @Override
                    public void onFailure(String s) {
                        txtOut.setText(s);
                    }
                });
                ssi.startSmartIdentification(license, DocTypeProvider.IDCard,"South Africa");


            }
        });

        btnPassport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SybrinSmartIdentification ssi = SybrinSmartIdentification.getInstance(MainActivity.this);
                ssi.setListener(new SybrinSmartIdentificationInterface() {
                    @Override
                    public void onDataReturned(IDModel idModel) {
                        //txtOut.setText(idModel.);
                        Intent intent = new Intent(MainActivity.this,PassportActivity.class);
                        intent.putExtra("CountryOfBirth",idModel.CountryOfBirth);
                        intent.putExtra("DateOfBirth",idModel.DateOfBirth);
                        intent.putExtra("DateOfIssue",idModel.DateOfIssue);
                        intent.putExtra("DocumentNumber",idModel.DocumentNumber);
                        intent.putExtra("DocumentType",idModel.DocumentType);
                        intent.putExtra("GivenNames",idModel.GivenNames);
                        intent.putExtra("IDNumber",idModel.IDNumber);
                        intent.putExtra("Names",idModel.Names);
                        intent.putExtra("Nationality",idModel.Nationality);
                        intent.putExtra("ResidenceStatus",idModel.ResidenceStatus);
                        intent.putExtra("Sex",idModel.Sex);
                        intent.putExtra("Surname",idModel.Surname);

                        //first compress bitmap
                        byte[] compressCroppedDocumentImage = imageCompressor.CompressPic(idModel.CroppedDocumentImage);
                        byte[] compressDocumentImage = imageCompressor.CompressPic(idModel.DocumentImage);
                        byte[] compressPortraitImage = imageCompressor.CompressPic(idModel.PortraitImage);

                        intent.putExtra("CroppedDocumentImage",compressCroppedDocumentImage);
                        intent.putExtra("DocumentImage",compressDocumentImage);
                        intent.putExtra("PortraitImage",compressPortraitImage);

                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(String s) {
                        txtOut.setText(s);
                    }
                });
                ssi.startSmartIdentification(license, DocTypeProvider.Passport,"South Africa");

                btnQrCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final SybrinSmartIdentification ssi = SybrinSmartIdentification.getInstance(MainActivity.this);
                        ssi.setListener(new SybrinSmartIdentificationInterface() {
                            @Override
                            public void onDataReturned(IDModel idModel) {
                                //txtOut.setText(idModel.);
                                Intent intent = new Intent(MainActivity.this,QRActivity.class);
                                intent.putExtra("CountryOfBirth",idModel.CountryOfBirth);
                                intent.putExtra("DateOfBirth",idModel.DateOfBirth);
                                intent.putExtra("DateOfIssue",idModel.DateOfIssue);
                                intent.putExtra("DocumentNumber",idModel.DocumentNumber);
                                intent.putExtra("DocumentType",idModel.DocumentType);
                                intent.putExtra("GivenNames",idModel.GivenNames);
                                intent.putExtra("IDNumber",idModel.IDNumber);
                                intent.putExtra("Names",idModel.Names);
                                intent.putExtra("Nationality",idModel.Nationality);
                                intent.putExtra("ResidenceStatus",idModel.ResidenceStatus);
                                intent.putExtra("Sex",idModel.Sex);
                                intent.putExtra("Surname",idModel.Surname);

                                //first compress bitmap
                                byte[] compressCroppedDocumentImage = imageCompressor.CompressPic(idModel.CroppedDocumentImage);
                                byte[] compressDocumentImage = imageCompressor.CompressPic(idModel.DocumentImage);
                                byte[] compressPortraitImage = imageCompressor.CompressPic(idModel.PortraitImage);

                                intent.putExtra("CroppedDocumentImage",compressCroppedDocumentImage);
                                intent.putExtra("DocumentImage",compressDocumentImage);
                                intent.putExtra("PortraitImage",compressPortraitImage);

                                startActivity(intent);

                            }

                            @Override
                            public void onFailure(String s) {
                                txtOut.setText(s);
                            }
                        });
                        ssi.startSmartIdentification(license, DocTypeProvider.Passport,"South Africa");


                    }
                });


            }
        });

        btnQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SybrinSmartIdentification ssi = SybrinSmartIdentification.getInstance(MainActivity.this);
                ssi.setListener(new SybrinSmartIdentificationInterface() {
                    @Override
                    public void onDataReturned(IDModel idModel) {
                        //  txtOut.setText(idModel.toString());
                        Intent intent = new Intent(MainActivity.this, QRActivity.class);

                        intent.putExtra("DocumentType",idModel.DocumentType);
                        intent.putExtra("QRCodeString",idModel.QRCodeString);

                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(String s) {
                        txtOut.setText(s);
                    }
                });
                ssi.startSmartIdentification(license, DocTypeProvider.QRCode,"South Africa");


            }
        });


    }
}