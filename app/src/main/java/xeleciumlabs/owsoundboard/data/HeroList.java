package xeleciumlabs.owsoundboard.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;

/**
 * Created by Xelecium on 10/24/2016.
 *  Abstract class containing arrays of resource IDs for OverWatch Heroes.
 *  Used primarily as a data source for constructing Hero objects.
 */
public abstract class HeroList {
    public static ArrayList<Hero> getHeroList(Context context, ArrayList<Hero> heroes) {

        Resources res = context.getResources();
        final int PIC_DEFAULT = R.drawable.ow_logo;
        final int SFX_DEFAULT = R.raw.sombra_placeholder;


        //Get names from the hero_names.xml
        String[] heroNames = res.getStringArray(R.array.hero_names_array);
        //Get drawable IDs from hero_pics.xml
        TypedArray heroPics = res.obtainTypedArray(R.array.hero_pics_array);
        //Get ultimate IDs from sound_ultimate.xml
        TypedArray ultSounds = res.obtainTypedArray(R.array.sound_ultimate_array);
        //Get ultimate IDs from ult_pics.xml
        TypedArray ultPics = res.obtainTypedArray(R.array.ult_pics_array);

        int heroCount = res.getInteger(R.integer.heroCount);
        for (int i = 0; i < heroCount; i++) {
            heroes.add(new Hero(
                    heroNames[i],                       //Hero Name
                    heroPics.getResourceId(i, PIC_DEFAULT),      //Hero Pic
                    ultSounds.getResourceId(i, SFX_DEFAULT),     //Ultimate Sound
                    ultPics.getResourceId(i, PIC_DEFAULT)        //Ultimate Pic
            ));
        }

        //Cleanup resources
        heroPics.recycle();
        ultSounds.recycle();
        ultPics.recycle();

        return heroes;
    }
}
