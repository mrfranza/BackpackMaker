package com.mrfranza.backpack30.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mrfranza.backpack30.MainActivity;
import com.mrfranza.backpack30.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        Button Orologiobtn = root.findViewById(R.id.orologios);
        if(MainActivity.GetTimeNotific() == ""){
            Orologiobtn.setText("APRI L'OROLOGIO");
        }else {
            Orologiobtn.setText(MainActivity.GetTimeNotific());
        }

        galleryViewModel.InitiateTimePicker(getContext(),Orologiobtn);


        return root;
    }
}