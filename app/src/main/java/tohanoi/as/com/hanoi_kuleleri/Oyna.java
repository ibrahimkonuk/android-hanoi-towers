package tohanoi.as.com.hanoi_kuleleri;

import java.math.BigDecimal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class Oyna extends Activity {

	private int totalMoves, minPossibleMoves;

	public void onCreate(Bundle b) {
		super.onCreate(b);

		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

		setContentView(new Ciz(this, displaymetrics.widthPixels,
				displaymetrics.heightPixels, getIntent().getExtras().getInt(
						"numofdisks")));

		minPossibleMoves = new BigDecimal(2).pow(
				getIntent().getExtras().getInt("numofdisks")).intValue() - 1;
	}

	public void gameOver(int moves) {
		totalMoves = moves;
		showDialog();
	}

	public void showDialog() {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Oyun Bitti");
		
		if (totalMoves > minPossibleMoves)
			alert.setMessage("En az hareket sayisi " + minPossibleMoves
					+ ", Siz " + totalMoves + ".");
		else
			alert.setMessage("Kazandiniz, Tebrikler !");

		alert.setPositiveButton("Geri", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				finish();
			}
		});
		
		alert.create().show();
	}
}