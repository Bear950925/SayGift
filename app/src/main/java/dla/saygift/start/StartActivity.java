package dla.saygift.start;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import dla.saygift.baseclass.BaseFragmentActivity;
import dla.saygift.R;

public class StartActivity extends BaseFragmentActivity {

    private ImageView startImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        startImg = bindView(R.id.startImg);
    }

    @Override
    public void initData() {
        MyStartAsyncTask myStartAsyncTask = new MyStartAsyncTask();
    }

    private class MyStartAsyncTask extends AsyncTask<String, Integer, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            return null;
        }
    }
}
