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

public class AlarmLoader
{

	public static ArrayList<MyAlarm> load(Context context)
	{
		File f=new File(context.getFilesDir(),"MyAlarm");

		if(!f.exists())
		{
			return new ArrayList<MyAlarm>();
		}
		try
		{
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			ArrayList<MyAlarm> list=(ArrayList<MyAlarm>)ois.readObject();
			ois.close();
			return list;
		}
		catch (IOException e){}
		catch (ClassNotFoundException e){}

		return new ArrayList<MyAlarm>();
	}

	public static void save(ArrayList<MyAlarm> list,Context context) throws IOException
	{
		File f=new File(context.getFilesDir(),"MyAlarm");

		if(!f.exists())
		{
			f.createNewFile();
		}

		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(list);
		oos.close();
	}
}
