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

public class RecyclerViewAdapterNotes extends RecyclerView.Adapter<RecyclerViewAdapterNotes.MyViewHolder>
{

	private ArrayList<Notes> mynotes;
    Context context;

	public RecyclerViewAdapterNotes(ArrayList<Notes> mynotes, Context context)
	{
		this.mynotes = mynotes;
		this.context = context;
	}

	@Override
	public RecyclerViewAdapterNotes.MyViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		return new MyViewHolder(LayoutInflater.from(p1.getContext()).inflate(R.layout.row_item, null));
	}

	@Override
	public void onBindViewHolder(RecyclerViewAdapterNotes.MyViewHolder p1, int p2)
	{
		Notes temp=mynotes.get(p2);
		p1.notes_title.setText(temp.notes_title.toString());
		p1.notes_time.setText(temp.notes_time.toString());
		p1.notes_description.setText(temp.notes_description.toString());
		p1.linear_layout.setBackgroundColor(temp.notes_color);
		p1.setIsRecyclable(true);

	}

	@Override
	public int getItemCount()
	{
		return mynotes.size();
	}


	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		public TextView notes_title;
		public TextView notes_time;
		public TextView notes_description;
        public LinearLayout linear_layout;
		public CardView cardview;

		public MyViewHolder(final View v)
		{
			super(v);
			notes_title = v.findViewById(R.id.notes_title);
			notes_time = v.findViewById(R.id.notes_time);
			notes_description = v.findViewById(R.id.notes_description);
			linear_layout = v.findViewById(R.id.linear_layout);
			cardview=v.findViewById(R.id.cardview);

			
			v.setOnLongClickListener(new View.OnLongClickListener(){

					@Override
					public boolean onLongClick(View p1)
					{
						AlertDialog.Builder bld = new AlertDialog.Builder(context);

						bld.setTitle("Delete");
						bld.setMessage("Are you sure want to delete "+notes_title.getText());
						bld.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which)
								{

									NotesFragment.list.remove(getPosition());
									NotesFragment.adapter.notifyDataSetChanged();
									Toast.makeText(context, notes_title.getText().toString() + " deleted", Toast.LENGTH_SHORT).show();
									try
									{
										NotesLoader.save(NotesFragment.list, context);
									}
									catch (IOException e)
									{}
								}
							});
						bld.setNegativeButton("No", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which)
								{
									
								}
							});

						bld.create().show();

						return true;
					}
				});

			v.setOnClickListener(new View.OnClickListener(){

					@Override
					public void onClick(View p1)
					{
						Intent i=new Intent(context, EditNotesActivity.class);
						i.putExtra("Title", notes_title.getText().toString());
						i.putExtra("Description", notes_description.getText().toString());
						NotesFragment.list.remove(getPosition());
						NotesFragment.adapter.notifyDataSetChanged();
						context.startActivity(i);
					}
				});

		}
	}

	public void showAlert(final int position)
	{

	}

}
