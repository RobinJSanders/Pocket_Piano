package com.rob.pocket_piano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity
{
    //Piano Keys
    Button Btn_Low_C;
    Button Btn_D ;
    Button Btn_Ds;
    Button Btn_E;
    Button Btn_F ;
    Button Btn_Fs ;
    Button Btn_G ;
    Button Btn_Gs;
    Button Btn_A ;
    Button Btn_As;
    Button Btn_B;
    Button Btn_High_C;
    //Voice selection buttons
    Button Btn_Piano;
    Button Btn_Bass;
    Button Btn_Brass;
    Button Btn_Banjo;
    Button Btn_Synth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise piano keys
        Btn_Low_C =(Button) findViewById(R.id.Btn_Low_C);
        Btn_D =(Button) findViewById(R.id.Btn_D);
        Btn_Ds =(Button) findViewById(R.id.Btn_Ds);
        Btn_E =(Button) findViewById(R.id.Btn_E);
        Btn_F =(Button) findViewById(R.id.Btn_F);
        Btn_Fs =(Button) findViewById(R.id.Btn_Fs);
        Btn_G =(Button) findViewById(R.id.Btn_Gs);
        Btn_Gs =(Button) findViewById(R.id.Btn_Gs);
        Btn_A =(Button) findViewById(R.id.Btn_A);
        Btn_As =(Button) findViewById(R.id.Btn_As);
        Btn_B =(Button) findViewById(R.id.Btn_B);
        Btn_High_C =(Button) findViewById(R.id.Btn_High_C);

        //Initialise Voice Buttons
        Btn_Piano = (Button) findViewById(R.id.Btn_Piano);
        Btn_Bass = (Button) findViewById(R.id.Btn_Bass);
        Btn_Brass = (Button) findViewById(R.id.Btn_Brass);
        Btn_Banjo = (Button) findViewById(R.id.Btn_Banjo);
        Btn_Synth = (Button) findViewById(R.id.Btn_Synth);

        //OnClickListeners for each piano key
        Btn_Low_C.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_D.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_Ds.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_E.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        Btn_F.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_Fs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_G.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        Btn_Gs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_A.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_As.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_B.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Btn_High_C.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        //OnClickListeners for each voice selector button
        Btn_Piano.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        Btn_Bass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        Btn_Brass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        Btn_Banjo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        Btn_Synth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });




    }


}
