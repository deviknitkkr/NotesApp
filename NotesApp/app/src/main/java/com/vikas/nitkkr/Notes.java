package com.vikas.nitkkr;

import android.widget.*;
import java.io.*;

public class Notes implements Serializable
{
	public String notes_title;
	public String notes_time;
	public String notes_description;
    public int notes_color;

	public Notes(String notes_title, String notes_time, String notes_description, int notes_color)
	{
		this.notes_title = notes_title;
		this.notes_time = notes_time;
		this.notes_description = notes_description;
		this.notes_color = notes_color;
	}

}
