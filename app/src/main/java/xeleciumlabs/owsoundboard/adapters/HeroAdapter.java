package xeleciumlabs.owsoundboard.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import xeleciumlabs.owsoundboard.R;
import xeleciumlabs.owsoundboard.data.Hero;

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
//            holder.heroName = (TextView)convertView.findViewById(R.id.heroName);
            holder.heroPic = (ImageView)convertView.findViewById(R.id.heroPic);
            holder.viewPosition = position;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        Hero currentHero = mHeroes.get(position);

//        holder.heroName.setText(currentHero.getName());
        holder.heroPic.setImageResource(currentHero.getPic());
        return convertView;
    }

    private static class ViewHolder {
//        TextView heroName;
        ImageView heroPic;
        int viewPosition;
    }
}
