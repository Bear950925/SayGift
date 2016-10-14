package dla.saygift.kindpage.raiders;

import java.util.List;

/**
 * Created by dllo on 16/10/13.
 */
public class SectionBean {


    /*
    * *
     * code : 200
     * data : {"columns":[{"author":"美少女大人","banner_image_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img01.liwushuo.com/image/160902/ostfcv54z.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160902/ostfcv54z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472812805,"description":"史上最实用又超级简单易懂的直男穿搭术。拯救直男审美，让你撩妹更轻松。","id":104,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"穿衣指「男」","updated_at":1476281344},{"author":"Dr.Bag","banner_image_url":"http://img02.liwushuo.com/image/160608/0gc251s33.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/0gc251s33.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501739,"description":"没有什么是一个包包解决不了的，如果有，那就两个。","id":16,"order":0,"post_published_at":1476090000,"status":0,"subtitle":"","title":"包治百病","updated_at":1476266680},{"author":"穿衣大队长","banner_image_url":"http://img02.liwushuo.com/image/160608/ygqtl238c.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/ygqtl238c.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501669,"description":"做你的私人搭配师，每日搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"明天穿什么","updated_at":1476265321},{"author":"鹿欧尼","banner_image_url":"http://img02.liwushuo.com/image/160630/npssjj3yc.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160630/npssjj3yc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img01.liwushuo.com/image/160713/l0nb4kpud.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/l0nb4kpud.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467265951,"description":"无论是山珍海味还是街边小吃，\r\n无论是飞禽走兽还是五谷香料，\r\n美食不分贵贱没有国界\r\n我们都犯着一种罪，叫做\u201c食宗最\u201d","id":83,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"吃货俱乐部","updated_at":1476264479},{"author":"叫我小公举","banner_image_url":"http://img02.liwushuo.com/image/160608/muk9fdsya.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/muk9fdsya.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img01.liwushuo.com/image/160713/1p98sh06h.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/1p98sh06h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501717,"description":"僻静的街角有一家杂货铺，或许你带着忧愁走进店中，但不期而遇的小物却让你展露欢颜。","id":14,"order":0,"post_published_at":1476176400,"status":0,"subtitle":"","title":"解忧杂货铺","updated_at":1476264349},{"author":"礼帮主","banner_image_url":"http://img01.liwushuo.com/image/160905/dask3xap6.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160905/dask3xap6.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472808060,"description":"追女生、送父母、找基友，最全最优送礼指南，从此送礼不操心","id":102,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"礼物帮兄","updated_at":1476264287},{"author":"文具菌","banner_image_url":"http://img01.liwushuo.com/image/160912/s9vu7wxnb.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160912/s9vu7wxnb.jpg?imageView2/2/w/300/q/85/format/webp","category":"爱读书","cover_image_url":"http://img02.liwushuo.com/image/160912/lb2cgsotg.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160912/lb2cgsotg.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473643494,"description":"一个任由文具控种草、拔草的集合地，每周安利给最爱文具的你。\r\n","id":108,"order":0,"post_published_at":1476263748,"status":0,"subtitle":"","title":"文具集中营","updated_at":1476263748},{"author":"Miss. talk ","banner_image_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462771521,"description":"同一件事，你怎么想，他怎么看，平行生活里的你我他，也许正经历同样的情绪，分享着类似的槽点，不管你是围观的吃瓜群众，还是森森被困扰的当事人甲，在shall we talk里，和Miss. talk一起聚众吐槽吧~  ","id":24,"order":0,"post_published_at":1476273600,"status":0,"subtitle":"","title":"Shall we talk","updated_at":1476263508},{"author":"灰姑娘","banner_image_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1476241200,"status":0,"subtitle":"","title":"靠脸吃饭","updated_at":1476259394},{"author":"资优生","banner_image_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467340938,"description":"iPhone腿、A4腰、锁骨放硬币、反手摸肚脐\r\n没有最严苛的审美，只有最病态的减肥！\r\n还是既健康又美丽来的实际！","id":85,"order":0,"post_published_at":1469934000,"status":0,"subtitle":"更新至第5期","title":"美体日记","updated_at":1476259305},{"author":"上上签","banner_image_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1476241200,"status":0,"subtitle":"","title":"日复一签","updated_at":1476256358}],"paging":{"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}}
     * message : OK
     */

    private int code;
    /**
     * columns : [{"author":"美少女大人","banner_image_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img01.liwushuo.com/image/160902/ostfcv54z.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160902/ostfcv54z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472812805,"description":"史上最实用又超级简单易懂的直男穿搭术。拯救直男审美，让你撩妹更轻松。","id":104,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"穿衣指「男」","updated_at":1476281344},{"author":"Dr.Bag","banner_image_url":"http://img02.liwushuo.com/image/160608/0gc251s33.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/0gc251s33.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501739,"description":"没有什么是一个包包解决不了的，如果有，那就两个。","id":16,"order":0,"post_published_at":1476090000,"status":0,"subtitle":"","title":"包治百病","updated_at":1476266680},{"author":"穿衣大队长","banner_image_url":"http://img02.liwushuo.com/image/160608/ygqtl238c.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/ygqtl238c.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501669,"description":"做你的私人搭配师，每日搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"明天穿什么","updated_at":1476265321},{"author":"鹿欧尼","banner_image_url":"http://img02.liwushuo.com/image/160630/npssjj3yc.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160630/npssjj3yc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img01.liwushuo.com/image/160713/l0nb4kpud.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/l0nb4kpud.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467265951,"description":"无论是山珍海味还是街边小吃，\r\n无论是飞禽走兽还是五谷香料，\r\n美食不分贵贱没有国界\r\n我们都犯着一种罪，叫做\u201c食宗最\u201d","id":83,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"吃货俱乐部","updated_at":1476264479},{"author":"叫我小公举","banner_image_url":"http://img02.liwushuo.com/image/160608/muk9fdsya.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/muk9fdsya.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img01.liwushuo.com/image/160713/1p98sh06h.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/1p98sh06h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501717,"description":"僻静的街角有一家杂货铺，或许你带着忧愁走进店中，但不期而遇的小物却让你展露欢颜。","id":14,"order":0,"post_published_at":1476176400,"status":0,"subtitle":"","title":"解忧杂货铺","updated_at":1476264349},{"author":"礼帮主","banner_image_url":"http://img01.liwushuo.com/image/160905/dask3xap6.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160905/dask3xap6.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472808060,"description":"追女生、送父母、找基友，最全最优送礼指南，从此送礼不操心","id":102,"order":0,"post_published_at":1476316800,"status":0,"subtitle":"","title":"礼物帮兄","updated_at":1476264287},{"author":"文具菌","banner_image_url":"http://img01.liwushuo.com/image/160912/s9vu7wxnb.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160912/s9vu7wxnb.jpg?imageView2/2/w/300/q/85/format/webp","category":"爱读书","cover_image_url":"http://img02.liwushuo.com/image/160912/lb2cgsotg.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160912/lb2cgsotg.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473643494,"description":"一个任由文具控种草、拔草的集合地，每周安利给最爱文具的你。\r\n","id":108,"order":0,"post_published_at":1476263748,"status":0,"subtitle":"","title":"文具集中营","updated_at":1476263748},{"author":"Miss. talk ","banner_image_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462771521,"description":"同一件事，你怎么想，他怎么看，平行生活里的你我他，也许正经历同样的情绪，分享着类似的槽点，不管你是围观的吃瓜群众，还是森森被困扰的当事人甲，在shall we talk里，和Miss. talk一起聚众吐槽吧~  ","id":24,"order":0,"post_published_at":1476273600,"status":0,"subtitle":"","title":"Shall we talk","updated_at":1476263508},{"author":"灰姑娘","banner_image_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1476241200,"status":0,"subtitle":"","title":"靠脸吃饭","updated_at":1476259394},{"author":"资优生","banner_image_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467340938,"description":"iPhone腿、A4腰、锁骨放硬币、反手摸肚脐\r\n没有最严苛的审美，只有最病态的减肥！\r\n还是既健康又美丽来的实际！","id":85,"order":0,"post_published_at":1469934000,"status":0,"subtitle":"更新至第5期","title":"美体日记","updated_at":1476259305},{"author":"上上签","banner_image_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1476241200,"status":0,"subtitle":"","title":"日复一签","updated_at":1476256358}]
     * paging : {"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}
     */

    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * next_url : http://api.liwushuo.com/v2/columns?limit=11&offset=11
         */

        private PagingBean paging;
        /**
         * author : 美少女大人
         * banner_image_url : http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg-w300
         * banner_webp_url : http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg?imageView2/2/w/300/q/85/format/webp
         * category : 穿搭
         * cover_image_url : http://img01.liwushuo.com/image/160902/ostfcv54z.jpg-w720
         * cover_webp_url : http://img01.liwushuo.com/image/160902/ostfcv54z.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1472812805
         * description : 史上最实用又超级简单易懂的直男穿搭术。拯救直男审美，让你撩妹更轻松。
         * id : 104
         * order : 0
         * post_published_at : 1476316800
         * status : 0
         * subtitle :
         * title : 穿衣指「男」
         * updated_at : 1476281344
         */

        private List<ColumnsBean> columns;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<ColumnsBean> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnsBean> columns) {
            this.columns = columns;
        }

        public static class PagingBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ColumnsBean {
            private String author;
            private String banner_image_url;
            private String banner_webp_url;
            private String category;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private String description;
            private int id;
            private int order;
            private int post_published_at;
            private int status;
            private String subtitle;
            private String title;
            private int updated_at;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getBanner_webp_url() {
                return banner_webp_url;
            }

            public void setBanner_webp_url(String banner_webp_url) {
                this.banner_webp_url = banner_webp_url;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getCover_webp_url() {
                return cover_webp_url;
            }

            public void setCover_webp_url(String cover_webp_url) {
                this.cover_webp_url = cover_webp_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getPost_published_at() {
                return post_published_at;
            }

            public void setPost_published_at(int post_published_at) {
                this.post_published_at = post_published_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
