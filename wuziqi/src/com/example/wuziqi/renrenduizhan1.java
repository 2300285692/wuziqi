package com.example.wuziqi;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class renrenduizhan1 extends Activity {
	public static int arrWidth = 10, arrHeight = 10;
	public static int[][] arr = new int[arrHeight][arrWidth];
	public static boolean bo = false;
	public static int X = 0, Y = 0, P = 0;
    private Draw view;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.renrenduizhan);
		Button btnStart = (Button) findViewById(R.id.button1);
		btnStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				P = 0;
  				renrenduizhan1.bo = false;
 				renrenduizhan1.initArr();
   	            view.invalidate();
			}
		});
		initArr();
		init();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onTouchEvent(MotionEvent event) {
		// 在这里判断一下如果是按下操作就获取坐标然后执行方法
		if (P == 0)
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				X = (int) event.getX();
				Y = (int) event.getY();
				onClickScreen();
			}
		return super.onTouchEvent(event);
	}

	public static void initArr() {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 0;
			}
	}

	private void init() {
		LinearLayout layout = (LinearLayout) findViewById(R.id.ll_canver);
	    view = new Draw(this);
		view.setMinimumHeight(500);
		view.setMinimumWidth(500);
		// 通知view组件重绘
		view.invalidate();
		layout.addView(view);
	}

	public void onClickScreen() {
		if (X > 65 && X < 425 && Y > 295 && Y < 735) {
			if ((X - 65) % Draw.WIDTH > (Draw.WIDTH / 2)) {
				X = (X - 65) / Draw.WIDTH + 1;
			} else {
				X = (X - 65) / Draw.WIDTH;
			}
			if ((Y - 295) % Draw.HEIGHT > (Draw.HEIGHT / 2)) {
				Y = (Y - 295) / Draw.HEIGHT + 1;
			} else {
				Y = (Y - 295) / Draw.HEIGHT;
			}
			if (arr[Y][X] != 0) {
				Toast.makeText(renrenduizhan1.this, "已有棋子",
						Toast.LENGTH_SHORT).show();
				return;
			} else {
				if (bo)
					arr[Y][X] = 1;// 黑
				else
					arr[Y][X] = 2;// 白
				
				if (isWin(Y, X)) {
					if (bo) {
						Toast.makeText(renrenduizhan1.this, "黑棋胜利！",
								Toast.LENGTH_SHORT).show();
						dialog();
					} else {
						Toast.makeText(renrenduizhan1.this, "白棋胜利！",
								Toast.LENGTH_SHORT).show();
						dialog();
						
					} 
				}
				renrenduizhan1.bo = !renrenduizhan1.bo;
			}
		}
		view.invalidate();
	}
	
	protected void dialog() {
		P = 1;
	}
//判断是否获胜
	static boolean isWin(int ro, int co) {
		int count = 1;
		// 右
		for (int i = co + 1; i < arr[ro].length; i++) {
			if (arr[ro][i] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		// 左
		for (int i = co - 1; i >= 0; i--) {
			if (arr[ro][i] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		if (count >= 5)
			return true;

		count = 1;
		// 下
		for (int i = ro + 1; i < arr.length; i++) {
			if (arr[i][co] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		// 上
		for (int i = ro - 1; i >= 0; i--) {
			if (arr[i][co] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		if (count >= 5)
			return true;

		count = 1;
		// 左上
		for (int i = ro - 1, j = co - 1; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		// 右下
		for (int i = ro + 1, j = co + 1; i < arr.length && j < arr[ro].length; i++, j++) {
			if (arr[i][j] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		if (count >= 5)
			return true;

		count = 1;
		// 左下
		for (int i = ro + 1, j = co - 1; i < arr.length && j >= 0; i++, j--) {
			if (arr[i][j] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		// 右上
		for (int i = ro - 1, j = co + 1; i >= 0 && j < arr[i].length; i--, j++) {
			if (arr[i][j] == arr[ro][co]) {
				count++;
			} else
				break;
		}
		if (count >= 5)
			return true;

		return false;
	}

}

