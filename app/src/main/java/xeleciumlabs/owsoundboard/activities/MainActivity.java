package xeleciumlabs.owsoundboard.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
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

import static android.widget.AdapterView.*;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Hero> mHeroes;

    private MediaPlayer mPlayer;

    private TextView mTextView;
    private GridView mGridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.textView);
        mHeroes = new ArrayList<Hero>();
        HeroList.getHeroList(this, mHeroes);

        mGridView = (GridView)findViewById(R.id.heroList);
        HeroAdapter adapter = new HeroAdapter(this, mHeroes);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(heroClickListener);

        mPlayer = MediaPlayer.create(MainActivity.this, R.raw.sombra_placeholder);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }

    OnItemClickListener heroClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d(TAG, "Pressed " + position);
            Hero now = mHeroes.get(position);

            mPlayer.reset();
            mPlayer = MediaPlayer.create(MainActivity.this, now.getUltimate());
            mPlayer.start();

            //TODO: Add an onErrorListener for the MediaPlayer
        }
    };

}