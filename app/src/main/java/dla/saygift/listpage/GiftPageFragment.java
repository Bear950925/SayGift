package dla.saygift.listpage;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dla.saygift.baseclass.BaseFragment;
import dla.saygift.R;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/9/20.
 */
public class GiftPageFragment extends BaseFragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected int setLayout() {
        return R.layout.listpage;
    }

    @Override
    protected void initView() {
        tabLayout = bindView(R.id.listpage_tb);
        viewPager = bindView(R.id.listpage_vp);
    }

    @Override
    protected void initData() {

        setColumns();

    }

    public void setColumns() {

        StringRequest stringRequest = new StringRequest(LIST_URLValues.COLUMNS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                JSONArray jsonArray = null;

                try {

                    jsonObject = new JSONObject(response);
                    jsonObject = jsonObject.getJSONObject("data");
                    jsonArray = jsonObject.getJSONArray("ranks");
                    ArrayList<String> columns = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {

                        columns.add(jsonArray.getJSONObject(i).getString("name"));

                    }

                    ArrayList<Fragment> fragments = new ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        ContentFragment contentFragment = new ContentFragment();
                        contentFragment.setChannelsUrl(LIST_URLValues.LIST_URL[i]);
                        fragments.add(contentFragment);
                    }

                    GiftPageAdapter giftPageAdapter = new GiftPageAdapter(getChildFragmentManager());
                    giftPageAdapter.setFragments(fragments);
                    giftPageAdapter.setArrayList(columns);
                    viewPager.setAdapter(giftPageAdapter);
                    tabLayout.setupWithViewPager(viewPager);

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
