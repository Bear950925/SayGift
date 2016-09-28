package dla.saygift.hompage.selected.firstbanner;

import java.util.List;

/**
 * Created by dllo on 16/9/27.
 */
public class BannerBean {

    /**
     * 轮播图接口 public static final String BANNER_URL 来自 basehomepage.URLValues;
     * public static final String BANNER_URL = "http://api.liwushuo.com/v2/banners?channel=iOS";
     */

    /**
     * code : 200
     * data : {"banners":[{"ad_monitors":[],"channel":"all","id":727,"image_url":"http://img03.liwushuo.com/image/160926/dv3mwtqob.jpg-w720","order":501,"status":0,"target":{"banner_image_url":"http://img01.liwushuo.com/image/160926/09m63zq84.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160926/09m63zq84.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img01.liwushuo.com/image/160926/8flri0x6f.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160926/8flri0x6f.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1474854917,"id":355,"posts_count":7,"status":1,"subtitle":"女神的礼物已经上线，等待开启！","title":"女神专属礼物","updated_at":1474855014},"target_id":355,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=355","type":"collection","webp_url":"http://img03.liwushuo.com/image/160926/dv3mwtqob.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":724,"image_url":"http://img03.liwushuo.com/image/160923/tjq6y9pyu.jpg-w720","order":500,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/160923/pgzl0dojk.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160923/pgzl0dojk.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160923/goy7dpn3y.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160923/goy7dpn3y.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1474629842,"id":354,"posts_count":12,"status":1,"subtitle":"十一长假：不在旅行中，就是在去旅行的路上。","title":" 长假打开方式","updated_at":1474630283},"target_id":354,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=354","type":"collection","webp_url":"http://img03.liwushuo.com/image/160923/tjq6y9pyu.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":725,"image_url":"http://img03.liwushuo.com/image/160923/mz9b3el1j.jpg-w720","order":480,"status":0,"target_id":1045871,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1045871","type":"post","webp_url":"http://img03.liwushuo.com/image/160923/mz9b3el1j.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":726,"image_url":"http://img03.liwushuo.com/image/160923/iwedeg4nk.jpg-w720","order":479,"status":0,"target_id":1045899,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1045899","type":"post","webp_url":"http://img03.liwushuo.com/image/160923/iwedeg4nk.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":719,"image_url":"http://img01.liwushuo.com/image/160918/rtqb6vho2.jpg-w720","order":450,"status":0,"target":{"banner_image_url":"http://img03.liwushuo.com/image/160918/8zjxvmbf9.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160918/8zjxvmbf9.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160918/bdzmv2wwj.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160918/bdzmv2wwj.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1474183878,"id":352,"posts_count":7,"status":1,"subtitle":"那些年秋天，这些补水神器陪我们一起度过","title":"补水护肤必备","updated_at":1474184015},"target_id":352,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=352","type":"collection","webp_url":"http://img01.liwushuo.com/image/160918/rtqb6vho2.jpg?imageView2/2/w/720/q/85/format/webp"}]}
     * message : OK
     */

    private int code;
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
         * ad_monitors : []
         * channel : all
         * id : 727
         * image_url : http://img03.liwushuo.com/image/160926/dv3mwtqob.jpg-w720
         * order : 501
         * status : 0
         * target : {"banner_image_url":"http://img01.liwushuo.com/image/160926/09m63zq84.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160926/09m63zq84.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img01.liwushuo.com/image/160926/8flri0x6f.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160926/8flri0x6f.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1474854917,"id":355,"posts_count":7,"status":1,"subtitle":"女神的礼物已经上线，等待开启！","title":"女神专属礼物","updated_at":1474855014}
         * target_id : 355
         * target_type : url
         * target_url : liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=355
         * type : collection
         * webp_url : http://img03.liwushuo.com/image/160926/dv3mwtqob.jpg?imageView2/2/w/720/q/85/format/webp
         */

        private List<BannersBean> banners;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class BannersBean {
            private String channel;
            private int id;
            private String image_url;
            private int order;
            private int status;
            /**
             * banner_image_url : http://img01.liwushuo.com/image/160926/09m63zq84.jpg-w300
             * banner_webp_url : http://img01.liwushuo.com/image/160926/09m63zq84.jpg?imageView2/2/w/300/q/85/format/webp
             * cover_image_url : http://img01.liwushuo.com/image/160926/8flri0x6f.jpg-w720
             * cover_webp_url : http://img01.liwushuo.com/image/160926/8flri0x6f.jpg?imageView2/2/w/720/q/85/format/webp
             * created_at : 1474854917
             * id : 355
             * posts_count : 7
             * status : 1
             * subtitle : 女神的礼物已经上线，等待开启！
             * title : 女神专属礼物
             * updated_at : 1474855014
             */

            private TargetBean target;
            private int target_id;
            private String target_type;
            private String target_url;
            private String type;
            private String webp_url;
            private List<?> ad_monitors;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public TargetBean getTarget() {
                return target;
            }

            public void setTarget(TargetBean target) {
                this.target = target;
            }

            public int getTarget_id() {
                return target_id;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public String getTarget_type() {
                return target_type;
            }

            public void setTarget_type(String target_type) {
                this.target_type = target_type;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }

            public static class TargetBean {
                private String banner_image_url;
                private String banner_webp_url;
                private String cover_image_url;
                private String cover_webp_url;
                private int created_at;
                private int id;
                private int posts_count;
                private int status;
                private String subtitle;
                private String title;
                private int updated_at;

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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPosts_count() {
                    return posts_count;
                }

                public void setPosts_count(int posts_count) {
                    this.posts_count = posts_count;
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
}
