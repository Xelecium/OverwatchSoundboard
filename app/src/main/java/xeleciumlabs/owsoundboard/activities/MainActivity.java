package xeleciumlabs.owsoundboard.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;
import xeleciumlabs.owsoundboard.adapters.HeroAdapter;
import xeleciumlabs.owsoundboard.data.Hero;
import xeleciumlabs.owsoundboard.data.HeroList;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Hero> mHeroes;

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
        HeroAdapter adapter = new HeroAdapter(this);
        mGridView.setAdapter(adapter);


    }


    AdapterView.OnItemClickListener heroClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };

}