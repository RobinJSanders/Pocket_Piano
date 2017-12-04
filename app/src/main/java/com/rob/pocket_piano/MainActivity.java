package com.rob.pocket_piano;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    //Piano Keys
    Button mBtn_C, mBtn_Cs, mBtn_D, mBtn_Ds, mBtn_E, mBtn_F ,mBtn_Fs, mBtn_G , mBtn_Gs, mBtn_A, mBtn_As, mBtn_B, mBtn_C_High,
    //Voice selection buttons
    mBtn_Piano, mBtn_Bass, mBtn_Brass, mBtn_Banjo, mBtn_Synth,
    //Record and Playback Buttons
    mBtn_Record, mBtn_Stop, mBtn_Play;
    //sound IDs
    private int mSound_C, mSound_Cs ,mSound_D, mSound_Ds, mSound_E, mSound_F ,mSound_Fs, mSound_G , mSound_Gs, mSound_A, mSound_As, mSound_B, mSound_C_High,
    // Colors
    mColor_Black, mColor_White, mColor_LightBlue;

    SoundPool mSoundPool;
    List<Integer> mListRecordedSounds;
    boolean mRecording = false;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign references to views for keyboard keys
        mBtn_C =(Button) findViewById(R.id.Btn_C);
        mBtn_Cs = (Button) findViewById(R.id.Btn_Cs);
        mBtn_D =(Button) findViewById(R.id.Btn_D);
        mBtn_Ds =(Button) findViewById(R.id.Btn_Ds);
        mBtn_E =(Button) findViewById(R.id.Btn_E);
        mBtn_F =(Button) findViewById(R.id.Btn_F);
        mBtn_Fs =(Button) findViewById(R.id.Btn_Fs);
        mBtn_G =(Button) findViewById(R.id.Btn_G);
        mBtn_Gs =(Button) findViewById(R.id.Btn_Gs);
        mBtn_A =(Button) findViewById(R.id.Btn_A);
        mBtn_As =(Button) findViewById(R.id.Btn_As);
        mBtn_B =(Button) findViewById(R.id.Btn_B);
        mBtn_C_High =(Button) findViewById(R.id.Btn_C_High);

        //assign references to views for voice buttons
        mBtn_Piano = (Button) findViewById(R.id.Btn_Piano);
        mBtn_Bass = (Button) findViewById(R.id.Btn_Bass);
        mBtn_Brass = (Button) findViewById(R.id.Btn_Brass);
        mBtn_Banjo = (Button) findViewById(R.id.Btn_Banjo);
        mBtn_Synth = (Button) findViewById(R.id.Btn_Synth);

        //assign references to views for record and playback buttons
        mBtn_Record =(Button) findViewById(R.id.Btn_Record);
        mBtn_Stop =(Button) findViewById(R.id.Btn_Stop);
        mBtn_Play =(Button) findViewById(R.id.Btn_Play);
        
        //Initialise SoundPool
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            mSoundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else
        {
            mSoundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        }



        //Get colors from resources folder
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
        {
            mColor_Black = ContextCompat.getColor(this,R.color.black);
            mColor_White = ContextCompat.getColor(this,R.color.white);
            mColor_LightBlue = ContextCompat.getColor(this, R.color.lightBlue);
        }
        else
        {
            mColor_Black = getResources().getColor(R.color.black);
            mColor_White = getResources().getColor(R.color.white);
            mColor_LightBlue = getResources().getColor(R.color.lightBlue);
        }


        //load initial sounds for piano
        loadPianoSounds();

        mListRecordedSounds = new ArrayList<Integer>();


        //OnClickListeners for each piano key
        mBtn_C.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_C,1);
            }
        });

        mBtn_Cs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_Cs,1);
            }
        });


        mBtn_D.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_D,1);
            }
        });

        mBtn_Ds.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_Ds,1);
            }
        });

        mBtn_E.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_E,1);
            }
        });

        mBtn_F.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_F,1);
            }
        });

        mBtn_Fs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_Fs,1);
            }
        });

        mBtn_G.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_G,1);
            }
        });

        mBtn_Gs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_Gs,1);
            }
        });

        mBtn_A.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_A,1);
            }
        });

        mBtn_As.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_As,1);
            }
        });

        mBtn_B.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_B,1);
            }
        });

        mBtn_C_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlaySound(mSound_C_High,1);

            }
        });

        //OnClickListeners for each voice selector button
        mBtn_Piano.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadPianoSounds();
                resetColors();
                mBtn_Piano.setBackgroundColor(mColor_Black);
                mBtn_Piano.setTextColor(mColor_White);
            }
        });
        mBtn_Bass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadBassSounds();
                resetColors();
                mBtn_Bass.setBackgroundColor(mColor_Black);
                mBtn_Bass.setTextColor(mColor_White);
            }
        });
        mBtn_Brass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadBrassSounds();
                resetColors();
                mBtn_Brass.setBackgroundColor(mColor_Black);
                mBtn_Brass.setTextColor(mColor_White);
            }
        });
        mBtn_Banjo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadBanjoSounds();
                resetColors();
                mBtn_Banjo.setBackgroundColor(mColor_Black);
                mBtn_Banjo.setTextColor(mColor_White);
            }
        });
        mBtn_Synth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadSynthSounds();
                resetColors();
                mBtn_Synth.setBackgroundColor(mColor_Black);
                mBtn_Synth.setTextColor(mColor_White);
            }
        });

        //OnClickListeners for record and playback buttons
        mBtn_Record.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mListRecordedSounds.clear();
                mRecording = true;
            }
        });
        mBtn_Stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mRecording = false;
            }
        });

        mBtn_Play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for (final int sound: mListRecordedSounds )
                {

                    mSoundPool.play(sound, 1,1,1,0,1);
                    try
                    {
                        Thread.sleep(500);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }


                }
            }
        });

    }

    private void PlaySound(int sound, float rate)
    {
        mSoundPool.play(sound,1,1,1,0,rate);
        if (mRecording = true)
            mListRecordedSounds.add(sound);
    }

    private void loadPianoSounds()
    {
        mSound_C = mSoundPool.load(this, R.raw.piano_c,1);
        mSound_Cs = mSoundPool.load(this, R.raw.piano_cs,1);
        mSound_D = mSoundPool.load(this, R.raw.piano_d,1);
        mSound_Ds = mSoundPool.load(this, R.raw.piano_ds,1);
        mSound_E = mSoundPool.load(this, R.raw.piano_e,1);
        mSound_F = mSoundPool.load(this, R.raw.piano_f,1);
        mSound_Fs = mSoundPool.load(this, R.raw.piano_fs,1);
        mSound_G = mSoundPool.load(this, R.raw.piano_g,1);
        mSound_Gs = mSoundPool.load(this, R.raw.piano_gs,1);
        mSound_A = mSoundPool.load(this, R.raw.piano_a,1);
        mSound_As = mSoundPool.load(this, R.raw.piano_as,1);
        mSound_B = mSoundPool.load(this, R.raw.piano_b,1);
        mSound_C_High = mSoundPool.load(this, R.raw.piano_c2,1);
    }

    private void loadBassSounds()
    {
        mSound_C = mSoundPool.load(this, R.raw.bass_c,1);
        mSound_Cs = mSoundPool.load(this, R.raw.bass_cs,1);
        mSound_D = mSoundPool.load(this, R.raw.bass_d,1);
        mSound_Ds = mSoundPool.load(this, R.raw.bass_ds,1);
        mSound_E = mSoundPool.load(this, R.raw.bass_e,1);
        mSound_F = mSoundPool.load(this, R.raw.bass_f,1);
        mSound_Fs = mSoundPool.load(this, R.raw.bass_fs,1);
        mSound_G = mSoundPool.load(this, R.raw.bass_g,1);
        mSound_Gs = mSoundPool.load(this, R.raw.bass_gs,1);
        mSound_A = mSoundPool.load(this, R.raw.bass_a,1);
        mSound_As = mSoundPool.load(this, R.raw.bass_as,1);
        mSound_B = mSoundPool.load(this, R.raw.bass_b,1);
        mSound_C_High = mSoundPool.load(this, R.raw.bass_c2,1);
    }

    private void loadBrassSounds()
    {
        mSound_C = mSoundPool.load(this, R.raw.brass_c,1);
        mSound_Cs = mSoundPool.load(this, R.raw.brass_cs,1);
        mSound_D = mSoundPool.load(this, R.raw.brass_d,1);
        mSound_Ds = mSoundPool.load(this, R.raw.brass_ds,1);
        mSound_E = mSoundPool.load(this, R.raw.brass_e,1);
        mSound_F = mSoundPool.load(this, R.raw.brass_f,1);
        mSound_Fs = mSoundPool.load(this, R.raw.brass_fs,1);
        mSound_G = mSoundPool.load(this, R.raw.brass_g,1);
        mSound_Gs = mSoundPool.load(this, R.raw.brass_gs,1);
        mSound_A = mSoundPool.load(this, R.raw.brass_a,1);
        mSound_As = mSoundPool.load(this, R.raw.brass_as,1);
        mSound_B = mSoundPool.load(this, R.raw.brass_b,1);
        mSound_C_High = mSoundPool.load(this, R.raw.brass_c2,1);
    }

    private void loadBanjoSounds()
    {
        mSound_C = mSoundPool.load(this, R.raw.banjo_c,1);
        mSound_Cs = mSoundPool.load(this, R.raw.banjo_cs,1);
        mSound_D = mSoundPool.load(this, R.raw.banjo_d,1);
        mSound_Ds = mSoundPool.load(this, R.raw.banjo_ds,1);
        mSound_E = mSoundPool.load(this, R.raw.banjo_e,1);
        mSound_F = mSoundPool.load(this, R.raw.banjo_f,1);
        mSound_Fs = mSoundPool.load(this, R.raw.banjo_fs,1);
        mSound_G = mSoundPool.load(this, R.raw.banjo_g,1);
        mSound_Gs = mSoundPool.load(this, R.raw.banjo_gs,1);
        mSound_A = mSoundPool.load(this, R.raw.banjo_a,1);
        mSound_As = mSoundPool.load(this, R.raw.banjo_as,1);
        mSound_B = mSoundPool.load(this, R.raw.banjo_b,1);
        mSound_C_High = mSoundPool.load(this, R.raw.banjo_c2,1);
    }

    private void loadSynthSounds()
    {
        mSound_C = mSoundPool.load(this, R.raw.synth_c,1);
        mSound_Cs = mSoundPool.load(this, R.raw.synth_cs,1);
        mSound_D = mSoundPool.load(this, R.raw.synth_d,1);
        mSound_Ds = mSoundPool.load(this, R.raw.synth_ds,1);
        mSound_E = mSoundPool.load(this, R.raw.synth_e,1);
        mSound_F = mSoundPool.load(this, R.raw.synth_f,1);
        mSound_Fs = mSoundPool.load(this, R.raw.synth_fs,1);
        mSound_G = mSoundPool.load(this, R.raw.synth_g,1);
        mSound_Gs = mSoundPool.load(this, R.raw.synth_gs,1);
        mSound_A = mSoundPool.load(this, R.raw.synth_a,1);
        mSound_As = mSoundPool.load(this, R.raw.synth_as,1);
        mSound_B = mSoundPool.load(this, R.raw.synth_b,1);
        mSound_C_High = mSoundPool.load(this, R.raw.synth_c2,1);
    }

    private void resetColors()
    {
        mBtn_Piano.setBackgroundColor(mColor_LightBlue);
        mBtn_Piano.setTextColor(mColor_Black);
        mBtn_Bass.setBackgroundColor(mColor_LightBlue);
        mBtn_Bass.setTextColor(mColor_Black);
        mBtn_Brass.setBackgroundColor(mColor_LightBlue);
        mBtn_Brass.setTextColor(mColor_Black);
        mBtn_Banjo.setBackgroundColor(mColor_LightBlue);
        mBtn_Banjo.setTextColor(mColor_Black);
        mBtn_Synth.setBackgroundColor(mColor_LightBlue);
        mBtn_Synth.setTextColor(mColor_Black);
    }



}
