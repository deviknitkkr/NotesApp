package com.vikas.nitkkr;

import java.util.*;
import android.graphics.*;

public class MyColors
{
	static String[] colors
	={
		"#F06292","#CE93D8","#64B5F6","#4DD0E1"
		,"#81C784","#FFF176","#FFB74D","#FF8A65"
	};
		
	static int len=colors.length;
	static Random r=new Random();
	
	public static int getRandomColor()
	{
		return Color.parseColor(colors[r.nextInt(len)]);
	}
}
