package xeleciumlabs.owsoundboard.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;

/**
 * Created by Xelecium on 10/24/2016.
 */
public abstract class HeroList {
    public static ArrayList<Hero> getHeroList(Context context, ArrayList<Hero> heroes) {
        Resources res = context.getResources();

        //Get names from the hero_names.xml
        String[] heroNames = res.getStringArray(R.array.hero_names_array);
        //Get drawable IDs from hero_pics.xml
        TypedArray heroPics = res.obtainTypedArray(R.array.hero_pics_array);
        //Get ultimate IDs from sound_ultimate.xml
        TypedArray heroUlts = res.obtainTypedArray(R.array.sound_ultimate_array);

        int heroCount = res.getInteger(R.integer.heroCount);
        for (int i = 0; i < heroCount; i++) {
            heroes.add(new Hero(
                    heroNames[i],
                    heroPics.getResourceId(i, -1),
                    0,
                    0,
                    heroUlts.getResourceId(i, -1)));
        }

        //cleanup resources
        heroPics.recycle();
        heroUlts.recycle();

        return heroes;
    }
}
