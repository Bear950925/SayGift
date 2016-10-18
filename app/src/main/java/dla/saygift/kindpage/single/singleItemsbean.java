package dla.saygift.kindpage.single;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/15.
 */
public class singleItemsbean {

    private ArrayList<String> categoryName = new ArrayList<>();

    public ArrayList<String> getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(ArrayList<String> category) {
        this.categoryName = category;
    }

    private ArrayList<String> categoryUrl = new ArrayList<>();

    public ArrayList<String> getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(ArrayList<String> categoryUrl) {
        this.categoryUrl = categoryUrl;
    }
}
