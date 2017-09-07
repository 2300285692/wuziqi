package com.example.wuziqi;

import com.example.wuziqi.R;
import com.example.wuziqi.renjiduizhan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i0=new Intent();
				i0.setClass(getBaseContext(), renjiduizhan1.class);
				startActivity(i0);
			}
      
        });
      
      Button button1=(Button) findViewById(R.id.button2);
        button1.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i0=new Intent();
				i0.setClass(getBaseContext(), renrenduizhan1.class);
				startActivity(i0);
			}
      
        });
    }
    
}
