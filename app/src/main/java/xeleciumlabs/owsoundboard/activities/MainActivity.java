package xeleciumlabs.owsoundboard.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;
import xeleciumlabs.owsoundboard.adapters.HeroAdapter;
import xeleciumlabs.owsoundboard.data.Hero;
import xeleciumlabs.owsoundboard.data.HeroList;

import static android.widget.AdapterView.INVISIBLE;
import static android.widget.AdapterView.OnItemClickListener;
import static android.widget.AdapterView.VISIBLE;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Hero> mHeroes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeroes = new ArrayList<>();
        HeroList.getHeroList(this, mHeroes);

        GridView heroGrid = (GridView) findViewById(R.id.heroList);
        HeroAdapter adapter = new HeroAdapter(this, mHeroes);
        heroGrid.setAdapter(adapter);
        heroGrid.setOnItemClickListener(heroClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    OnItemClickListener heroClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Hero hero = mHeroes.get(position);
            Log.d(TAG, "Ultimate: " + hero.getName());
            final View heroPic = view.findViewById(R.id.heroPic);
            final View ultPic = view.findViewById(R.id.ultPic);

            final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, hero.getUltSound());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Log.d(TAG, "SFX Complete");
                    heroPic.setAlpha(1.0f);
                    ultPic.setVisibility(INVISIBLE);
                    mediaPlayer.release();
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });

            ultPic.setVisibility(VISIBLE);
            ultPic.setAlpha(0.6f);
        }
    };

}