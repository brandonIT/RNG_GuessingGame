package com.example.game;

import java.util.Random;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class PageTwo extends ActionBarActivity {

	static int flagTwo = 0;
	static TextView tvRightWrongTwo;
	static EditText etUserGuessTwo;
	static int pTwo;
	static Random randoTwo = new Random();
	static int userGuessTwo;
	static String userGuessBufferTwo = "";
	static Button btEnd;
	static Button btSubmitTwo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);
        getRandomTwo();
        
        tvRightWrongTwo = (TextView)findViewById(R.id.textViewRightWrongTwo);
        etUserGuessTwo = (EditText)findViewById(R.id.editTextUserGuessTwo);
        btEnd = (Button)findViewById(R.id.buttonEnd);
        btSubmitTwo = (Button)findViewById(R.id.buttonSubmitTwo);
        btSubmitTwo.setEnabled(false);
        
        etUserGuessTwo.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

               if(s.toString().trim().length()==0){
                    btSubmitTwo.setEnabled(false);
                  } else {
                    btSubmitTwo.setEnabled(true);
                  }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
                // TODO Auto-generated method stub

            }

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
        });
        
        btEnd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        btSubmitTwo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				    	tvRightWrongTwo.setVisibility(v.VISIBLE);
				    	userGuessBufferTwo = etUserGuessTwo.getText().toString();
				    	userGuessTwo = Integer.parseInt(userGuessBufferTwo);
				    	guessCheck(v);
			}
		});

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public static void getRandomTwo()
    
    {
    	pTwo = randoTwo.nextInt((20 - 1) + 1) + 1;
    }
    public static void guessCheck(View v)
    {
    		if(userGuessTwo == pTwo)
    		{
    			tvRightWrongTwo.setText("Nice job! Tap the green checkmark, then tap the next button to move to the next round.");
    			btEnd.setVisibility(View.VISIBLE);
    			btSubmitTwo.setVisibility(View.INVISIBLE);
    		}
    		else
    		{
    			tvRightWrongTwo.setText("Not quite, try again");
    			etUserGuessTwo.setText("");
    		}
    }
}