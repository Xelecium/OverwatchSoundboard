package xeleciumlabs.owsoundboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import xeleciumlabs.owsoundboard.R;

/**
 * Created by Xelecium on 10/24/2016.
 */
public class HeroAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    //Base Constructor
    public HeroAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return 22;
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

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }


        return convertView;
    }

    private static class ViewHolder {
        String heroName;
    }
}
