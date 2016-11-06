package xeleciumlabs.owsoundboard.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;
import xeleciumlabs.owsoundboard.adapters.HeroAdapter;
import xeleciumlabs.owsoundboard.data.Hero;
import xeleciumlabs.owsoundboard.data.HeroList;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "bignoodletoo.ttf");
        textView.setTypeface(typeface);

        ArrayList<Hero> heroes = new ArrayList<>();
        HeroList.getHeroList(this, heroes);

        GridView heroGrid = (GridView) findViewById(R.id.heroList);
        HeroAdapter adapter = new HeroAdapter(this, heroes);
        heroGrid.setAdapter(adapter);
    }
}