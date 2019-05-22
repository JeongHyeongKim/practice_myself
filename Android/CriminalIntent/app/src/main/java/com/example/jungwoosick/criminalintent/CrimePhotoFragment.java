package com.example.jungwoosick.criminalintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CrimePhotoFragment extends Fragment {
    private ImageView mImageView;

    public static CrimePhotoFragment newInstance(String fileName) {
        Bundle args = new Bundle();
        args.putString(CrimeFragment.CRIME_PHOTO, fileName);
        CrimePhotoFragment fragment = new CrimePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_crime_photo, container, false);

        Intent i = getActivity().getIntent();
        String fileName = i.getStringExtra(CrimeFragment.CRIME_PHOTO);

        mImageView = v.findViewById(R.id.crime_photo_imageview);

        Bitmap bitmap = PictureUtils.getScaledBitmap(fileName, getActivity());
        mImageView.setImageBitmap(bitmap);

        return v;
    }
}
