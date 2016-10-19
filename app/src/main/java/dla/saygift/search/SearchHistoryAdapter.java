package dla.saygift.search;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import dla.saygift.R;

/**
 * Created by dllo on 16/10/19.
 */
public class SearchHistoryAdapter extends BaseAdapter{

    private ArrayList<String> hisWords;


    public void setHisWords(ArrayList<String> hisWords) {
        this.hisWords = hisWords;
    }

    @Override
    public int getCount() {
        return hisWords.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder myViewHolder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_history_item, parent, false);

            myViewHolder = new MyViewHolder(convertView);

            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.textView.setText(hisWords.get(position));

        return convertView;
    }

    private class MyViewHolder {

        private final TextView textView;

        public MyViewHolder(final View convertView) {
            textView = (TextView) convertView.findViewById(R.id.search_history_tv);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s = textView.getText().toString();
                    String strUTF8 = getUTF8(String.valueOf(s));

                    SearchResult searchResult = new SearchResult();
                    searchResult.setStrUTF8(strUTF8);
                    rePlaceFragment(searchResult);

                }
            });

        }

        public String getUTF8(String str) {
            String utf8 = null;
            try {
                utf8 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return utf8;
        }

    }

    private FragmentManager manager;

    public void setManager(FragmentManager manager) {
        this.manager = manager;
    }

    public void rePlaceFragment(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.search_frame, fragment);
        transaction.commit();
    }
}
