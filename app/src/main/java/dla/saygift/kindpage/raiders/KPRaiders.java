package dla.saygift.kindpage.raiders;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;
import dla.saygift.kindpage.KINDPAGEUrlValues;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/12.
 */
public class KPRaiders extends BaseFragment {

    private RecyclerView recyclerView;
    private KPRaidersAdapter kpRaidersAdapter;
    private Handler handler;

    @Override
    protected int setLayout() {
        return R.layout.kindpage_raiders;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.kindpage_raiders_rv);
    }

    @Override
    protected void initData() {

        kpRaidersAdapter = new KPRaidersAdapter();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                setChannels();
                return false;
            }
        });
        setSection();
    }

    protected void setSection() {

        StringRequest stringRequest = new StringRequest(KINDPAGEUrlValues.SECTION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SectionBean bean = gson.fromJson(response, SectionBean.class);
                Log.d("KPRaiders", "bean.getData().getColumns().get(2):" + bean.getData().getColumns().get(2));

                kpRaidersAdapter.setSectionBean(bean);

                handler.sendEmptyMessage(1);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }

    private void setChannels() {

        StringRequest stringRequest = new StringRequest(KINDPAGEUrlValues.CHANNELS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ChannelsBea bea = gson.fromJson(response, ChannelsBea.class);
                Log.d("KPRaiders", "bea.getData().getChannel_groups().get(2):" + bea.getData().getChannel_groups().get(2));

                kpRaidersAdapter.setChannelsBea(bea);

                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(kpRaidersAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }

}
