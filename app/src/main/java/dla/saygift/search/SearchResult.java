package dla.saygift.search;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/19.
 */
public class SearchResult extends BaseFragment {

    private String strUTF8;
    private String UrlsBefore = "http://api.liwushuo.com/v2/search/item?keyword=";
    private String UrlsBehind = "&limit=20&offset=0&sort=";
    private String Urls;
    private PullToRefreshListView listView;
    private String nextUrls;
    private SearchResultAdapter searchResultAdapter;

    @Override
    protected int setLayout() {
        return R.layout.search_result;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.search_result_lv);
    }

    @Override
    protected void initData() {

        Handler handler = new Handler();
        handler.sendEmptyMessage(View.VISIBLE);
        setResult(true);

        listView.setMode(PullToRefreshBase.Mode.BOTH);

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                setResult(false);
            }
        });

    }

    public void setResult(final boolean isFirst) {

        StringRequest stringRequest = new StringRequest(isFirst == true ? Urls : nextUrls, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                ArrayList<String> description = new ArrayList<>();
                ArrayList<String> names = new ArrayList<>();
                ArrayList<String> selections = new ArrayList<>();
                ArrayList<String> imgUrls = new ArrayList<>();
                ArrayList<String> prices = new ArrayList<>();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    Log.d("SearchResult", response);
                    jsonObject = jsonObject.getJSONObject("data");
                    String related = jsonObject.getString("total");
                    JSONObject nextUrlObject = jsonObject.getJSONObject("paging");
                    nextUrls = nextUrlObject.getString("next_url");
                    Log.d("SearchResult", nextUrls);
                    TextView textView = bindView(R.id.search_result_related_tv);
                    textView.setText("相关单品(" + related + "件)");
                    JSONArray jsonArray = jsonObject.getJSONArray("items");

                    /**
                     * 获取需要的结果数据
                     */
                    for (int i = 0; i < jsonArray.length(); i++) {
                        description.add(jsonArray.getJSONObject(i).getString("short_description"));
                        names.add(jsonArray.getJSONObject(i).getString("name"));
                        selections.add(jsonArray.getJSONObject(i).getString("selection"));
                        imgUrls.add(jsonArray.getJSONObject(i).getString("cover_image_url"));
                        prices.add(jsonArray.getJSONObject(i).getString("price"));
                    }

                    if (true == isFirst) {

                        searchResultAdapter = new SearchResultAdapter();
                        searchResultAdapter.setDescription(description);
                        searchResultAdapter.setNames(names);
                        searchResultAdapter.setSelections(selections);
                        searchResultAdapter.setImgUrls(imgUrls);
                        searchResultAdapter.setPrices(prices);

                        listView.setAdapter(searchResultAdapter);

                    } else {
                        searchResultAdapter.Allload(description, names, selections, imgUrls, prices);
                        listView.onRefreshComplete();
                    }



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

    public void setStrUTF8(String strUTF) {
        this.strUTF8 = strUTF;
        Urls = UrlsBefore + strUTF8 + UrlsBehind;
    }
}
