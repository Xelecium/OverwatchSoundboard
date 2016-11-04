package xeleciumlabs.owsoundboard.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;
import xeleciumlabs.owsoundboard.data.Hero;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MASK;
import static android.view.MotionEvent.ACTION_UP;

/**
 * Created by Xelecium on 10/24/2016.
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

        ViewHolder holder;

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
        convertView.setOnTouchListener(heroTouchListener);

        Hero currentHero = mHeroes.get(position);

        holder.heroPic.setImageResource(currentHero.getHeroPic());
        holder.ultPic.setImageResource(currentHero.getUltPic());
        return convertView;
    }

    private static class ViewHolder {
        ImageView heroPic;
        ImageView ultPic;
        int viewPosition;
    }

    View.OnTouchListener heroTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction() & ACTION_MASK) {
                case ACTION_DOWN:
                    v.setAlpha(0.5f);
                    break;
                case ACTION_UP:
                    v.setAlpha(1.0f);
                    v.performClick();
                    break;
                default: break;
            }

            return false;
        }
    };
}
