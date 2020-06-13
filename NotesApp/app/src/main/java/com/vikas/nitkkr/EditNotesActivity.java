package com.vikas.nitkkr;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import java.io.*;
import android.widget.*;
import android.text.method.*;
import java.time.format.*;
import java.time.*;
import android.content.*;

public class EditNotesActivity extends AppCompatActivity
{
    android.support.v7.widget.Toolbar toolbar;
    EditText title ;
	EditText description;

	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editNotes);

		title = findViewById(R.id.title);
		description = findViewById(R.id.description);


		toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

		//toolbar.setNavigationIcon(R.drawable.ic_back_navigation);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					saveNotes();
					pressBack();
				}
			});


		title.setText(getIntent().getStringExtra("Title"));
		description.setText(getIntent().getStringExtra("Description"));
        //description.setMovementMethod(new ScrollingMovementMethod());

		String Tags[]={"To Do","Birthday","Meeting","List","Other"};
		ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Tags);
		Spinner s=findViewById(R.id.spinner);
		s.setAdapter(aa);

	}

	public void pressBack()
	{
		super.onBackPressed();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save)
		{
		    saveNotes();
			pressBack();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onBackPressed()
	{
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("Exit")
			.setMessage("Are you sure want to exit.\nIf you are editing old notes that will be deleted.")
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					pressBack();
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which)
				{

				}
			})
			.create().show();
	}


	public void saveNotes()
	{
		String notes_title=title.getText().toString();
		String notes_description=description.getText().toString();

		if (notes_title.trim().length() == 0 || notes_description.trim().length() == 0)
		{
			Toast.makeText(getApplicationContext(), "Please fill the required Fields", Toast.LENGTH_SHORT).show();		}
		else
		{

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			String time=dtf.format(now);
			NotesFragment.list.add(0, new Notes(notes_title, time, notes_description, MyColors.getRandomColor()));
			Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
			NotesFragment.adapter.notifyDataSetChanged();

			try
			{
				NotesLoader.save(NotesFragment.list, getApplicationContext());
			}
			catch (IOException e)
			{}
		}
	}

}
