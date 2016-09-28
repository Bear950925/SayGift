package dla.saygift.hompage.basehomepage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dla.saygift.baseclass.BaseFragment;
import dla.saygift.R;
import dla.saygift.hompage.selected.baseselected.SelectedColumns;
import dla.saygift.hompage.togirlfriend.ToGirlfrien;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/9/19.
 */
public class HomePagerFragment extends BaseFragment {

    private ViewPager vp;
    private TabLayout tb;
    private EditText editText;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected int setLayout() {
        return R.layout.homepage_base;
    }

    @Override
    protected void initView() {
        tb = bindView(R.id.homepage_tb);
        vp = bindView(R.id.homepage_vp);
        editText = bindView(R.id.base_ed);
    }

    @Override
    protected void initData() {

        setSearch();
        setColumns();

    }

    public void setSearch() {

        StringRequest stringRequest = new StringRequest(URLValues.SEARCH_URL,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();

                        SearchBean searchBean = gson.fromJson(response, SearchBean.class);

                        editText.setHint(searchBean.getData().getPlaceholder());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("HomePagerFragment", "error:" + error);
                    }
                });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }
    public void setColumns() {
        StringRequest stringRequest = new StringRequest(URLValues.COLUMNS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject object = null;
                try {
                    object = new JSONObject(response);
                    object = object.getJSONObject("data");
                    JSONArray jsonArray = object.getJSONArray("candidates");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        arrayList.add(jsonArray.getJSONObject(i).getString("name"));
                    }

                    HomePagerFragmentAdapter homePagerFragmentAdapter = new HomePagerFragmentAdapter(getChildFragmentManager());

                    for (int i = 0; i < arrayList.size(); i++) {
                        switch (i) {
                            case 0:
                                fragments.add(new SelectedColumns());
                                break;
                            default:
                                fragments.add(new ToGirlfrien());
                        }
                    }

                    homePagerFragmentAdapter.setFragments(fragments);
                    homePagerFragmentAdapter.setTitles(arrayList);
                    vp.setAdapter(homePagerFragmentAdapter);
                    tb.setupWithViewPager(vp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HomePagerFragment", "error:" + error);
            }
        });
        VolleySingleTon.getInstance().addQueue(stringRequest);
    }

}
