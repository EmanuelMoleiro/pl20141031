package com.example.plclicktester;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private View mNW;
	private View mNE;
	private View mSW;
	private View mSE;
	
	private OnClickListener mClickHandler; //interface
	private OnLongClickListener mLongClickHandler; //interface
	
	private void init(){
		mNW=findViewById (R.id.id_nw);
		mNE=findViewById (R.id.id_ne);
		mSW=findViewById (R.id.id_sw);
		mSE=findViewById (R.id.id_se);
		
		//anonymous inner type
		mClickHandler=new OnClickListener(){

			@Override
			public void onClick(View v) {
				viewResponds (v, "Click");
			}//onClick
		};//mClickHandler
		
		mLongClickHandler=new OnLongClickListener(){

			@Override
			public boolean onLongClick(View v) {
				viewResponds (v, "Long Click");
				return true; //o consumo do evento terminou
			}//onLongClick
		};//mLongClickHandler
		
		mNE.setOnClickListener (mClickHandler);
		mNW.setOnClickListener (mClickHandler);
		mSE.setOnClickListener (mClickHandler);
		mSW.setOnClickListener (mClickHandler);
		
		mNE.setOnLongClickListener (mLongClickHandler);
		mNW.setOnLongClickListener (mLongClickHandler);
		mSE.setOnLongClickListener (mLongClickHandler);
		mSW.setOnLongClickListener (mLongClickHandler);
		
	}//init
	
	private void viewResponds (View v, String s){
		int id=v.getId();
		
		String sPersonal="";
		
		switch (id){
			case R.id.id_ne:
				sPersonal="Upper right corner";
				break;
			case R.id.id_nw:
				sPersonal="Upper left corner";
				break;
			case R.id.id_se:
				sPersonal="Down right corner";
				break;
			case R.id.id_sw:
				sPersonal="Down left corner";
				break;
		}//switch
		
		s=s+" @ "+sPersonal;
		Toast t=Toast.makeText(this, s, Toast.LENGTH_SHORT);
		t.show();
	}//viewResponds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mod1);
        
        init ();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
