package dla.saygift.kindpage.raiders;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragmentActivity;
import dla.saygift.kindpage.KINDPAGEUrlValues;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/10/17.
 */
public class AllChannelsActivity extends BaseFragmentActivity {

    private TextView textView;
    private RecyclerView recyclerView;

    @Override
    protected int setLayout() {
        return R.layout.kindpage_r_allchannels;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.kindpage_r_allchannels_rv);
        textView = (TextView) findViewById(R.id.kindpage_r_allchannels_tv);
    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        ArrayList<String> imgUrls = intent.getStringArrayListExtra("channelsBea");
        textView.setText(imgUrls.get(imgUrls.size() - 1));
        AllChannelsAdapter allChannelsAdapter = new AllChannelsAdapter();
        allChannelsAdapter.setImgUrls(imgUrls);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(allChannelsAdapter);


    }
}
