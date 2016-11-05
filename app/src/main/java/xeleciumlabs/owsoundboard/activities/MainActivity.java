package xeleciumlabs.owsoundboard.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;
import xeleciumlabs.owsoundboard.adapters.HeroAdapter;
import xeleciumlabs.owsoundboard.data.Hero;
import xeleciumlabs.owsoundboard.data.HeroList;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;
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
    }
}