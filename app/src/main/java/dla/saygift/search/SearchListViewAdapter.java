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
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import dla.saygift.R;

/**
 * Created by dllo on 16/10/18.
 */
public class SearchListViewAdapter extends BaseAdapter{

    ArrayList<String> searchWords = new ArrayList<>();

    public void setSearchHistoryDB(SQLiteDatabase searchHistoryDB) {
        this.searchHistoryDB = searchHistoryDB;
    }

    private SQLiteDatabase searchHistoryDB;

    public void insert(String words) {
        searchHistoryDB.execSQL("insert into search_table(history_words) values(?)", new String[] {words});
    }

    public void setSearchWords(ArrayList<String> searchWords) {
        this.searchWords = searchWords;
    }

    @Override
    public int getCount() {
        return searchWords.size();
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

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false);
            myViewHolder = new MyViewHolder(convertView);

            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.textView.setText(searchWords.get(position));

        return convertView;
    }

    private class MyViewHolder {

        private final TextView textView;

        public MyViewHolder(View convertView) {
            textView = (TextView) convertView.findViewById(R.id.search_item_tv);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s = textView.getText().toString();
                    insert(s);
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

    public void setManager(FragmentManager manager) {
        this.manager = manager;
    }

    private FragmentManager manager;
    public void rePlaceFragment(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.search_frame, fragment);
        transaction.commit();
    }

}
