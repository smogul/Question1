package com.example.idcapture.components;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class BitmapCompressor {

    public byte[] CompressPic(Bitmap bmp)
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bytes = stream.toByteArray();

        return  bytes;

    }

    public  Bitmap DecompressPic(byte[] compressedPic)
    {
        Bitmap bmp = BitmapFactory.decodeByteArray(compressedPic,0,compressedPic.length);
        return  bmp;
    }

}
