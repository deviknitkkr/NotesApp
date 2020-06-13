package com.vikas.nitkkr;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v7.widget.*;
import android.view.*;
import java.util.*;
import android.widget.*;
import me.everything.android.ui.overscroll.*;

public class AlarmFragment extends Fragment
{
	RecyclerView recyclerview;
	static RecyclerViewAdapterAlarm adapter;
	public String storage_path;
	static ArrayList<MyAlarm> list;
	Context mContext;

	public AlarmFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mContext=container.getContext();
		View v=inflater.inflate(R.layout.layout_fragment_alarm,container,false);
		//startFabButton(v);
		RelativeLayout root_view=v.findViewById(R.id.relative);
		OverScrollDecoratorHelper.setUpStaticOverScroll(v,OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
		startRecyclerView(v);
		return v;
	}

	public void startRecyclerView(View v)
	{
		list = AlarmLoader.load(mContext);

		if(list.size()==0)
		{
			list.add(new MyAlarm("8:30pm",false,"Sun,mon,Tue"));
			list.add(new MyAlarm("8:50pm",true,"Sun,mon,Tue"));
			list.add(new MyAlarm("9:30pm",false,"Sun,mon,Tue,Wed,Thu,Fri,Sat"));
			list.add(new MyAlarm("8:50pm",true,"Sun,mon,Tue,Fri,Sat"));
			list.add(new MyAlarm("8:30pm",false,"Sun,mon,Tue"));
			list.add(new MyAlarm("8:50pm",true,"Sun,mon,Tue"));
			list.add(new MyAlarm("9:30pm",false,"Sun,mon,Tue,Wed,Thu,Fri,Sat"));
			list.add(new MyAlarm("8:50pm",true,"Sun,mon,Tue,Fri,Sat"));
		}
		recyclerview = v.findViewById(R.id.recycler_view);
		//recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
		recyclerview.addItemDecoration(new SpaceItemDecoration(24, recyclerview));

		adapter = new RecyclerViewAdapterAlarm(list,mContext);
		recyclerview.setAdapter(adapter);
      //  ElasticityHelper.setUpOverScroll(recyclerview,ORIENTATION.VERTICAL);
	}



}
