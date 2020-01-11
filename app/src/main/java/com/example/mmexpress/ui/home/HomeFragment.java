package com.example.mmexpress.ui.home;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.Adapter.PopsearchAdapter;
import com.example.mmexpress.Adapter.RouteAdapter;
import com.example.mmexpress.Model.Express;
import com.example.mmexpress.Model.Popular;
import com.example.mmexpress.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    RecyclerView popular_routelist,routelist;
    List<Popular> poproutes;
    List<Express> expresseslist;
    PopsearchAdapter popsearchAdapter;
    RouteAdapter routeAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //for collapsing toolbar
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("");
                    //icon_toolbar.setVisibility(View.VISIBLE);
                    collapsingToolbarLayout.setExpandedTitleMarginBottom(5);
                    isShow = true;
                } else if (isShow) {
                    //icon_toolbar.setVisibility(View.GONE);
                    collapsingToolbarLayout.setTitle("");//careful there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        ConstraintLayout constraintLayout=(ConstraintLayout)view.findViewById(R.id.route_inputconstr);
        constraintLayout.getLayoutParams().height=height/4;
        poproutes=new ArrayList<>();
        expresseslist=new ArrayList<>();
        popular_routelist=(RecyclerView)view.findViewById(R.id.popular_list);
        routelist=(RecyclerView)view.findViewById(R.id.place_list);
        setupdata();
        popsearchAdapter=new PopsearchAdapter(getContext(),poproutes);
        routeAdapter=new RouteAdapter(getContext(),expresseslist);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        routelist.setLayoutManager(new LinearLayoutManager(getContext()));

        routelist.setAdapter(routeAdapter);
        popular_routelist.setLayoutManager(layoutManager);
        popular_routelist.setAdapter(popsearchAdapter);

    }
    private void setupdata(){
        poproutes.add(new Popular("Yangon","Mandalay",R.drawable.car1));
        poproutes.add(new Popular("MyitKyinar","Pathein",R.drawable.car2));
        poproutes.add(new Popular("Bago","Yangon",R.drawable.car1));
        poproutes.add(new Popular("Kyaik Htoo","Mandalay",R.drawable.car2));
        poproutes.add(new Popular("Yangon","Kyaik Htoo",R.drawable.car1));
        poproutes.add(new Popular("Yangon","Maw La Myaing",R.drawable.car2));
        //for express
        expresseslist.add(new Express("JJ","Special","jan 01 2020","11:45","8000",R.drawable.car1));
        expresseslist.add(new Express("Shwe Nan Daw","Special","jan 01 2020","11:45","9000",R.drawable.car2));
        expresseslist.add(new Express("E Lite","Standard","jan 01 2020","11:45","8000",R.drawable.car1));
        expresseslist.add(new Express("Daw Win","Business","jan 01 2020","11:45","8000",R.drawable.car2));
        expresseslist.add(new Express("JJ","Special","jan 01 2020","11:45","8000",R.drawable.car1));
    }
}