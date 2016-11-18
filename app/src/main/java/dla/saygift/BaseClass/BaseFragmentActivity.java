package dla.saygift.baseclass;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by dllo on 16/9/19.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());

        initView();
        initData();

    }

    protected abstract int setLayout();

    protected abstract void initView();

    public abstract void initData();

    protected <T extends View> T bindView(int id) {
        return (T)findViewById(id);
    }
    protected <T extends View> T bindView(int id, View view) {
        return (T)view.findViewById(id);
    }

}
