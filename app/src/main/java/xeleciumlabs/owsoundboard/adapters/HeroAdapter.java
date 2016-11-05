package xeleciumlabs.owsoundboard.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;
import xeleciumlabs.owsoundboard.data.Hero;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by Xelecium on 10/24/2016.
 *  Adapter for populating the list of OverWatch Heroes.
 */
public class HeroAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Hero> mHeroes;
    private LayoutInflater mInflater;

    //Base Constructor
    public HeroAdapter(Context context, ArrayList<Hero> heroes) {
        mContext = context;
        mHeroes = heroes;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        Resources res = mContext.getResources();
        return res.getInteger(R.integer.heroCount);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        //if view is not yet populated
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.hero_item, parent, false);

            holder = new ViewHolder();
            holder.heroPic = (ImageView)convertView.findViewById(R.id.heroPic);
            holder.ultPic = (ImageView)convertView.findViewById(R.id.ultPic);
            holder.viewPosition = position;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        final Hero currentHero = mHeroes.get(position);

        holder.heroPic.setImageResource(currentHero.getHeroPic());
        holder.ultPic.setImageResource(currentHero.getUltPic());

        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case ACTION_DOWN:
                        holder.heroPic.setAlpha(0.5f);
                        return true;
                    case ACTION_UP:
                        v.performClick();
                        return true;
                    case ACTION_CANCEL:     //finger moves off of hero
                        holder.heroPic.setAlpha(1.0f);
                        return true;
                }
                return false;
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.ultPic.setVisibility(VISIBLE);   //Make Ultimate icon visible
                holder.ultPic.setAlpha(0.75f);

                final MediaPlayer mediaPlayer = MediaPlayer.create(mContext, currentHero.getUltSound());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        holder.heroPic.setAlpha(1.0f);
                        holder.ultPic.setVisibility(INVISIBLE);
                        mediaPlayer.release();
                    }
                });
                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    @Override
                    public boolean onError(MediaPlayer mp, int what, int extra) {
                        return false;
                    }
                });
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView heroPic;
        ImageView ultPic;
        int viewPosition;
    }
}
