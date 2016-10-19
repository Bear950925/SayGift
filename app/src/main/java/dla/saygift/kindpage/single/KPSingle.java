package dla.saygift.kindpage.single;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import dla.saygift.R;
import dla.saygift.kindpage.KINDPAGEUrlValues;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/12.
 */
public class KPSingle extends dla.saygift.baseclass.BaseFragment {


    //    @Bind(R.id.left_listview)
    ListView leftListview;
    //    @Bind(R.id.pinnedListView)
    PinnedHeaderListView pinnedListView;
    private boolean isScroll = true;
    private LeftListAdapter adapter;

    private String volleyRespones;

    private boolean[] flagArray = {true, false, false, false, false, false, false, false, false};

    private Handler handler;

    private MainSectionedAdapter sectionedAdapter;
    private ArrayList<String> leftItems;
    private ArrayList<singleItemsbean> rightCate;
    private ArrayList<Boolean> flags;

    @Override
    protected int setLayout() {
        return R.layout.kindpage_single;
    }

    @Override
    protected void initView() {

        leftListview = bindView(R.id.kindpage_single_left_lv);
        pinnedListView = bindView(R.id.kindpage_single_right_pv);

    }

    @Override
    protected void initData() {

        setItem();
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                setItemsClick();

                return false;
            }
        });

    }

    public void setItem() {

        StringRequest stringRequest = new StringRequest(KINDPAGEUrlValues.SINGLE_ITEM_CATEGORY_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                JSONArray jsonArray = null;
                volleyRespones = response;
                try {

                    jsonObject = new JSONObject(response);
                    jsonObject = jsonObject.getJSONObject("data");
                    jsonArray = jsonObject.getJSONArray("categories");
                    leftItems = new ArrayList<>();
                    rightCate = new ArrayList<>();
                    flags = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {

                        switch (i) {
                            case 0:
                                flags.add(true);
                                break;
                            default:
                                flags.add(false);
                                break;
                        }

                        leftItems.add(jsonArray.getJSONObject(i).getString("name"));
                        singleItemsbean bean = new singleItemsbean();
                        ArrayList<String> itemArr = new ArrayList<>();
                        ArrayList<String> urlArr = new ArrayList<>();
                        for (int j = 0; j < jsonArray.getJSONObject(i).getJSONArray("subcategories").length(); j++) {

                            Log.d("KPSingle11", " " + jsonArray.getJSONObject(i).getJSONArray("subcategories").length());

                            Log.d("KPSingle11", "j:" + j);
                            itemArr.add(jsonArray.getJSONObject(i).getJSONArray("subcategories").getJSONObject(j).getString("name"));
                            Log.d("KPSingle", itemArr.get(j));
                            urlArr.add(jsonArray.getJSONObject(i).getJSONArray("subcategories").getJSONObject(j).getString("icon_url"));

                        }
                        bean.setCategoryName(itemArr);
                        bean.setCategoryUrl(urlArr);
                        Log.d("KPSingle", "0");
                        rightCate.add(bean);
                    }

                    Log.d("KPSingle", "1");
                    handler.sendEmptyMessage(1);

                    Log.d("KPSingle", "3");
                    sectionedAdapter = new MainSectionedAdapter(getContext(), leftItems, rightCate);
                    adapter = new LeftListAdapter(getContext(), leftItems, flags);

                    Log.d("KPSingle", "4");

                    pinnedListView.setAdapter(sectionedAdapter);
                    Log.d("KPSingle", "5");
                    leftListview.setAdapter(adapter);
                    Log.d("KPSingle", "6");


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

    public void setItemsClick() {

        leftListview.setItemsCanFocus(true);


        leftListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                isScroll = false;


                for (int i = 0; i < leftItems.size(); i++) {
                    if (i == position) {
                        flags.add(i, true);
                    } else {
                        flags.add(i, false);
                    }
                }

                adapter.notifyDataSetChanged();


                int rightSection = 0;
                for (int i = 0; i < position; i++) {
                    rightSection += sectionedAdapter.getCountForSection(i) + 1;
                }
                pinnedListView.setSelection(rightSection);

            }

        });

        pinnedListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (pinnedListView.getLastVisiblePosition() == (pinnedListView.getCount() - 1)) {
                            leftListview.setSelection(flagArray.length - 1);
                        }

                        // 判断滚动到顶部
                        if (pinnedListView.getFirstVisiblePosition() == 0) {
                            leftListview.setSelection(0);
                        }

                        break;
                }
            }

            int y = 0;
            int x = 0;
            int z = 0;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {

                    for (int i = 0; i < rightCate.size(); i++) {
                        if (i == sectionedAdapter.getSectionForPosition(pinnedListView.getFirstVisiblePosition())) {
                            flags.add(i, true);
                            x = i;
                        } else {
                            flags.add(i, false);
                        }
                    }
                    if (x != y) {
                        adapter.notifyDataSetChanged();
                        y = x;
                        if (y == leftListview.getLastVisiblePosition()) {
//                            z = z + 3;
                            leftListview.setSelection(z);
                        }
                        if (x == leftListview.getFirstVisiblePosition()) {
//                            z = z - 1;
                            leftListview.setSelection(z);
                        }
                        if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                            leftListview.setSelection(ListView.FOCUS_DOWN);
                        }
                    }
                } else {
                    isScroll = true;
                }
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
