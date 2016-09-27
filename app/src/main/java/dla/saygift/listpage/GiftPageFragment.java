package dla.saygift.listpage;

import android.widget.TextView;

import dla.saygift.baseclass.BaseFragment;
import dla.saygift.R;

/**
 * Created by dllo on 16/9/20.
 */
public class GiftPageFragment extends BaseFragment {

    private TextView textView;

    @Override
    protected int setLayout() {
        return R.layout.listpage;
    }

    @Override
    protected void initView() {
        textView = bindView(R.id.listpage_tv);
    }

    @Override
    protected void initData() {

    }
}
