package com.mrfranza.backpack30.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.mrfranza.backpack30.DayContent;
import com.mrfranza.backpack30.R;
import com.mrfranza.backpack30.dayofweek;
import com.mrfranza.backpack30.weekArrayAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //Populate List
        //homeViewModel.PopulateList(root);

        ArrayList<dayofweek> myWeek = new ArrayList<>();


        myWeek.add(new dayofweek("L U N E D I'","@mipmap/ic_launcher_foreground"));
        myWeek.add(new dayofweek("M A R T E D I'","@mipmap/ic_launcher_foreground"));
        myWeek.add(new dayofweek("M E R C O L E D I'","@mipmap/ic_launcher_foreground"));
        myWeek.add(new dayofweek("G I O V E D I'","@mipmap/ic_launcher_foreground"));
        myWeek.add(new dayofweek("V E N E R D I'","@mipmap/ic_launcher_foreground"));
        myWeek.add(new dayofweek("S A B A T O","@mipmap/ic_launcher_foreground"));
        myWeek.add(new dayofweek("D O M E N I C A","@mipmap/ic_launcher_foreground"));

        final ArrayAdapter<dayofweek> adapter = new weekArrayAdapter(root.getContext(), 0, myWeek);

        @SuppressLint("CutPasteId") ListView listView = root.findViewById(R.id.Listweek2);
        listView.setAdapter(adapter);


        //Se clicco su un giorno della settimana
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myInt=new Intent(getContext(),DayContent.class);

                String g = Integer.toString(i+1);
                switch (g){
                    case "1":
                        myInt.putExtra("name_of_day_of_week","1");
                        break;
                    case "2":
                        myInt.putExtra("name_of_day_of_week","2");
                        break;
                    case "3":
                        myInt.putExtra("name_of_day_of_week","3");
                        break;
                    case "4":
                        myInt.putExtra("name_of_day_of_week","4");
                        break;
                    case "5":
                        myInt.putExtra("name_of_day_of_week","5");
                        break;
                    case "6":
                        myInt.putExtra("name_of_day_of_week","6");
                        break;
                    case "7":
                        myInt.putExtra("name_of_day_of_week","7");
                        break;
                }
                startActivity(myInt);
            }
        });

        return root;


    }


}