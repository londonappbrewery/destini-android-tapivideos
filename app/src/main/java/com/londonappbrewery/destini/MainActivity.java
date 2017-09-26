package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
        Button mUpButton;
        Button mDownButton;
        TextView mText;
        int mButton1;
        int mButton2;


    // Banka Dugmica i storya

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = 1;
        mButton2 = 1;

        //ALERT DIALOG START
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Game Over");
        alert.setCancelable(false);
        alert.setPositiveButton("Close app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }

        });
        alert.setNegativeButton("Start Over!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mButton1 = 1;
                mButton2 = 1;
                mText.setText(R.string.T1_Story);
                mUpButton.setText(R.string.T1_Ans1);
                mDownButton.setText(R.string.T1_Ans2);
                mUpButton.setVisibility(View.VISIBLE);
                mDownButton.setVisibility(View.VISIBLE);
            }
        });
        //ALERT DIALOG END




        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
            mUpButton = (Button)findViewById(R.id.buttonTop);
            mDownButton = (Button) findViewById(R.id.buttonBottom);
            mText = (TextView) findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

            mUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mButton1 = mButton1 +1;

                    if(mButton1 == 2 && mButton2 <2) {
                        mText.setText(R.string.T3_Story);
                        mUpButton.setText(R.string.T3_Ans1);
                        mDownButton.setText(R.string.T3_Ans2);
                    }else if(mButton1 == 3 && mButton2 <2){

                        mText.setText(R.string.T6_End);
                        mUpButton.setVisibility(View.GONE);
                        mDownButton.setVisibility(View.GONE);
                        alert.setMessage(R.string.T6_End);
                        alert.show();
                    }else if(mButton2 == 2 && mButton1 <= 2){
                        mText.setText(R.string.T3_Story);
                        mUpButton.setText(R.string.T3_Ans1);
                        mDownButton.setText(R.string.T3_Ans2);

                    }else if(mButton2 == 2 && mButton1 > 2){
                        mText.setText(R.string.T6_End);
                        mUpButton.setVisibility(View.GONE);
                        mDownButton.setVisibility(View.GONE);

                        alert.setMessage(R.string.T6_End);
                        alert.show();

                    }


                }
            });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

            mDownButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mButton2 = mButton2 + 1;

                    if (mButton2 == 2 && mButton1 < 2) {
                        mText.setText(R.string.T2_Story);
                        mUpButton.setText(R.string.T2_Ans1);
                        mDownButton.setText(R.string.T2_Ans2);
                    }else if(mButton2 == 3 && mButton1 < 2) {

                        mText.setText(R.string.T4_End);
                        mUpButton.setVisibility(View.GONE);
                        mDownButton.setVisibility(View.GONE);
                        alert.setMessage(R.string.T4_End);
                        alert.show();
                    }else if(mButton1 == 2 && mButton1 <= 2){

                            mText.setText(R.string.T5_End);
                            mUpButton.setVisibility(View.GONE);
                            mDownButton.setVisibility(View.GONE);
                        alert.setMessage(R.string.T5_End);
                        alert.show();

                        }else if(mButton2 == 3 && mButton1 > 2){

                        mText.setText(R.string.T5_End);
                        mUpButton.setVisibility(View.GONE);
                        mDownButton.setVisibility(View.GONE);

                        alert.setMessage(R.string.T5_End);
                        alert.show();
                    }

                }
            });

    }

}
