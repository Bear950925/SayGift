package dla.saygift.listpage;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/11.
 */
public class LIST_URLValues {

    public static final String COLUMNS_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks";
    public static final String DAYS_RECOMMEND_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks/1?limit=20&offset=0";
    public static final String TOP_100_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks/2?limit=20&offset=0";
    public static final String INDEPENDENT_ORI_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks/3?limit=20&offset=0";
    public static final String NEW_STAR_URL = " http://api.liwushuo.com/v2/ranks_v2/ranks/4?limit=20&offset=0";

    public static final String[] LIST_URL = {DAYS_RECOMMEND_URL, TOP_100_URL, INDEPENDENT_ORI_URL, NEW_STAR_URL};

}
