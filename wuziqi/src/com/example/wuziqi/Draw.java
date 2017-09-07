package com.example.wuziqi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;

public class Draw  extends View {  
	  
	public static int HEIGHT=60,WIDTH=60;
	
    public Draw (Context context) {  
        super(context);  
    }  
  
    @Override  
    protected void onDraw(Canvas canvas) {  
//        super.onDraw(canvas);  
        // ´´½¨»­±Ê  
        DisplayMetrics dm = new DisplayMetrics();  
        dm = getResources().getDisplayMetrics();  
        int screenWidth  = dm.widthPixels;    // ÆÁÄ»¿í£¨ÏñËØ£¬Èç£º480px£©  
        int  screenHeight = dm.heightPixels; 
        Paint p = new Paint(); 
        p.setColor(Color.BLACK);// ÉèÖÃºÚÉ« 
        if(renrenduizhan1.P==1){
        	if(renrenduizhan1.bo ){
        		Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.stone_w2);  
         	     canvas.drawBitmap(bitmap2, 9*WIDTH,100, p);
        	}
        	else {
        		 Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.stone_b1);  
        	     canvas.drawBitmap(bitmap1, WIDTH ,100, p);
        	}
        }/*else 
        {
        	Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.stone_b1); //ºÚ 
  	     canvas.drawBitmap(bitmap2, WIDTH,100, p);
  	     Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.stone_w2); //°×
	     canvas.drawBitmap(bitmap1,  9*WIDTH,100, p);
	     }*/
        for(int i=0;i<renrenduizhan1.arrHeight;i++){
        	canvas.drawLine(WIDTH, i* HEIGHT+HEIGHT*4,  WIDTH+(renrenduizhan1.arrWidth-1)*WIDTH, i* HEIGHT+HEIGHT*4, p);
          }
        for(int i=0;i<renrenduizhan1.arrWidth;i++){
        	canvas.drawLine(i*WIDTH+WIDTH,HEIGHT*4,  i*WIDTH+WIDTH, HEIGHT*4+(renrenduizhan1.arrHeight-1)*HEIGHT, p);
        } 
        
        for(int i=0;i<renrenduizhan1.arr.length;i++)
			for(int j=0;j<renrenduizhan1.arr[i].length;j++)
			   {
				if(renrenduizhan1.arr[i][j] ==1)
				{
					p.setColor(Color.BLACK);
				    canvas.drawCircle(j*WIDTH+WIDTH, i*HEIGHT+HEIGHT*4,15, p);// Ð¡Ô²  
				} 
				if(renrenduizhan1.arr[i][j] ==2)
				{
				 p.setColor(Color.WHITE);	
			  	 canvas.drawCircle(j*WIDTH+WIDTH, i*HEIGHT+HEIGHT*4,15, p);// Ð¡Ô²  
				} 
			}
    }
    }