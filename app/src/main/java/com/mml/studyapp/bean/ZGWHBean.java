package com.mml.studyapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLing on 2018/5/23 0023.
 */

public class ZGWHBean {

    private ArrayList<WhzdBean> whzd;

    public ArrayList<WhzdBean> getWhzd() {
        return whzd;
    }

    public void setWhzd(ArrayList<WhzdBean> whzd) {
        this.whzd = whzd;
    }

    public static class WhzdBean implements Parcelable{
        /**
         * mulu : 文化制度全景
         * detail : [{"id":"1","name":"古代礼制与官制","article":"http://121.42.12.218/guoxue/zgwh//whzdhtm/lzygz/nr/index.html"},{"id":"2","name":"古代教育与科举","article":"http://121.42.12.218/guoxue/zgwh//whzdhtm/gdjy/nr/index.html"},{"id":"3","name":"古代姓名和称谓","article":"http://121.42.12.218/guoxue/zgwh//whzdhtm/xmycw/index.html"},{"id":"4","name":"古代天文和历法","article":"http://121.42.12.218/guoxue/zgwh//whzdhtm/twlf/index.html"}]
         */

        private String mulu;
        private ArrayList<DetailBean> detail;

        public String getMulu() {
            return mulu;
        }

        public void setMulu(String mulu) {
            this.mulu = mulu;
        }

        public ArrayList<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(ArrayList<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean implements Parcelable{
            /**
             * id : 1
             * name : 古代礼制与官制
             * article : http://121.42.12.218/guoxue/zgwh//whzdhtm/lzygz/nr/index.html
             */

            private String id;
            private String name;
            private String article;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getArticle() {
                return article;
            }

            public void setArticle(String article) {
                this.article = article;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.name);
                dest.writeString(this.article);
            }

            public DetailBean() {
            }

            protected DetailBean(Parcel in) {
                this.id = in.readString();
                this.name = in.readString();
                this.article = in.readString();
            }

            public static final Creator<DetailBean> CREATOR = new Creator<DetailBean>() {
                @Override
                public DetailBean createFromParcel(Parcel source) {
                    return new DetailBean(source);
                }

                @Override
                public DetailBean[] newArray(int size) {
                    return new DetailBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.mulu);
            dest.writeList(this.detail);
        }

        public WhzdBean() {
        }

        protected WhzdBean(Parcel in) {
            this.mulu = in.readString();
            this.detail = new ArrayList<DetailBean>();
            in.readList(this.detail, DetailBean.class.getClassLoader());
        }

        public static final Creator<WhzdBean> CREATOR = new Creator<WhzdBean>() {
            @Override
            public WhzdBean createFromParcel(Parcel source) {
                return new WhzdBean(source);
            }

            @Override
            public WhzdBean[] newArray(int size) {
                return new WhzdBean[size];
            }
        };
    }
}
