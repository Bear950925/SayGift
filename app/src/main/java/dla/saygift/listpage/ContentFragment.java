package dla.saygift.listpage;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import dla.saygift.MyApp;
import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/9.
 */
public class ContentFragment extends BaseFragment {

    private ImageView imageView;
    private ArrayList<String> CoverImgs;
    private String ChannelsUrl;
    private RecyclerView recyclerView;
    private Context context;

    public void setChannelsUrl(String channelsUrl) {
        ChannelsUrl = channelsUrl;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.listpage_content;
    }

    @Override
    protected void initView() {
        imageView = bindView(R.id.listpage_content_img);
        recyclerView = bindView(R.id.listpage_content_rv);
    }

    @Override
    protected void initData() {
        setCoverImg();
    }

    private void setCoverImg() {
        StringRequest stringRequest = new StringRequest(ChannelsUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                GiftBean bean = gson.fromJson(response, GiftBean.class);

                ContentFragmentAdapter contentFragmentAdapter = new ContentFragmentAdapter();
                contentFragmentAdapter.setGiftBean(bean);
                GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
                manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return position == 0 ? 2 : 1;
                    }
                });
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(contentFragmentAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }

}
