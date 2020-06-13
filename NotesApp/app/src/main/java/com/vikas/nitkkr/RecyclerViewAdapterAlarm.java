package com.vikas.nitkkr;

import android.content.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import java.util.*;
import android.graphics.*;
import java.io.*;
import android.support.v7.app.*;
//import android.support.design.widget.*;

public class RecyclerViewAdapterAlarm extends RecyclerView.Adapter<RecyclerViewAdapterAlarm.MyViewHolder>
{

	private ArrayList<MyAlarm> mynotes;
    Context context;

	public RecyclerViewAdapterAlarm(ArrayList<MyAlarm> mynotes, Context context)
	{
		this.mynotes = mynotes;
		this.context = context;
	}

	@Override
	public RecyclerViewAdapterAlarm.MyViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		return new MyViewHolder(LayoutInflater.from(p1.getContext()).inflate(R.layout.row_item_alarm, null));
	}

	@Override
	public void onBindViewHolder(RecyclerViewAdapterAlarm.MyViewHolder p1, int p2)
	{
		MyAlarm temp=mynotes.get(p2);
		p1.alarm_time.setText(temp.time.toString());
		p1.alarm_days.setText(temp.days.toString());
		p1.alarm_status.setActivated(temp.enabled);
		p1.relative_layout.setBackgroundColor(MyColors.getRandomColor());
		p1.setIsRecyclable(true);

	}

	@Override
	public int getItemCount()
	{
		return mynotes.size();
	}


	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		public TextView alarm_time;
		public TextView alarm_days;
		public Switch alarm_status;
        public RelativeLayout relative_layout;
		public MyViewHolder(final View v)
		{
			super(v);
			alarm_time = v.findViewById(R.id.alarm_time);
			alarm_days= v.findViewById(R.id.alarm_days);
			alarm_status= v.findViewById(R.id.alarm_status);
			relative_layout = v.findViewById(R.id.relative_layout);

//			v.setOnLongClickListener(new View.OnLongClickListener(){
//
//					@Override
//					public boolean onLongClick(View p1)
//					{
//						AlertDialog.Builder bld = new AlertDialog.Builder(context);
//
//						bld.setTitle("Delete");
//						bld.setMessage("Are you sure want to delete "+notes_title.getText());
//						bld.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//
//								@Override
//								public void onClick(DialogInterface dialog, int which)
//								{
//
//									NotesFragment.list.remove(getPosition());
//									NotesFragment.adapter.notifyDataSetChanged();
//									Toast.makeText(context, notes_title.getText().toString() + " deleted", Toast.LENGTH_SHORT).show();
//									try
//									{
//										NotesLoader.save(NotesFragment.list, context);
//									}
//									catch (IOException e)
//									{}
//								}
//							});
//						bld.setNegativeButton("No", new DialogInterface.OnClickListener() {
//
//								@Override
//								public void onClick(DialogInterface dialog, int which)
//								{
//
//								}
//							});
//
//						bld.create().show();
//
//						return true;
//					}
//				});

//			v.setOnClickListener(new View.OnClickListener(){
//
//					@Override
//					public void onClick(View p1)
//					{
//						Intent i=new Intent(context, EditNotesActivity.class);
//						i.putExtra("Title", notes_title.getText().toString());
//						i.putExtra("Description", notes_description.getText().toString());
//						NotesFragment.list.remove(getPosition());
//						NotesFragment.adapter.notifyDataSetChanged();
//						context.startActivity(i);
//					}
//				});

		}
	}

	public void showAlert(final int position)
	{

	}

}
