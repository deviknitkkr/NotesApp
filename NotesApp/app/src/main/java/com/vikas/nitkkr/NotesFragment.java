package com.vikas.nitkkr;
import android.content.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v4.app.*;
import android.support.v7.widget.*;
import android.view.*;
import com.vikas.nitkkr.*;
import java.util.*;
import me.everything.android.ui.overscroll.*;
import me.everything.android.ui.overscroll.adapters.*;

public class NotesFragment extends Fragment
{
	RecyclerView recyclerview;
	static RecyclerViewAdapterNotes adapter;
	public String storage_path;
	static ArrayList<Notes> list;
	Context mContext;
	
	public NotesFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mContext=container.getContext();
		View v=inflater.inflate(R.layout.layout_fragment_notes,container,false);
		//startFabButton(v);
		startRecyclerView(v);
		return v;
	}
	
	public void startRecyclerView(View v)
	{
		list = NotesLoader.load(mContext);

		recyclerview = v.findViewById(R.id.recycler_view);
		//recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
		recyclerview.addItemDecoration(new SpaceItemDecoration(24, recyclerview));

		adapter = new RecyclerViewAdapterNotes(list,mContext);
		recyclerview.setAdapter(adapter);
	
		//ElasticityHelper.setUpOverScroll(recyclerview,ORIENTATION.VERTICAL);
		//new VerticalElasticityBounceEffect(new RecyclerViewElasticityAdapter(recyclerview));
	    OverScrollDecoratorHelper.setUpOverScroll(recyclerview,OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
		
//		new VerticalOverScrollBounceEffectDecorator(new RecyclerViewOverScrollDecorAdapter(recyclerview),
//		2f,
//        VerticalOverScrollBounceEffectDecorator.DEFAULT_TOUCH_DRAG_MOVE_RATIO_BCK,
//        VerticalOverScrollBounceEffectDecorator.DEFAULT_DECELERATE_FACTOR);
		
		
	}
	

	
}

