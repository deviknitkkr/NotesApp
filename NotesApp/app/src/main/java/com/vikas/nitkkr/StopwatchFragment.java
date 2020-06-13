package com.vikas.nitkkr;
import android.support.v4.app.*;
import android.os.*;
import android.view.*;
import com.google.common.base.*;
import android.widget.*;
import me.everything.android.ui.overscroll.*;

public class StopwatchFragment extends Fragment
{
	Stopwatch s;
	public StopwatchFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v=inflater.inflate(R.layout.layout_fragment_stopwatch, container, false);
		
		ScrollView scrollview=v.findViewById(R.id.scrollview);
		OverScrollDecoratorHelper.setUpOverScroll(scrollview);
		final TextView time=v.findViewById(R.id.time);
		s = Stopwatch.createStarted();


		final Handler handler=new Handler(Looper.getMainLooper());
		handler.post(new Runnable(){

				@Override
				public void run()
				{
					
					time.setText(s.toString());
					handler.postDelayed(this,10);

				}
			});

		return v;
	}


}
