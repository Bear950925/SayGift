package dla.saygift.search;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import dla.saygift.R;

/**
 * Created by dllo on 16/10/19.
 */
public class SearchRvAdapter extends RecyclerView.Adapter<SearchRvAdapter.MyViewHolder>{

    private ArrayList<String> hotWords;

    public void setHotWordType(ArrayList<String> hotWordType) {
        this.hotWordType = hotWordType;
    }

    private ArrayList<String> hotWordType;

    private SQLiteDatabase searchHistoryDB;

    public void insert(String words) {
        searchHistoryDB.execSQL("insert into search_table(history_words) values(?)", new String[] {words});
    }

    public void setSearchHistoryDB(SQLiteDatabase searchHistoryDB) {
        this.searchHistoryDB = searchHistoryDB;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_hot_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    public void setHotWords(ArrayList<String> hotWordss) {
        this.hotWords = hotWordss;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.hotTv.setText(hotWords.get(position));
    }


    @Override
    public int getItemCount() {
        return hotWords.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView hotTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            hotTv = (TextView) itemView.findViewById(R.id.search_hot_item_tv);

            hotTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s = hotTv.getText().toString();
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
