package com.dfrobot.angelo.blunobasicdemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity  extends BlunoLibrary {
	private Button buttonScan;
	private Button buttonSerialSend;
	private EditText serialSendText;
	private TextView serialReceivedText;
	private ProgressBar ProgressBar;
	private TextView reco;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        onCreateProcess();														//onCreate Process by BlunoLibrary
		ProgressBar =(ProgressBar) findViewById(R.id.progressBar);
		reco=(TextView) findViewById(R.id.reco);
		int color = 0xFF00FF00;
		ProgressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
		ProgressBar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
		ProgressBar.setScaleY(6f);
        serialBegin(115200);													//set the Uart Baudrate on BLE chip to 115200

        serialReceivedText=(TextView) findViewById(R.id.serialReveicedText);	//initial the EditText of the received data
        		//initial the EditText of the sending data

        buttonSerialSend = (Button) findViewById(R.id.buttonSerialSend);		//initial the button for sending the data
        buttonSerialSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				serialSend(serialSendText.getText().toString());				//send the data to the BLUNO
			}
		});

        buttonScan = (Button) findViewById(R.id.buttonScan);					//initial the button for scanning the BLE device
        buttonScan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				buttonScanOnClickProcess();										//Alert Dialog for selecting the BLE device
			}
		});
	}

	protected void onResume(){
		super.onResume();
		System.out.println("BlUNOActivity onResume");
		onResumeProcess();														//onResume Process by BlunoLibrary
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		onActivityResultProcess(requestCode, resultCode, data);					//onActivityResult Process by BlunoLibrary
		super.onActivityResult(requestCode, resultCode, data);
	}
	
    @Override
    protected void onPause() {
        super.onPause();
        onPauseProcess();														//onPause Process by BlunoLibrary
    }
	
	protected void onStop() {
		super.onStop();
		onStopProcess();														//onStop Process by BlunoLibrary
	}
    
	@Override
    protected void onDestroy() {
        super.onDestroy();	
        onDestroyProcess();														//onDestroy Process by BlunoLibrary
    }

	@Override
	public void onConectionStateChange(connectionStateEnum theConnectionState) {//Once connection state changes, this function will be called
		switch (theConnectionState) {											//Four connection state
		case isConnected:
			buttonScan.setText("Connected");
			break;
		case isConnecting:
			buttonScan.setText("Connecting");
			break;
		case isToScan:
			buttonScan.setText("Scan");
			break;
		case isScanning:
			buttonScan.setText("Scanning");
			break;
		case isDisconnecting:
			buttonScan.setText("isDisconnecting");
			break;
		default:
			break;
		}
	}

	@Override
	public void onSerialReceived(String theString) {							//Once connection data received, this function will be called
		// TODO Auto-generated method stub
		serialReceivedText.setText(null);
		serialReceivedText.append(theString);							//append the text into the EditText
		//The Serial data from the BLUNO may be sub-packaged, so using a buffer to hold the String is a good choice.

		//((ScrollView)serialReceivedText.getParent()).fullScroll(View.FOCUS_DOWN);

//		if (dato>0 && dato<12){
		switch (theString){
			case "1":
				ProgressBar.setProgress(9);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#00FF80"), android.graphics.PorterDuff.Mode.SRC_IN);
				reco.setText(null);
				reco.setText("Recomendación 1");
				break;
			case "2":
				ProgressBar.setProgress(18);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#00FF80"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Verde Oscuro
				reco.setText(null);
				reco.setText("Recomendación 2");
				break;
			case "3":
				ProgressBar.setProgress(27);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#80FF00"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Amarillo Claro
				reco.setText(null);
				reco.setText("Recomendación 3");
				break;
			case "4":
				ProgressBar.setProgress(36);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#BFFF00"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Amarillo Medio
				reco.setText(null);
				reco.setText("Recomendación 4");
				break;
			case "5":
				ProgressBar.setProgress(45);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#FFFF00"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Amarillo Oscuro
				reco.setText(null);
				reco.setText("Recomendación 5");
				break;
			case "6":
				ProgressBar.setProgress(54);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#FFBF00"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Naraja Claro
				reco.setText(null);
				reco.setText("Recomendación 6");
				break;
			case "7":
				ProgressBar.setProgress(63);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#FF8000"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Naranja Oscuro
				reco.setText(null);
				reco.setText("Recomendación 7");
				break;
			case "8":
				ProgressBar.setProgress(72);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#FF4000"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Rojo Claro
				reco.setText(null);
				reco.setText("Recomendación 8");
				break;
			case "9":
				ProgressBar.setProgress(81);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#FF0040"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Rojo Medio
				reco.setText(null);
				reco.setText("Recomendación 9");
				break;
			case "10":
				ProgressBar.setProgress(90);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#B40431"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Rojo Oscuro
				reco.setText(null);
				reco.setText("Recomendación 10");
				break;
			case "11":
				ProgressBar.setProgress(100);
				ProgressBar.getProgressDrawable().setColorFilter(
						Color.parseColor("#FF00FF"), android.graphics.PorterDuff.Mode.SRC_IN);
				//Violeta
				reco.setText(null);
				reco.setText("Recomendación 11");
				break;

			}
		}

	}

