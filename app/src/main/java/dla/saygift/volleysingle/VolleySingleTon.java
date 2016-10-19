package dla.saygift.volleysingle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by dllo on 16/9/27.
 */
public class VolleySingleTon {

    private static VolleySingleTon volleySingleTon;
    private RequestQueue requestQueue;

    private VolleySingleTon() {
        requestQueue = Volley.newRequestQueue(MyApp.getmContext());
    }

    public static VolleySingleTon getInstance() {
        if (volleySingleTon == null) {
            synchronized (VolleySingleTon.class) {
                if (volleySingleTon == null) {
                    volleySingleTon = new VolleySingleTon();
                }
            }
        }
        return volleySingleTon;
    }

    public void addQueue(Request request) {
        requestQueue.add(request);
    }

}
