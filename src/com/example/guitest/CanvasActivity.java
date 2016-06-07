package com.example.guitest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CanvasActivity extends Activity implements OnClickListener
{
	class BasicViewDraw extends View {
		private Bitmap m_Bitmap3;
		
	    public BasicViewDraw(Context context) {  
	        super(context);
	        
	        m_Bitmap3 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888); 
	        drawIntoBitmap(m_Bitmap3); 
	        
	    }
	    
	    protected void drawIntoBitmap(Bitmap bm) {
	    	float x = bm.getWidth(); 
	    	float y = bm.getHeight(); 
	    	Canvas bmcanvas = new Canvas(bm); 
	    	Paint  bmpaint  = new Paint();
	    	
	        /* ���ñ��� */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	    	bmcanvas.drawColor(Color.GREEN);  

	        /* ȥ��� */  
	        bmpaint.setAntiAlias(true);  
	        /* ����paint����ɫ */  
	        bmpaint.setColor(Color.RED);  
	        /* ����paint�� style ΪSTROKE������ */  
	        bmpaint.setStyle(Paint.Style.STROKE);  
	        /* ����paint������� */  
	        bmpaint.setStrokeWidth(3);
	        bmpaint.setAlpha(0x80); 
	        /* ��һ������Բ�� */  
	        bmcanvas.drawCircle(x/2 /*x within the bmcanvas*/, y/2/*y within the bmcanvas*/, x/2, bmpaint);  
	    }
	    
	    @Override  
	    protected void onDraw(Canvas canvas) {  
	        super.onDraw(canvas);  
	        /* ���ñ���Ϊ��ɫ */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	        canvas.drawColor(Color.WHITE);  
	        Paint paint = new Paint();
	        
	        /* ȥ��� */  
	        paint.setAntiAlias(true);  
	        /* ����paint����ɫ */  
	        paint.setColor(Color.RED);  
	        /* ����paint�� style ΪSTROKE������ */  
	        paint.setStyle(Paint.Style.STROKE);  
	        /* ����paint������� */  
	        paint.setStrokeWidth(3);  
	        
	        /* draw a bitmap */
	        canvas.drawBitmap(m_Bitmap3, 0/*left on x*/, 800/*top on y*/, paint);
	        /* ��һ������Բ�� */  
	        canvas.drawCircle(40, 40, 30, paint);  
	        /* ��һ������������ */  
	        canvas.drawRect(10, 90, 70, 150, paint);  
	        /* ��һ�����ĳ����� */  
	        canvas.drawRect(10, 170, 70, 200, paint);  
	        /* ��һ��������Բ�� */  
	        RectF re = new RectF(10, 220, 70, 250);  
	        canvas.drawOval(re, paint);  
	        /* ��һ������������ */  
	        Path path = new Path();  
	        path.moveTo(10, 330);  
	        path.lineTo(70, 330);  
	        path.lineTo(40, 270);  
	        path.close();//�ǵ�Ҫclose  
	        canvas.drawPath(path, paint);  
	        /* ��һ���������� */  
	        Path path1 = new Path();  
	        path1.moveTo(10, 410);  
	        path1.lineTo(70, 410);
	        path1.lineTo(55, 350);  
	        path1.lineTo(25, 350);  
	        path1.close();  
	        canvas.drawPath(path1, paint);  
	  
	        
	        /* ����paint ��styleΪ FILL��ʵ�� */  
	        paint.setStyle(Paint.Style.FILL);  
	        /* ����paint����ɫ */  
	        paint.setColor(Color.BLUE|Color.RED);  
	        /* ��һ��ʵ��Բ */  
	        canvas.drawCircle(120, 40, 30, paint);  
	        /* ��һ��ʵ�������� */  
	        canvas.drawRect(90, 90, 150, 150, paint);  
	        /* ��һ��ʵ�ĳ����� */  
	        canvas.drawRect(90, 170, 150, 200, paint);  
	        /* ��һ��ʵ����Բ */  
	        RectF re2 = new RectF(90, 220, 150, 250);  
	        canvas.drawOval(re2, paint);  
	        /* ��һ��ʵ�������� */  
	        Path path2 = new Path();  
	        path2.moveTo(90, 330);  
	        path2.lineTo(150, 330);  
	        path2.lineTo(120, 270);  
	        path2.close();  
	        canvas.drawPath(path2, paint);  
	        /* ��һ��ʵ������ */  
	        Path path3 = new Path();  
	        path3.moveTo(90, 410);  
	        path3.lineTo(150, 410);  
	        path3.lineTo(135, 350);
	        path3.lineTo(105, 350);  
	        path3.close();  
	        canvas.drawPath(path3, paint);
	        
	        
	        /* ���ý���ɫ */
	        /* Consider point (x0,y0) to point (x1, y1) as an oblique line A with normalized lenth 1,  
	         * positions[] stipulates the start point of each color in colors[] with gradient fill their gaps.
	         * Then the resulting color on each point of line A is "extended" perpendicularly to the line.
	         * tile==REPEAT: After that the rest of the canvas repeat the pattern of the extended diagram.
	         * tile==MIRROR: reverse the order of colors[] when repeating base on tile==REPEAT.
	         * tile==CLAMP:  replicate the edge color if the shader draws outside of its original bounds.
	         * null positions[] stands for evenly distribution*/
	        Shader mShader = new LinearGradient(
	        		  0     /*float x0*/
	        		, 0     /*float y0*/
	        		, 100   /*float x1*/
	        		, 100   /*float y1*/
	        		, new int[] {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW } /*int[] colors*/
	        		, new float[]{0f, 0.2f, 0.5f, 1.0f} /*float[] positions*/
	        		, Shader.TileMode.REPEAT /*Shader.TileMode tile*/
	        		);  
	        paint.setShader(mShader);

	        /* ��һ������ɫԲ */  
	        canvas.drawCircle(200, 40, 30, paint);  
	        /* ��һ������ɫ������ */  
	        canvas.drawRect(170, 90, 230, 150, paint);  
	        /* ��һ������ɫ������ */  
	        canvas.drawRect(170, 170, 230, 200, paint);  
	        /* ��һ������ɫ��Բ */  
	        RectF re3 = new RectF(170, 220, 230, 250);  
	        canvas.drawOval(re3, paint);  
	        /* ��һ������ɫ������ */  
	        Path path4 = new Path();  
	        path4.moveTo(170, 330);  
	        path4.lineTo(230, 330);  
	        path4.lineTo(200, 270);  
	        path4.close();  
	        canvas.drawPath(path4, paint);  
	        /* ��һ������ɫ���� */  
	        Path path5 = new Path();  
	        path5.moveTo(170, 410);  
	        path5.lineTo(230, 410);  
	        path5.lineTo(215, 350);  
	        path5.lineTo(185, 350);  
	        path5.close();  
	        canvas.drawPath(path5, paint);  
     
	        /* ��һ��larger����ɫ������ */  
	        canvas.drawRect(0, 500, 200, 700, paint); 

	        // fill the canvas, just for preview
	        //canvas.drawRect(0, 0, getWidth(), getHeight(), paint); 
	        
	        /* Text */ 
	        paint.setTextSize(24);  
	        canvas.drawText(getResources().getString(R.string.hello_world), 240, 50, paint);  
	        canvas.drawText(getResources().getString(R.string.hello_world), 240, 120,paint);  
	        canvas.drawText(getResources().getString(R.string.hello_world), 240, 190,paint);  
	        canvas.drawText(getResources().getString(R.string.hello_world), 240, 250,paint);  
	        canvas.drawText(getResources().getString(R.string.hello_world), 240, 320,paint);  
	        canvas.drawText(getResources().getString(R.string.hello_world), 240, 390,paint);  
	    
	        // �����������ִ�
	        float x = 500; 
	        float y = 0; 
	        final int DY = 30; 
	        paint.setColor(0xFF000000); // ����һ����
	        canvas.drawLine(x, y, x, y+DY*3, paint); 
	        paint.setColor(Color.BLACK);
	        paint.setTextSize(DY);
	        
	        canvas.translate(0, DY); // move the cord origin to (0,DY), ref to current cord
	        paint.setTextAlign(Paint.Align.LEFT); // �����������ı�
	        canvas.drawText("left", x, y, paint); 
	        
	        canvas.translate(0, DY);              // move again
	        paint.setTextAlign(Paint.Align.CENTER); // �����ж�����ı�
	        canvas.drawText("center", x, y, paint); 
	        
	        canvas.translate(0, DY);              // move again
	        paint.setTextAlign(Paint.Align.RIGHT); // �����Ҷ�����ı�
	        canvas.drawText("right", x, y, paint); 
	        
	        // ������·���ϵĵ��ִ�
	        paint.setStyle(Paint.Style.STROKE);
	        
	        Path path6 = new Path();  
	        path6.moveTo(10, 0);  
	        path6.cubicTo(100, -50, 200, 50, 300, 0);
	        path6.close();
	        
	        canvas.translate(getWidth()/2, DY*2); // �ض�������λ��
	        canvas.drawPath(path6, paint); 
	        paint.setTextAlign(Paint.Align.LEFT); 
	        canvas.drawTextOnPath("Along a path", path6, 0, 0, paint); // ���ƶ���·�����ı�
	        
	        canvas.translate(0, DY*1.5f); 
	        canvas.drawPath(path6, paint); 
	        paint.setTextAlign(Paint.Align.CENTER); 
	        canvas.drawTextOnPath("Along a path", path6, 0, 0, paint); // ���ƶ���·�����ı�
	        
	        canvas.translate(0, DY*1.5f);
	        canvas.drawPath(path6, paint); 
	        paint.setTextAlign(Paint.Align.RIGHT); 
	        canvas.drawTextOnPath("Along a path", path6, 0, 0, paint); // ���ƶ���·�����ı�
	       
	        // path effect
	        Path path7 = new Path();
	        path7.moveTo(0, 0);  
            for (int i = 1; i <= 15; i++) {  
            	path7.lineTo(i*20, (float)Math.random() * 35);//�������·����  
            }  
	        path7.close();
	        
	        PathEffect[] effects = new PathEffect[6]; // ����·��Ч��
	        int[] colors = new int[] { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.BLACK}; 
	        
	        RectF bounds = new RectF(); 
	        path7.computeBounds(bounds, false);
	        canvas.translate(10 - bounds.left, 500 - bounds.top); 

	        effects[0] = null; // û��Ч��
	        effects[1] = new CornerPathEffect(10); // �ս�·��Ч��
	        effects[2] = new DashPathEffect(new float[] {10, 5, 5, 5}, 1); 
			effects[3] = new PathDashPathEffect(makePathDash(), 12, 1, PathDashPathEffect.Style.ROTATE); 
			// ���ۺ�ʽЧ��
	        effects[4] = new ComposePathEffect(effects[2], effects[1]); // ���·��Ч�����������ͬ��
	        effects[5] = new ComposePathEffect(effects[3], effects[1]); // ���·��Ч��
	        //invalidate(); 


	        Paint newPaint = new Paint();
	        /* ȥ��� */  
	        newPaint.setAntiAlias(true);  
	        /* ����paint����ɫ */  
	        /* ����paint�� style ΪSTROKE������ */  
	        newPaint.setStyle(Paint.Style.STROKE);  
	        /* ����paint������� */  
	        newPaint.setStrokeWidth(3); 
	        for (int i = 0; i < effects.length; i++) { 
	        	newPaint.setPathEffect(effects[i]); // ����·��Ч��
	        	newPaint.setColor(colors[i]); // ʹ�ò�ͬ����ɫ
	        	canvas.drawPath(path7, newPaint); // ����·���Ļ���
	        	canvas.translate(0, 28); 
	        }
	    }  
	}  
	
	private static Path makePathDash() {//����������״���������·����  
        Path p = new Path();  
//        p.moveTo(4, 0);  
//        p.lineTo(0, -4);  
//        p.lineTo(8, -4);  
//        p.lineTo(12, 0);  
//        p.lineTo(8, 4);  
//        p.lineTo(0, 4);  
        p.moveTo(8, 0);  
        p.lineTo(0, 8);  
        p.lineTo(16, 8);  
        return p;  
    } 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(new BasicViewDraw(this));
    }

    /*Another way of implementing View.onClickListener*/
    @Override
    public void onClick(View v) {
    	System.out.println("CanvasActivity onClick()"); 
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