package com.vikas.nitkkr;

import android.content.Context;
import android.support.v4.app.*;
import com.vikas.nitkkr.*;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Notes","Alarm","StopWatch"};
    private Context context;
    Fragment f1;
	Fragment f2;
	Fragment f3;
	

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        f1=new NotesFragment();
		f2=new AlarmFragment();
		f3=new StopwatchFragment();
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return f1;
			case 1:
				return f2;
			case 2:
				return f3;
		    
        }
        
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
