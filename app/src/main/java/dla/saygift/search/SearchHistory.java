package dla.saygift.search;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;
import dla.saygift.hompage.abasehomepage.URLValues;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/19.
 */
public class SearchHistory extends BaseFragment {

    private RecyclerView recyclerView;
    private ArrayList<String> hotWords = new ArrayList<>();
    private ArrayList<String> hotWordsType = new ArrayList<>();
    private ListView listView;
    private SQLiteDatabase searchHistoryDB;

    @Override
    protected int setLayout() {
        return R.layout.search_hotword;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.search_hotwords_rv);
        listView = bindView(R.id.search_history_lv);
    }

    @Override
    protected void initData() {

        setHotWord();

        setHistory();



    }
    public void createDB() {

        searchHistoryDB = getContext().openOrCreateDatabase("searchHistoryDB", Context.MODE_PRIVATE, null);
    }

    public void createTable() {

        searchHistoryDB.execSQL("create table if not exists search_table(id integer primary key autoincrement, history_words text)");

    }

    public void dropTable() {
        searchHistoryDB.execSQL("drop table if exists search_table");
    }

    public void insert(String words) {
        searchHistoryDB.execSQL("insert into search_table(history_words) values(?)", new String[] {words});
    }

    public void delete() {

    }

    public ArrayList<String> rawQuery() {

        ArrayList<String> historyWords = new ArrayList<>();
        Cursor cursor = searchHistoryDB.rawQuery("select * from search_table", null);
        cursor.moveToLast();
        String HHwords = cursor.getString(cursor.getColumnIndex("history_words"));
        historyWords.add(HHwords);
        Log.d("SearchHistory", "historyWords.size():" + historyWords.size());
        while (cursor.moveToPrevious()) {
            String Hwords = cursor.getString(cursor.getColumnIndex("history_words"));
            Log.d("SearchHistory", Hwords);
            historyWords.add(Hwords);
            Log.d("SearchHistory", "historyWords.size():" + historyWords.size());
        }

        return historyWords;
    }

    public void setHistory() {

        createDB();
        createTable();


        final SearchHistoryAdapter searchHistoryAdapter = new SearchHistoryAdapter();
        ArrayList<String> hisWords = rawQuery();
        for (int i = 0; i < hisWords.size(); i++) {
            Log.d("SearchHistory", hisWords.get(i));
        }
        searchHistoryAdapter.setHisWords(hisWords);
        searchHistoryAdapter.setManager(getFragmentManager());
        listView.setAdapter(searchHistoryAdapter);

    }

    public void setHotWord() {
        StringRequest stringRequest = new StringRequest(URLValues.SEARCH_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                SearchRvAdapter searchRvAdapter = new SearchRvAdapter();
                GridLayoutManager manager = new GridLayoutManager(getContext(), 4);

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray jsonArray = jsonObject.getJSONArray("hot_words");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        hotWordsType.add(jsonArray.getJSONObject(i).getString("style"));
                        hotWords.add(jsonArray.getJSONObject(i).getString("word"));

                    }

                    searchRvAdapter.setHotWords(hotWords);
                    searchRvAdapter.setHotWordType(hotWordsType);
                    searchRvAdapter.setSearchHistoryDB(searchHistoryDB);
                    searchRvAdapter.setManager(getFragmentManager());

                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(searchRvAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }

}
