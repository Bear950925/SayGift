package dla.saygift.search;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import dla.saygift.R;
import dla.saygift.baseclass.BaseFragmentActivity;

/**
 * Created by dllo on 16/10/18.
 */
public class searchActivity extends BaseFragmentActivity implements View.OnClickListener {

    private EditText searchEd;
    private SearchListView searchListView;
    private SearchHistory searchHistory;
    private ImageView imageView;
    private ImageView backImg;
    private boolean iscommit = false;
    private boolean isBili = false;
    private boolean isNull = false;
    private TextView deleteTv;

    @Override
    protected int setLayout() {
        return R.layout.searchview;
    }

    private FragmentManager manager;


    @Override
    protected void initView() {

        searchEd = bindView(R.id.search_ed);
        imageView = bindView(R.id.search_img);
        imageView.setVisibility(View.INVISIBLE);
        backImg = bindView(R.id.search_back_img);
        Log.d("searchActivity", "1In");
        deleteTv = bindView(R.id.search_delete_tv);

    }

    public void rePlaceFragment(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.search_frame, fragment);
        transaction.commit();
    }

    @Override
    public void initData() {

        searchListView = null;
        searchHistory = null;
        backImg.setVisibility(View.VISIBLE);
        backImg.setOnClickListener(this);

        manager = getSupportFragmentManager();

        if (searchHistory == null) {
            searchHistory = new SearchHistory();
            rePlaceFragment(searchHistory);
//            iscommit = true;
        }

        imageView.setOnClickListener(this);

        deleteTv.setOnClickListener(this);

        searchEd.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (0 == start && 0 == after) {
                    imageView.setVisibility(View.INVISIBLE);
                    isNull = true;
                } else {
                    imageView.setVisibility(View.VISIBLE);
                    isNull = false;
                }

                Log.d("searchActivity", "befor");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("searchActivity", "on");

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("searchActivity", "after");

                String strUTF8 = getUTF8(String.valueOf(s));

                if (searchListView == null) {

                    searchListView = new SearchListView(strUTF8);

                    rePlaceFragment(searchListView);

                } else {
                    searchListView.setStrUTF8(strUTF8);
                }

                if (true == isNull) {
                    searchHistory = new SearchHistory();
                    rePlaceFragment(searchHistory);
                    searchListView = null;
                }

                Log.d("searchActivity", "s:" + s);

            }
        });

    }

    public String getUTF8(String str) {
        String utf8 = null;
        try {
            utf8 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return utf8;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_img:
                searchEd.setText("");
                break;
            case R.id.search_delete_tv:
                finish();
                break;
            case R.id.search_back_img:
                SearchHistory searchHistory = new SearchHistory();
                rePlaceFragment(searchHistory);
                searchEd.setText("");
                break;
        }
    }
}
