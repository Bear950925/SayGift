package dla.saygift.kindpage.single;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import dla.saygift.R;


/**
 * 基本功能：左侧Adapter
 * 创建：王杰
 * 创建时间：16/4/14
 * 邮箱：w489657152@gmail.com
 */
public class LeftListAdapter extends BaseAdapter {
    private String[] leftStr;
    boolean[] flagArray;
    private Context context;

    ArrayList<String> leftItems;
    ArrayList<Boolean> flags;

    public LeftListAdapter(Context context, ArrayList<String> leftStr, ArrayList<Boolean> flagArray) {
        this.leftItems = leftStr;
        this.context = context;
        this.flags = flagArray;
        Log.d("LeftListAdapter", "leftItems.size():" + leftItems.size());
    }

    @Override
    public int getCount() {
        return leftItems.size();
    }

    @Override
    public Object getItem(int arg0) {
        return leftItems.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        Holder holder = null;
        if (arg1 == null) {
            holder = new Holder();
            arg1 = LayoutInflater.from(context).inflate(R.layout.kindpage_s_left_list_item, null);
            holder.left_list_item = (TextView) arg1.findViewById(R.id.left_list_item);
            arg1.setTag(holder);
        } else {
            holder = (Holder) arg1.getTag();
        }
        holder.updataView(arg0);
        return arg1;
    }

    private class Holder {
        private TextView left_list_item;

        public void updataView(final int position) {
            left_list_item.setText(leftItems.get(position));
            if (flags.get(position)) {
                left_list_item.setBackgroundResource(R.drawable.homepage_selected_channels_category);
            } else {
                left_list_item.setBackgroundColor(Color.WHITE);
            }
        }

    }
}
