package dla.saygift.kindpage.raiders;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragmentActivity;
import dla.saygift.kindpage.KINDPAGEUrlValues;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/17.
 */
public class AllSectionActivity extends BaseFragmentActivity {

    private PullToRefreshListView listView;
    private String nextUrl;

    @Override
    protected int setLayout() {
        return R.layout.kindpage_r_allsection;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.kindpage_allsec_lv);
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    @Override

    public void initData() {
        listView.setMode(PullToRefreshBase.Mode.BOTH);

        final AllSectionAdapter allSectionAdapter = new AllSectionAdapter();
        StringRequest stringRequest = new StringRequest(KINDPAGEUrlValues.SECTION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

//                Log.d("AllSectionActivity", response);
//                Gson gson = new Gson();
//                AllSectionBean allSectionBean = gson.fromJson(response, AllSectionBean.class);
                allSectionAdapter.setResponse(response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONObject jsonObject1 = jsonObject.getJSONObject("paging");
                    nextUrl = jsonObject1.getString("next_url");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                listView.setAdapter(allSectionAdapter);

                listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        StringRequest stringRequest1 = new StringRequest(nextUrl, new Response.Listener<String>() {

                            private ArrayList<String> titles;
                            private ArrayList<String> authors;
                            private ArrayList<String> imgUrls;

                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    jsonObject = jsonObject.getJSONObject("data");
                                    JSONObject jsonObject1 = jsonObject.getJSONObject("paging");
                                    nextUrl = jsonObject1.getString("next_url");
                                    JSONArray jsonArray = jsonObject.getJSONArray("columns");
                                    imgUrls = new ArrayList<>();
                                    authors = new ArrayList<>();
                                    titles = new ArrayList<>();
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject bean = jsonArray.getJSONObject(i);
                                        imgUrls.add(bean.getString("banner_image_url"));

                                        authors.add(jsonArray.getJSONObject(i).getString("author"));
                                        titles.add(bean.getString("title"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                allSectionAdapter.Allload(imgUrls, authors, titles);
                                listView.onRefreshComplete();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                        VolleySingleTon.getInstance().addQueue(stringRequest1);
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }
}
