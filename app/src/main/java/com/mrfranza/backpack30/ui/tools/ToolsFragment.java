package com.mrfranza.backpack30.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.mrfranza.backpack30.PrincipalMenu;
import com.mrfranza.backpack30.R;


public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        toolsViewModel = ViewModelProviders.of(this).get(ToolsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_tools, container, false);

        Button btnTest = root.findViewById(R.id.test_btn_notifics);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Toast toast = Toast.makeText(root.getContext(),"IT WORKS?",Toast.LENGTH_LONG);
                toast.show();
                PrincipalMenu.sendOnChannel1(v);
            }
        });

        return root;
    }
}