package dla.saygift.hompage.selected.baseselected;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;
import dla.saygift.hompage.basehomepage.URLValues;
import dla.saygift.hompage.selected.firstbanner.FirstBannerAdapter;
import dla.saygift.hompage.selected.firstbanner.FirstBannerBean;
import dla.saygift.hompage.selected.secondbanner.SecondBannerAdapter;
import dla.saygift.hompage.selected.secondbanner.SecondBannerBean;
import dla.saygift.hompage.selected.thirdchannels.ThirdChannelsBean;
import dla.saygift.hompage.selected.thirdchannels.ThirdChannelsSelectedBean;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/9/30.
 */
public class BaseSelected extends BaseFragment {

    private Context context;
    private RecyclerView recyclerView;

    private FirstBannerBean firstBannerBean;
    private FirstBannerAdapter firstBannerAdapter;

    private SecondBannerAdapter secondBannerAdapter;
    private SecondBannerBean secondBannerBean;

    private ThirdChannelsBean thirdChannelsBean;
    private ThirdChannelsSelectedBean thirdChannelsSelectedBean;

    private BaseSelectAdapter baseSelectAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.homepage_selected;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.homepage_selected_rv);
    }

    @Override
    protected void initData() {

        baseSelectAdapter = new BaseSelectAdapter(context);
        setFirstBannerBean();
        setSecondBannerBean();
        setThirdChannelsBean();

    }

    public void setFirstBannerBean() {

        StringRequest stringRequest = new StringRequest(URLValues.BANNER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                firstBannerBean = new FirstBannerBean();
                firstBannerBean = gson.fromJson(response, FirstBannerBean.class);

                baseSelectAdapter.setFirstBannerBean(firstBannerBean);
                baseSelectAdapter.setFirstBannerAdapter(getFirstBannerAdapter());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);
    }

    public void setSecondBannerBean() {

        StringRequest stringRequest = new StringRequest(URLValues.SECOND_BANNER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                secondBannerBean = new SecondBannerBean();
                secondBannerBean = gson.fromJson(response, SecondBannerBean.class);

                baseSelectAdapter.setSecondBannerBean(secondBannerBean);
                baseSelectAdapter.setSecondBannerAdapter(getSecondBannerAdapter());



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }

    public void setThirdChannelsBean() {
        StringRequest stringRequest = new StringRequest(URLValues.CHANNELS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();

                thirdChannelsBean = gson.fromJson(response, ThirdChannelsBean.class);

                thirdChannelsSelectedBean = new ThirdChannelsSelectedBean();

                for (int i = 0; i < thirdChannelsBean.getData().getItems().size(); i++) {

                    try {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_columns_category()
                                .add(thirdChannelsBean.getData().getItems().get(i).getColumn().getCategory());
                        Log.d("SelectedColumns", "homepage_selected_channels_columns_category:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_columns_category().get(i));
                    } catch (NullPointerException e) {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_columns_category()
                                .add(null);
                        Log.d("SelectedColumns", "homepage_selected_channels_columns_category:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_columns_category().get(i));
                    }

                    try {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_columns_title()
                                .add(thirdChannelsBean.getData().getItems().get(i).getColumn().getTitle());
                        Log.d("SelectedColumns", "homepage_selected_channels_columns_title:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_columns_title().get(i));
                    } catch (NullPointerException e) {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_columns_title()
                                .add(null);
                        Log.d("SelectedColumns", "homepage_selected_channels_columns_title:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_columns_title().get(i));
                    }

                    try {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_author_avatar_url()
                                .add(thirdChannelsBean.getData().getItems().get(i).getAuthor().getAvatar_url());
                        Log.d("SelectedColumns", "homepage_selected_channels_author_avatar_url:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_author_avatar_url().get(i));
                    } catch (NullPointerException e) {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_author_avatar_url()
                                .add(null);
                        Log.d("SelectedColumns", "homepage_selected_channels_author_avatar_url:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_author_avatar_url().get(i));
                    }

                    try {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_author_nickname()
                                .add(thirdChannelsBean.getData().getItems().get(i).getAuthor().getNickname());
                        Log.d("SelectedColumns", "homepage_selected_channels_author_nickname:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_author_nickname().get(i));
                    } catch (NullPointerException e) {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_author_nickname()
                                .add(null);
                        Log.d("SelectedColumns", "homepage_selected_channels_author_nickname:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_author_nickname().get(i));
                    }

                    try {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_Cover_img_url()
                                .add(thirdChannelsBean.getData().getItems().get(i).getCover_webp_url());
                        Log.d("SelectedColumns", "homepage_selected_channels_Cover_img_url:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_Cover_img_url().get(i));
                    } catch (NullPointerException e) {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_Cover_img_url()
                                .add(null);
                        Log.d("SelectedColumns", "homepage_selected_channels_Cover_img_url:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_Cover_img_url().get(i));
                    }

                    try {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_title()
                                .add(thirdChannelsBean.getData().getItems().get(i).getTitle());
                        Log.d("SelectedColumns", "homepage_selected_channels_title:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_title().get(i));
                    } catch (NullPointerException e) {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_title()
                                .add(null);
                        Log.d("SelectedColumns", "homepage_selected_channels_title:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_title().get(i));
                    }

                    try {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_like_counts_tv()
                                .add(String.valueOf(thirdChannelsBean.getData().getItems().get(i).getLikes_count()));
                        Log.d("SelectedColumns", "homepage_selected_channels_like_counts_tv:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_like_counts_tv().get(i));
                    } catch (NullPointerException e) {
                        thirdChannelsSelectedBean.getHomepage_selected_channels_like_counts_tv()
                                .add(null);
                        Log.d("SelectedColumns", "homepage_selected_channels_like_counts_tv:" +
                                thirdChannelsSelectedBean.getHomepage_selected_channels_like_counts_tv().get(i));
                    }

                }

                baseSelectAdapter.setThirdChannelsSelectedBean(thirdChannelsSelectedBean);

                LinearLayoutManager manager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(baseSelectAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }

    public SecondBannerAdapter getSecondBannerAdapter() {
        secondBannerAdapter = new SecondBannerAdapter();
        return secondBannerAdapter;
    }

    public FirstBannerAdapter getFirstBannerAdapter() {

        firstBannerAdapter = new FirstBannerAdapter(getChildFragmentManager());

        return firstBannerAdapter;
    }

}
