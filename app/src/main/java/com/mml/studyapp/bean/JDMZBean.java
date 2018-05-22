package com.mml.studyapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLing on 2018/5/22 0022.
 */

public class JDMZBean {

    private ArrayList<JdmzBean> jdmz;

    public ArrayList<JdmzBean> getJdmz() {
        return jdmz;
    }

    public void setJdmz(ArrayList<JdmzBean> jdmz) {
        this.jdmz = jdmz;
    }

    public static class JdmzBean implements Parcelable{
        /**
         * mulu : 儿童经典
         * detail : [{"id":"1","name":"伊索寓言","img":"http://121.42.12.218/guoxue/jdmz//img/1.1.png","article":"http://121.42.12.218/guoxue/jdmz//etjd/1.1/index.html"},{"id":"2","name":"安徒生童话","img":"http://121.42.12.218/guoxue/jdmz//img/1.2.png","article":"http://121.42.12.218/guoxue/jdmz//etjd/1.2/index.html"},{"id":"3","name":"格列佛游记","img":"http://121.42.12.218/guoxue/jdmz//img/1.3.png","article":"http://121.42.12.218/guoxue/jdmz//etjd/1.3/index.html"}]
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
             * name : 伊索寓言
             * img : http://121.42.12.218/guoxue/jdmz//img/1.1.png
             * article : http://121.42.12.218/guoxue/jdmz//etjd/1.1/index.html
             */

            private String id;
            private String name;
            private String img;
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
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
                dest.writeString(this.img);
                dest.writeString(this.article);
            }

            public DetailBean() {
            }

            protected DetailBean(Parcel in) {
                this.id = in.readString();
                this.name = in.readString();
                this.img = in.readString();
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

        public JdmzBean() {
        }

        protected JdmzBean(Parcel in) {
            this.mulu = in.readString();
            this.detail = new ArrayList<DetailBean>();
            in.readList(this.detail, DetailBean.class.getClassLoader());
        }

        public static final Creator<JdmzBean> CREATOR = new Creator<JdmzBean>() {
            @Override
            public JdmzBean createFromParcel(Parcel source) {
                return new JdmzBean(source);
            }

            @Override
            public JdmzBean[] newArray(int size) {
                return new JdmzBean[size];
            }
        };
    }
}
