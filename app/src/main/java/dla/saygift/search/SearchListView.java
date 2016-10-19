package dla.saygift.search;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/18.
 */
public class SearchListView extends BaseFragment {

    private ListView listView;

    private String strUTF8;
    private SearchListViewAdapter searchListViewAdapter;
    private ArrayList<String> searchWords = new ArrayList<>();

    private String searchURL = "http://api.liwushuo.com/v2/search/word_completed?keyword=";
    private boolean classNull;
    private SQLiteDatabase searchHistoryDB;

    public void setStrUTF8(String strUTF8) {
        searchWords.clear();
        Volle(strUTF8, classNull);
    }

    public void NotifyDataSetchanged() {
        searchListViewAdapter.setSearchWords(searchWords);
        searchListViewAdapter.notifyDataSetChanged();
    }

    public void createDB() {

        searchHistoryDB = getContext().openOrCreateDatabase("searchHistoryDB", Context.MODE_PRIVATE, null);
    }

    public void createTable() {

        searchHistoryDB.execSQL("create table if not exists search_table(id integer primary key autoincrement, history_words text)");

    }

    public void insert(String words) {
        Log.d("SearchListView", words);
        searchHistoryDB.execSQL("insert into search_table(history_words) values(?)", new String[] {words});
    }

    @Override
    protected int setLayout() {
        return R.layout.search_listview;
    }

    @Override
    protected void initView() {

        listView = bindView(R.id.search_listview_lv);

    }

    public SearchListView(String strUTF8) {
        this.strUTF8 = strUTF8;
    }

    @Override
    protected void initData() {

        createDB();
        createTable();

        searchListViewAdapter = new SearchListViewAdapter();
        searchListViewAdapter.setManager(getFragmentManager());
        searchListViewAdapter.setSearchHistoryDB(searchHistoryDB);

        classNull = true;

        Volle(strUTF8, classNull);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.search_item_tv);
                String HisWords = (String) textView.getText();
                Toast.makeText(mContext, HisWords, Toast.LENGTH_SHORT).show();
                insert(HisWords);
            }
        });

    }

    public void Volle(String strUtf8, final boolean classisNull) {

        String urls = searchURL + strUtf8;



        final StringRequest stringRequest = new StringRequest(urls, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray jsonArray = jsonObject.getJSONArray("words");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        searchWords.add(jsonArray.getString(i));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (true == classisNull) {
                    classNull = false;
                    searchListViewAdapter.setSearchWords(searchWords);
                    listView.setAdapter(searchListViewAdapter);
                } else {
                    NotifyDataSetchanged();
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
