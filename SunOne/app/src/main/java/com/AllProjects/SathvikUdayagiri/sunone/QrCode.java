package com.AllProjects.SathvikUdayagiri.sunone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class QrCode extends AppCompatActivity {
    ViewPager vp;
    TabLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        vp=findViewById(R.id.pager);
        tl=findViewById(R.id.tab);
        vp.setAdapter(new TabAdapter(getSupportFragmentManager()));
        tl.setupWithViewPager(vp);
    }
    class TabAdapter extends FragmentPagerAdapter {

        public TabAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ScanQrCode();
                case 1:
                    return new GenerateQrCode();


            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Scan";
                case 1:
                    return "Generate";
            }
            return super.getPageTitle(position);
        }
    }
}