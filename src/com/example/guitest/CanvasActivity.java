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
	    	
	        /* 设置背景 */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	    	bmcanvas.drawColor(Color.GREEN);  

	        /* 去锯齿 */  
	        bmpaint.setAntiAlias(true);  
	        /* 设置paint的颜色 */  
	        bmpaint.setColor(Color.RED);  
	        /* 设置paint的 style 为STROKE：空心 */  
	        bmpaint.setStyle(Paint.Style.STROKE);  
	        /* 设置paint的外框宽度 */  
	        bmpaint.setStrokeWidth(3);
	        bmpaint.setAlpha(0x80); 
	        /* 画一个空心圆形 */  
	        bmcanvas.drawCircle(x/2 /*x within the bmcanvas*/, y/2/*y within the bmcanvas*/, x/2, bmpaint);  
	    }
	    
	    @Override  
	    protected void onDraw(Canvas canvas) {  
	        super.onDraw(canvas);  
	        /* 设置背景为白色 */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	        canvas.drawColor(Color.WHITE);  
	        Paint paint = new Paint();
	        
	        /* 去锯齿 */  
	        paint.setAntiAlias(true);  
	        /* 设置paint的颜色 */  
	        paint.setColor(Color.RED);  
	        /* 设置paint的 style 为STROKE：空心 */  
	        paint.setStyle(Paint.Style.STROKE);  
	        /* 设置paint的外框宽度 */  
	        paint.setStrokeWidth(3);  
	        
	        /* draw a bitmap */
	        canvas.drawBitmap(m_Bitmap3, 0/*left on x*/, 800/*top on y*/, paint);
	        /* 画一个空心圆形 */  
	        canvas.drawCircle(40, 40, 30, paint);  
	        /* 画一个空心正方形 */  
	        canvas.drawRect(10, 90, 70, 150, paint);  
	        /* 画一个空心长方形 */  
	        canvas.drawRect(10, 170, 70, 200, paint);  
	        /* 画一个空心椭圆形 */  
	        RectF re = new RectF(10, 220, 70, 250);  
	        canvas.drawOval(re, paint);  
	        /* 画一个空心三角形 */  
	        Path path = new Path();  
	        path.moveTo(10, 330);  
	        path.lineTo(70, 330);  
	        path.lineTo(40, 270);  
	        path.close();//记得要close  
	        canvas.drawPath(path, paint);  
	        /* 画一个空心梯形 */  
	        Path path1 = new Path();  
	        path1.moveTo(10, 410);  
	        path1.lineTo(70, 410);
	        path1.lineTo(55, 350);  
	        path1.lineTo(25, 350);  
	        path1.close();  
	        canvas.drawPath(path1, paint);  
	  
	        
	        /* 设置paint 的style为 FILL：实心 */  
	        paint.setStyle(Paint.Style.FILL);  
	        /* 设置paint的颜色 */  
	        paint.setColor(Color.BLUE|Color.RED);  
	        /* 画一个实心圆 */  
	        canvas.drawCircle(120, 40, 30, paint);  
	        /* 画一个实心正方形 */  
	        canvas.drawRect(90, 90, 150, 150, paint);  
	        /* 画一个实心长方形 */  
	        canvas.drawRect(90, 170, 150, 200, paint);  
	        /* 画一个实心椭圆 */  
	        RectF re2 = new RectF(90, 220, 150, 250);  
	        canvas.drawOval(re2, paint);  
	        /* 画一个实心三角形 */  
	        Path path2 = new Path();  
	        path2.moveTo(90, 330);  
	        path2.lineTo(150, 330);  
	        path2.lineTo(120, 270);  
	        path2.close();  
	        canvas.drawPath(path2, paint);  
	        /* 画一个实心梯形 */  
	        Path path3 = new Path();  
	        path3.moveTo(90, 410);  
	        path3.lineTo(150, 410);  
	        path3.lineTo(135, 350);
	        path3.lineTo(105, 350);  
	        path3.close();  
	        canvas.drawPath(path3, paint);
	        
	        
	        /* 设置渐变色 */
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

	        /* 画一个渐变色圆 */  
	        canvas.drawCircle(200, 40, 30, paint);  
	        /* 画一个渐变色正方形 */  
	        canvas.drawRect(170, 90, 230, 150, paint);  
	        /* 画一个渐变色长方形 */  
	        canvas.drawRect(170, 170, 230, 200, paint);  
	        /* 画一个渐变色椭圆 */  
	        RectF re3 = new RectF(170, 220, 230, 250);  
	        canvas.drawOval(re3, paint);  
	        /* 画一个渐变色三角形 */  
	        Path path4 = new Path();  
	        path4.moveTo(170, 330);  
	        path4.lineTo(230, 330);  
	        path4.lineTo(200, 270);  
	        path4.close();  
	        canvas.drawPath(path4, paint);  
	        /* 画一个渐变色梯形 */  
	        Path path5 = new Path();  
	        path5.moveTo(170, 410);  
	        path5.lineTo(230, 410);  
	        path5.lineTo(215, 350);  
	        path5.lineTo(185, 350);  
	        path5.close();  
	        canvas.drawPath(path5, paint);  
     
	        /* 画一个larger渐变色正方形 */  
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
	    
	        // 绘制正常的字串
	        float x = 500; 
	        float y = 0; 
	        final int DY = 30; 
	        paint.setColor(0xFF000000); // 绘制一条线
	        canvas.drawLine(x, y, x, y+DY*3, paint); 
	        paint.setColor(Color.BLACK);
	        paint.setTextSize(DY);
	        
	        canvas.translate(0, DY); // move the cord origin to (0,DY), ref to current cord
	        paint.setTextAlign(Paint.Align.LEFT); // 绘制左对齐的文本
	        canvas.drawText("left", x, y, paint); 
	        
	        canvas.translate(0, DY);              // move again
	        paint.setTextAlign(Paint.Align.CENTER); // 绘制中对齐的文本
	        canvas.drawText("center", x, y, paint); 
	        
	        canvas.translate(0, DY);              // move again
	        paint.setTextAlign(Paint.Align.RIGHT); // 绘制右对齐的文本
	        canvas.drawText("right", x, y, paint); 
	        
	        // 绘制在路径上的的字串
	        paint.setStyle(Paint.Style.STROKE);
	        
	        Path path6 = new Path();  
	        path6.moveTo(10, 0);  
	        path6.cubicTo(100, -50, 200, 50, 300, 0);
	        path6.close();
	        
	        canvas.translate(getWidth()/2, DY*2); // 重定画布的位置
	        canvas.drawPath(path6, paint); 
	        paint.setTextAlign(Paint.Align.LEFT); 
	        canvas.drawTextOnPath("Along a path", path6, 0, 0, paint); // 绘制对齐路径的文本
	        
	        canvas.translate(0, DY*1.5f); 
	        canvas.drawPath(path6, paint); 
	        paint.setTextAlign(Paint.Align.CENTER); 
	        canvas.drawTextOnPath("Along a path", path6, 0, 0, paint); // 绘制对齐路径的文本
	        
	        canvas.translate(0, DY*1.5f);
	        canvas.drawPath(path6, paint); 
	        paint.setTextAlign(Paint.Align.RIGHT); 
	        canvas.drawTextOnPath("Along a path", path6, 0, 0, paint); // 绘制对齐路径的文本
	       
	        // path effect
	        Path path7 = new Path();
	        path7.moveTo(0, 0);  
            for (int i = 1; i <= 15; i++) {  
            	path7.lineTo(i*20, (float)Math.random() * 35);//生成随机路径。  
            }  
	        path7.close();
	        
	        PathEffect[] effects = new PathEffect[6]; // 定义路径效果
	        int[] colors = new int[] { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.BLACK}; 
	        
	        RectF bounds = new RectF(); 
	        path7.computeBounds(bounds, false);
	        canvas.translate(10 - bounds.left, 500 - bounds.top); 

	        effects[0] = null; // 没有效果
	        effects[1] = new CornerPathEffect(10); // 拐角路径效果
	        effects[2] = new DashPathEffect(new float[] {10, 5, 5, 5}, 1); 
			effects[3] = new PathDashPathEffect(makePathDash(), 12, 1, PathDashPathEffect.Style.ROTATE); 
			// 破折号式效果
	        effects[4] = new ComposePathEffect(effects[2], effects[1]); // 组合路径效果（内外各不同）
	        effects[5] = new ComposePathEffect(effects[3], effects[1]); // 组合路径效果
	        //invalidate(); 


	        Paint newPaint = new Paint();
	        /* 去锯齿 */  
	        newPaint.setAntiAlias(true);  
	        /* 设置paint的颜色 */  
	        /* 设置paint的 style 为STROKE：空心 */  
	        newPaint.setStyle(Paint.Style.STROKE);  
	        /* 设置paint的外框宽度 */  
	        newPaint.setStrokeWidth(3); 
	        for (int i = 0; i < effects.length; i++) { 
	        	newPaint.setPathEffect(effects[i]); // 设置路径效果
	        	newPaint.setColor(colors[i]); // 使用不同的颜色
	        	canvas.drawPath(path7, newPaint); // 进行路径的绘制
	        	canvas.translate(0, 28); 
	        }
	    }  
	}  
	
	private static Path makePathDash() {//生成特殊形状。用于填充路径。  
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