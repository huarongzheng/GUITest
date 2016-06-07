package com.example.guitest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ViewSwitcher;
import android.widget.TextSwitcher;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity
    extends Activity 
    implements OnClickListener
    ,          ViewSwitcher.ViewFactory {
    static final private int GET_CODE = 0;
	private boolean      m_bImageVisible;
	private byte         m_nCounter;
	private ToggleButton m_button1; 
	private ImageButton  m_button2; 
	private Button       m_button3; 
	private Button       m_button4; 
	private ImageView    m_view1;
	private TextView     m_view2;
	private WebView      m_webview1;
	private TextSwitcher m_switcher;
	
	private Button2_OnClickListener m_button2Listener = new Button2_OnClickListener();
    
	class Button2_OnClickListener implements OnClickListener 
	{
		public void onClick(View v)
		{ 	
			m_bImageVisible = !m_bImageVisible;
			if (m_bImageVisible)
			{
				m_view1.setVisibility(View.VISIBLE); 
			}
			else
			{
				m_view1.setVisibility(View.INVISIBLE);
			}
			
		} 
	}
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        m_button1  = (ToggleButton) findViewById(R.id.toggleButton1); 
        m_button2  = (ImageButton)  findViewById(R.id.imageButton1); 
        m_button3  = (Button)       findViewById(R.id.button1);
        m_button4  = (Button)       findViewById(R.id.button2);
        m_view1    = (ImageView)    findViewById(R.id.imageView1);
        m_view2    = (TextView)     findViewById(R.id.textView1);
		m_switcher = (TextSwitcher) findViewById(R.id.switcher1); 

		m_button1.setOnClickListener(this);
		m_button2.setOnClickListener(m_button2Listener);
		m_button3.setOnClickListener(this);
		m_button4.setOnClickListener(this);
		
        m_view2.setTextSize(20);
        m_view2.setTextColor(0xFFFF0000);
        
        m_webview1 = (WebView) findViewById(R.id.wv1); 
        String mimeType = "text";
		String encoding = "utf-8";
		m_webview1.loadData("<a href='x'>Hello World! - 1</a>", mimeType, encoding);
		
		/*		m_switcher.setFactory(this); 
		Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in); 
		Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out); 
		m_switcher.setInAnimation(in); 
		m_switcher.setOutAnimation(out);
		m_switcher.setText(String.valueOf(m_nCounter));*/
    }

    /*Another way of implementing View.onClickListener*/
    @Override
    public void onClick(View v) {
    	System.out.println("onClick()"); 
		int nColor;
		Intent intent;
    	switch(v.getId())
    	{
    		case R.id.button1: 
    			nColor=0xFF000000 | (0xFF<<((m_nCounter%3)*8)); // toggle through B->G->R
    			m_view2.setBackgroundColor(nColor);  
    			m_nCounter++;
    			break;
    		case R.id.button2: 
    			intent = new Intent(MainActivity.this, CanvasActivity.class);
    			startActivity(intent);
    			finish();
    			break;
    		case R.id.toggleButton1: 
    			intent = new Intent(MainActivity.this, GeneratedActivity.class);
    			startActivityForResult (intent, GET_CODE);
    			break;
    		default: 
    			System.out.println("other"); 
    			break; 
    	} 
    }
    
    @Override 
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
    	if (requestCode == GET_CODE) { 
    		String text=""; 
    		if (resultCode == RESULT_CANCELED) { 
    			text += ("(cancelled)"); 
    		} else { 
    			text += ("(okay "); 
    			text += (Integer.toString(resultCode)); 
    			text += (") "); 
    			if (data != null) { 
        			text += ("Click on item"); 
    				text += (data.getAction()); 
    			} 
    		} 
    		text += ("\n"); 
    		m_view2.setText(text);
    	} 
    }
    
	@Override
	public View makeView() {/*
        TextView t = new TextView(this); 
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL); 
        t.setTextSize(36); */
		return null;
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
