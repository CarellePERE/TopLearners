package com.example.toplearners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.toplearners.Adapter.ViewPagerAdapter;
import com.example.toplearners.Fragment.TopLearnersFragment;
import com.example.toplearners.Fragment.TopSkillFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class Leaderboard extends AppCompatActivity {

    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);


        TabLayout tabs = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.view_pager);
        Button Submit = findViewById(R.id.btn_submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Leaderboard.this, SubmitActivity.class);
                startActivity(intent);
            }
        });

        //new SectionsPagerAdapter(this, getSupportFragmentManager())
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        //Add fragment
        mViewPagerAdapter.addFragment(new TopLearnersFragment(), " Learners Leaders");
        mViewPagerAdapter.addFragment(new TopSkillFragment(), " Skills Leaders");

        viewPager.setAdapter(mViewPagerAdapter);

        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setText(R.string.tab_text_1);
        tabs.getTabAt(1).setText(R.string.tab_text_2);


    }
}