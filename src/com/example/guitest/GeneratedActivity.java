package com.example.guitest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GeneratedActivity extends Activity implements OnClickListener
{
	private GridView m_Grid;
	private int[] m_images = {R.drawable.ic_launcher,R.drawable.pink,R.drawable.translucent_background};
	
	class ImageAdapter extends BaseAdapter { 
		public ImageAdapter() { } 
		public View getView(int position, View convertView, ViewGroup parent) { 
			ImageView imageView; 
			if (convertView == null) { 
				imageView = new ImageView(GeneratedActivity.this); 
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); 
				imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
				imageView.setAdjustViewBounds(false);
				imageView.setPadding(8, 8, 8, 8);
			} else { 
				imageView = (ImageView) convertView; 
			} 
			imageView.setImageResource(m_images[position%(m_images.length)]); 
			return imageView; 
		}
		
		// this is to decide how many items on screen
		public final int getCount() { 
			return m_images.length*5;
		}
	
		public final Object getItem(int position) { 
			return m_images[position]%(m_images.length); 
		}
	
		public final long getItemId(int position) { 
			return position; 
		} 
	} 
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated);
        
        m_Grid = (GridView) findViewById(R.id.myGrid); 
        m_Grid.setAdapter(new ImageAdapter()); // 设置GridView后面的数据
        m_Grid.setOnItemClickListener(
        	new OnItemClickListener() {
        		@Override
        		public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
        			setResult(RESULT_OK, (new Intent()).setAction(String.valueOf(position))); 
        			finish(); 
        		}
        	}
        );
    }

    /*Another way of implementing View.onClickListener*/
    @Override
    public void onClick(View v) {
    	System.out.println("GeneratedActivity onClick()"); 
    	switch(v.getId())
    	{
    		default: 
    			System.out.println("other"); 
    			break; 
    	} 
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}