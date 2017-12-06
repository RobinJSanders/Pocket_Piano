package com.rob.pocket_piano;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    //Piano Keys
    private Button mBtn_C, mBtn_Cs, mBtn_D, mBtn_Ds, mBtn_E, mBtn_F ,mBtn_Fs, mBtn_G , mBtn_Gs, mBtn_A, mBtn_As, mBtn_B, mBtn_C_High,
    //More piano keys for tablet view
    mBtn_C_Low, mBtn_Cs_Low, mBtn_D_Low, mBtn_Ds_Low, mBtn_E_Low, mBtn_F_Low ,mBtn_Fs_Low, mBtn_G_Low , mBtn_Gs_Low, mBtn_A_Low, mBtn_As_Low, mBtn_B_Low,
            mBtn_C_Top, mBtn_Cs_High, mBtn_D_High, mBtn_Ds_High, mBtn_E_High, mBtn_F_High ,mBtn_Fs_High, mBtn_G_High , mBtn_Gs_High, mBtn_A_High, mBtn_As_High, mBtn_B_High,
    //Buttons for starting and stopping the beat
            mBtn_Beat, mBtn_BeatStop,
    //Voice selection buttons
    mBtn_Piano, mBtn_Bass, mBtn_Brass, mBtn_Banjo, mBtn_Synth;
    //Record and Playback Buttons
    private ImageButton mBtn_Record, mBtn_Stop, mBtn_Play;
    //sound IDs
    private int mSound_C, mSound_Cs ,mSound_D, mSound_Ds, mSound_E, mSound_F ,mSound_Fs, mSound_G , mSound_Gs, mSound_A, mSound_As, mSound_B, mSound_C_High, mSound_Amen,
    // Colors
    mColor_Black, mColor_White, mColor_LightBlue;
    private CheckBox mChk_Loop;
    private TextView mLbl_State;
    private SoundPool mSoundPool;
    private List<Tuple<Integer,Float>> mListRecordedSounds;
    private volatile boolean mTrackPlaying = false;
    private volatile boolean mBeatPlaying = false;
    //determines weather app is currently recording stopped or playing
    private String mRecordingState = "Ready";

    public class Tuple<Sample,Rate>
    {
        public Sample sample;
        public Rate rate;
        //constructor
        public Tuple(Sample sample, Rate rate)
        {
            this.sample = sample;
            this.rate = rate;
        }

    }


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

        //create reference to start and stop beat buttons
        mBtn_Beat = (Button) findViewById(R.id.Btn_Beat) ;
        mBtn_BeatStop = (Button) findViewById(R.id.Btn_BeatStop);

        //more keys used for tablet view only
        //lower keys
        mBtn_C_Low =(Button) findViewById(R.id.Btn_C_Low);
        mBtn_Cs_Low = (Button) findViewById(R.id.Btn_Cs_Low);
        mBtn_D_Low =(Button) findViewById(R.id.Btn_D_Low);
        mBtn_Ds_Low =(Button) findViewById(R.id.Btn_Ds_Low);
        mBtn_E_Low =(Button) findViewById(R.id.Btn_E_Low);
        mBtn_F_Low =(Button) findViewById(R.id.Btn_F_Low);
        mBtn_Fs_Low =(Button) findViewById(R.id.Btn_Fs_Low);
        mBtn_G_Low=(Button) findViewById(R.id.Btn_G_Low);
        mBtn_Gs_Low =(Button) findViewById(R.id.Btn_Gs_Low);
        mBtn_A_Low =(Button) findViewById(R.id.Btn_A_Low);
        mBtn_As_Low =(Button) findViewById(R.id.Btn_As_Low);
        mBtn_B_Low =(Button) findViewById(R.id.Btn_B_Low);
        //higher keys
        mBtn_Cs_High = (Button) findViewById(R.id.Btn_Cs_High);
        mBtn_D_High =(Button) findViewById(R.id.Btn_D_High);
        mBtn_Ds_High =(Button) findViewById(R.id.Btn_Ds_High);
        mBtn_E_High =(Button) findViewById(R.id.Btn_E_High);
        mBtn_F_High =(Button) findViewById(R.id.Btn_F_High);
        mBtn_Fs_High =(Button) findViewById(R.id.Btn_Fs_High);
        mBtn_G_High =(Button) findViewById(R.id.Btn_G_High);
        mBtn_Gs_High=(Button) findViewById(R.id.Btn_Gs_High);
        mBtn_A_High =(Button) findViewById(R.id.Btn_A_High);
        mBtn_As_High =(Button) findViewById(R.id.Btn_As_High);
        mBtn_B_High =(Button) findViewById(R.id.Btn_B_High);
        mBtn_C_Top =(Button) findViewById(R.id.Btn_C_Top);



        //assign references to views for voice buttons
        mBtn_Piano = (Button) findViewById(R.id.Btn_Piano);
        mBtn_Bass = (Button) findViewById(R.id.Btn_Bass);
        mBtn_Brass = (Button) findViewById(R.id.Btn_Brass);
        mBtn_Banjo = (Button) findViewById(R.id.Btn_Banjo);
        mBtn_Synth = (Button) findViewById(R.id.Btn_Synth);

        //assign references to views for record and playback buttons
        mBtn_Record =(ImageButton) findViewById(R.id.Btn_Record);
        mBtn_Stop =(ImageButton) findViewById(R.id.Btn_Stop);
        mBtn_Play =(ImageButton) findViewById(R.id.Btn_Play);
        mChk_Loop = (CheckBox) findViewById(R.id.Chk_Loop);
        mLbl_State = (TextView) findViewById(R.id.Lbl_State);

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

        //build list for recorded sounds
        mListRecordedSounds = new ArrayList<>();

        //OnClickListeners for each piano key
        mBtn_C.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_C,1);
            }
        });
        mBtn_Cs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Cs,1);
            }
        });
        mBtn_D.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_D,1);
            }
        });
        mBtn_Ds.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Ds,1);
            }
        });
        mBtn_E.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_E,1);
            }
        });
        mBtn_F.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_F,1);
            }
        });
        mBtn_Fs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Fs,1);
            }
        });
        mBtn_G.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_G,1);
            }
        });
        mBtn_Gs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Gs,1);
            }
        });
        mBtn_A.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_A,1);
            }
        });
        mBtn_As.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_As,1);
            }
        });
        mBtn_B.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_B,1);
            }
        });
        mBtn_C_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_C_High,1);

            }
        });

        //OnClickListener for beat button
        mBtn_Beat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mBtn_Beat.setVisibility(View.GONE);
                mBtn_BeatStop.setVisibility(View.VISIBLE);
                startThreadBeat();
            }
        });
        mBtn_BeatStop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               mBeatPlaying = false;
                mBtn_Beat.setVisibility(View.VISIBLE);
                mBtn_BeatStop.setVisibility(View.GONE);
            }
        });

        //piano keys used in xl tablet view only
        mBtn_C_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_C,0.5f);
            }
        });
        mBtn_Cs_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Cs,0.5f);
            }
        });
        mBtn_D_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_D,0.5f);
            }
        });
        mBtn_Ds_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Ds,0.5f);
            }
        });
        mBtn_E_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_E,0.5f);
            }
        });
        mBtn_F_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_F,0.5f);
            }
        });
        mBtn_Fs_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Fs,0.5f);
            }
        });
        mBtn_G_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_G,0.5f);
            }
        });
        mBtn_Gs_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Gs,0.5f);
            }
        });
        mBtn_A_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_A,0.5f);
            }
        });
        mBtn_As_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_As,0.5f);
            }
        });
        mBtn_B_Low.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_B,0.5f);
            }
        });
        mBtn_Cs_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Cs,2f);
            }
        });
        mBtn_D_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_D,2f);
            }
        });
        mBtn_Ds_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Ds,2f);
            }
        });
        mBtn_E_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_E,2f);
            }
        });
        mBtn_F_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_F,2f);
            }
        });
        mBtn_Fs_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Fs,2f);
            }
        });
        mBtn_G_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_G,2f);
            }
        });
        mBtn_Gs_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_Gs,2f);
            }
        });
        mBtn_A_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_A,2f);
            }
        });
        mBtn_As_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_As,2f);
            }
        });
        mBtn_B_High.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_B,2f);
            }
        });
        mBtn_C_Top.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(mSound_C_High,2f);

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
                switchState("Recording");
            }
        });
        mBtn_Stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mTrackPlaying =false;
                switchState("Ready");
            }
        });

        mBtn_Play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switchState("Playing");
                startThreadTrack();
            }
        });

    }

    private void startThreadBeat()
    {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                mBeatPlaying = true;
                while(mBeatPlaying)
                {
                    /*if (!mBeatPlaying)
                        break;
                    else*/
                    {
                        mSoundPool.play(mSound_Amen, 1, 1, 1, 0, 1);
                        try
                        {
                            Thread.sleep(2000);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t.start();
    }


    public void startThreadTrack(){
        Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                mTrackPlaying = true;
                while(mTrackPlaying)
                {
                    for (Tuple<Integer, Float> sound: mListRecordedSounds )
                    {
                        if (!mTrackPlaying)
                        {
                            break;
                        }
                        else
                            mSoundPool.play(sound.sample, 1, 1, 1, 0, sound.rate);
                        try
                        {
                            Thread.sleep(500);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    //loop playback if checkbox is checked
                    if (!mChk_Loop.isChecked())
                        mTrackPlaying = false;
                }
            }
        });
        t.start();
    }




    private void switchState(String state)
    {

        if (state != "Ready")
        {
            mBtn_Stop.setVisibility(View.VISIBLE);
            mBtn_Record.setVisibility(View.GONE);
            mBtn_Play.setVisibility(View.GONE);

        }
        else
        {
            mBtn_Stop.setVisibility(View.GONE);
            mBtn_Record.setVisibility(View.VISIBLE);
            mBtn_Play.setVisibility(View.VISIBLE);
        }
        mRecordingState = state;
        mLbl_State.setText(state);
    }


    private void playSound(int sample, float rate)
    {
        mSoundPool.play(sample,1,1,1,0,rate);
        if (mRecordingState == "Recording")
            mListRecordedSounds.add(new Tuple(sample,rate));
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
        mSound_Amen = mSoundPool.load(this, R.raw.amen,1);
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
