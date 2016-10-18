package dla.saygift.hompage.channels;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.net.URL;
import java.util.ArrayList;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;
import dla.saygift.hompage.abasehomepage.URLValues;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/8.
 */
public class AnotherChannels extends BaseFragment {

    private RecyclerView recyclerView;
    private int Columns;
    private ArrayList<String> columnsArrayList = new ArrayList<>();
    private ChannelsBean channelsBean;
    private ChannelsSelectedBean channelsSelectedBean;
    private Context context;

    public void setColumnsArrayList() {

        columnsArrayList.add(URLValues.CHANNELS_URL);
        columnsArrayList.add(URLValues.TO_GIRLFRIEND_CHANNELS_URL);
        columnsArrayList.add(URLValues.BUY_LOT_CHANNELS_URL);
        columnsArrayList.add(URLValues.CREATIVE_LIVE_CHANNELS_URL);
        columnsArrayList.add(URLValues.TO_JIFRIEND_CHANNELS_URL);
        columnsArrayList.add(URLValues.TO_PARENT_CHANNELS_URL);
        columnsArrayList.add(URLValues.TO_COLLEAGUE_CHANNELS_URL);
        columnsArrayList.add(URLValues.TO_BABY_CHANNELS_URL);
        columnsArrayList.add(URLValues.FASHIONABLE_URL);
        columnsArrayList.add(URLValues.LITERARY_STYLE_URL);
        columnsArrayList.add(URLValues.FUNNY_URL);
        columnsArrayList.add(URLValues.TECHNOLOGY_URL);
        columnsArrayList.add(URLValues.MENGMENGDA_URL);
        columnsArrayList.add(URLValues.LOVE_BOOK_ULR);

    }

    public AnotherChannels() {
        super();
    }

    public void setColumns(int columns) {
        Columns = columns;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.homepage_another;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.homepage_another_rv);
    }

    @Override
    protected void initData() {

        setColumnsArrayList();

        Log.d("AnotherChannels", "1");

        StringRequest stringRequest = new StringRequest(columnsArrayList.get(Columns), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();

                channelsBean = gson.fromJson(response, ChannelsBean.class);
                channelsSelectedBean = new ChannelsSelectedBean();

                for (int i = 0; i < channelsBean.getData().getItems().size(); i++) {


                    try {
                        channelsSelectedBean.getHomepage_another_channels_columns_category()
                                .add(channelsBean.getData().getItems().get(i).getColumn().getCategory());
                    } catch (NullPointerException e) {
                        channelsSelectedBean.getHomepage_another_channels_columns_category()
                                .add(null);
                    }

                    try {
                        channelsSelectedBean.getHomepage_another_channels_columns_title()
                                .add(channelsBean.getData().getItems().get(i).getColumn().getTitle());
                    } catch (NullPointerException e) {
                        channelsSelectedBean.getHomepage_another_channels_columns_title()
                                .add(null);
                    }

                    try {
                        channelsSelectedBean.getHomepage_another_channels_author_avatar_url()
                                .add(channelsBean.getData().getItems().get(i).getAuthor().getAvatar_url());
                    } catch (NullPointerException e) {
                        channelsSelectedBean.getHomepage_another_channels_author_avatar_url()
                                .add(null);
                    }

                    try {
                        channelsSelectedBean.getHomepage_another_channels_author_nickname()
                                .add(channelsBean.getData().getItems().get(i).getAuthor().getNickname());
                    } catch (NullPointerException e) {
                        channelsSelectedBean.getHomepage_another_channels_author_nickname()
                                .add(null);
                    }

                    try {
                        channelsSelectedBean.getHomepage_another_channels_Cover_img_url()
                                .add(channelsBean.getData().getItems().get(i).getCover_webp_url());
                    } catch (NullPointerException e) {
                        channelsSelectedBean.getHomepage_another_channels_Cover_img_url()
                                .add(null);
                    }

                    try {
                        channelsSelectedBean.getHomepage_another_channels_title()
                                .add(channelsBean.getData().getItems().get(i).getTitle());
                    } catch (NullPointerException e) {
                        channelsSelectedBean.getHomepage_another_channels_title()
                                .add(null);
                    }

                    try {
                        channelsSelectedBean.getHomepage_another_channels_like_counts_tv()
                                .add(String.valueOf(channelsBean.getData().getItems().get(i).getLikes_count()));
                    } catch (NullPointerException e) {
                        channelsSelectedBean.getHomepage_another_channels_like_counts_tv()
                                .add(null);
                    }

                }

                ChannelsAdapter channelsAdapter = new ChannelsAdapter();
                channelsAdapter.setContext(context);
                channelsAdapter.setChannelsSelectedBean(channelsSelectedBean);

                LinearLayoutManager manager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(channelsAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Log.d("AnotherChannels", "2");

        VolleySingleTon.getInstance().addQueue(stringRequest);
        Log.d("AnotherChannels", "3");

    }
}
