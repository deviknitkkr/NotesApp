package com.vikas.nitkkr;

import android.os.*;
import java.io.*;
import java.util.*;
import android.support.design.widget.*;
import android.widget.*;
import android.content.*;
import android.support.v4.app.*;
import android.*;
import android.app.*;
import android.widget.Magnifier.*;
import android.support.v7.app.*;

public class NotesLoader
{
	
	public static ArrayList<Notes> load(Context context)
	{
		File f=new File(context.getFilesDir(),"Notes");
	
		if(!f.exists())
		{
			return new ArrayList<Notes>();
		}
		try
		{
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			ArrayList<Notes> list=(ArrayList<Notes>)ois.readObject();
			ois.close();
			return list;
		}
		catch (IOException e){}
		catch (ClassNotFoundException e){}
		
		return new ArrayList<Notes>();
	}
	
	public static void save(ArrayList<Notes> list,Context context) throws IOException
	{
	   File f=new File(context.getFilesDir(),"Notes");
		
		if(!f.exists())
		{
			f.createNewFile();
		}
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(list);
		oos.close();
	}
}
