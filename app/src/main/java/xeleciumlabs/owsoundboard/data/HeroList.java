package xeleciumlabs.owsoundboard.data;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;

/**
 * Created by Xelecium on 10/24/2016.
 */
public abstract class HeroList {
    public static ArrayList<Hero> getHeroList(Context context, ArrayList<Hero> heroes) {
        Resources res = context.getResources();

        String[] heroNames = res.getStringArray(R.array.hero_names_array);
        int[] heroPics = res.getIntArray(R.array.hero_pics_array);

        int heroCount = res.getInteger(R.integer.heroCount);
        for (int i = 0; i < heroCount; i++) {
            heroes.add(new Hero(
                    heroNames[i],
                    heroPics[i],
                    0,
                    0,
                    0));
        }

        return heroes;
    }
}
