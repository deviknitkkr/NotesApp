package com.vikas.nitkkr;

import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v7.app.*;

import android.app.AlertDialog;

public class DebugActivity extends AppCompatActivity{

	String[] exceptionType = {
			"",
			"",
			"",
			"",
			""

	};

	String[] errMessage= new String[]{"","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
		Intent intent = getIntent();
		
		String errMsg = "";
		String madeErrMsg = "";
		if(intent != null){
			errMsg = intent.getStringExtra("error");

			String[] spilt = errMsg.split("\n");
			//errMsg = spilt[0];
			try {
				for (int j = 0; j < exceptionType.length; j++) {
					if (spilt[0].contains(exceptionType[j])) {
						madeErrMsg = errMessage[j];

						int addIndex = spilt[0].indexOf(exceptionType[j]) + exceptionType[j].length();

						madeErrMsg += spilt[0].substring(addIndex, spilt[0].length());
						break;

					}
				}

				if(madeErrMsg.isEmpty()) madeErrMsg = errMsg;
			}catch(Exception e){}

		}

        AlertDialog.Builder bld = new AlertDialog.Builder(this);

		bld.setTitle("An error occured");
		bld.setMessage( madeErrMsg );
		bld.setNeutralButton("End Application", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		bld.create().show();

    }
}
