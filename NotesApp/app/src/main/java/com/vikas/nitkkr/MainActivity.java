package com.vikas.nitkkr;

import android.os.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import java.io.*;
import java.util.*;
import android.content.*;
import android.app.*;
import android.graphics.drawable.*;
import android.graphics.*;
import android.support.v4.view.*;
import me.everything.android.ui.overscroll.*;

public class MainActivity extends AppCompatActivity
{
	Toolbar toolbar;
	ViewPager view_pager;
	FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

		
		//startRecyclerView();
        startFabButton();
		startViewPager();

    }

	public void startFabButton()

	{
		fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view)
				{
			        if(view_pager.getCurrentItem()==0)
					{
						Intent i=new Intent(getApplicationContext(), EditNotesActivity.class);
						startActivity(i);
					}
					
				}
			});
	}
	
	public void startViewPager()
	{
	    view_pager=findViewById(R.id.viewpager);
		view_pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),MainActivity.this));
		//OverScrollDecoratorHelper.setUpOverScroll(view_pager);
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(view_pager);
		
		view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

				@Override
				public void onPageScrolled(int p1, float p2, int p3)
				{
					// TODO: Implement this method
				}

				@Override
				public void onPageSelected(int p1)
				{
					if(p1==0)
					{
						fab.setVisibility(View.VISIBLE);
					}
					else if(p1==1)
					{
						fab.setVisibility(View.VISIBLE);
					}
					else
					{
						fab.setVisibility(View.GONE);
					}
				}

				@Override
				public void onPageScrollStateChanged(int p1)
				{
					// TODO: Implement this method
				}
			});
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
	// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
		}

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
		{

		return true;
	   }

        return super.onOptionsItemSelected(item);
		}


	}
