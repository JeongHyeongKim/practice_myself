package com.example.jungwoosick.criminalintent;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimePhotoActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        String fileName = getIntent().getStringExtra(CrimeFragment.CRIME_PHOTO);
        return CrimePhotoFragment.newInstance(fileName);
    }
}
