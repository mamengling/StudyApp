package com.mml.studyapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLing on 2018/5/10 0010.
 */

public class GXJDBean {

    private ArrayList<QmdwBean> qmdw;
    private ArrayList<QmdwBean> sxyd;

    public ArrayList<QmdwBean> getQmdw() {
        return qmdw;
    }

    public void setQmdw(ArrayList<QmdwBean> qmdw) {
        this.qmdw = qmdw;
    }

    public ArrayList<QmdwBean> getSxyd() {
        return sxyd;
    }

    public void setSxyd(ArrayList<QmdwBean> sxyd) {
        this.sxyd = sxyd;
    }

    public static class QmdwBean implements Parcelable{
        /**
         * mulu : 三字经
         * detail : [{"kkk":[{"id":"1","name":"三字经","article":"http://121.42.12.218/guoxue/gxjd/article/310001/article.html","explain":"http://121.42.12.218/guoxue/gxjd/article/310001/explain.html","recite":"http://121.42.12.218/guoxue/gxjd/article/310001/recite.html","translate":"http://121.42.12.218/guoxue/gxjd/article/310001/translate.html","works":"http://121.42.12.218/guoxue/gxjd/kuozhan/kz1/310001zp.html","author":"http://121.42.12.218/guoxue/gxjd/kuozhan/kz2/310001zz.html","speech":"http://121.42.12.218/guoxue/gxjd/speech/310001.swa"}]}]
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
            private ArrayList<KkkBean> kkk;

            public ArrayList<KkkBean> getKkk() {
                return kkk;
            }

            public void setKkk(ArrayList<KkkBean> kkk) {
                this.kkk = kkk;
            }

            public static class KkkBean implements Parcelable{
                /**
                 * id : 1
                 * name : 三字经
                 * article : http://121.42.12.218/guoxue/gxjd/article/310001/article.html
                 * explain : http://121.42.12.218/guoxue/gxjd/article/310001/explain.html
                 * recite : http://121.42.12.218/guoxue/gxjd/article/310001/recite.html
                 * translate : http://121.42.12.218/guoxue/gxjd/article/310001/translate.html
                 * works : http://121.42.12.218/guoxue/gxjd/kuozhan/kz1/310001zp.html
                 * author : http://121.42.12.218/guoxue/gxjd/kuozhan/kz2/310001zz.html
                 * speech : http://121.42.12.218/guoxue/gxjd/speech/310001.swa
                 */

                private String id;
                private String name;
                private String article;
                private String explain;
                private String recite;
                private String translate;
                private String works;
                private String author;
                private String speech;

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

                public String getExplain() {
                    return explain;
                }

                public void setExplain(String explain) {
                    this.explain = explain;
                }

                public String getRecite() {
                    return recite;
                }

                public void setRecite(String recite) {
                    this.recite = recite;
                }

                public String getTranslate() {
                    return translate;
                }

                public void setTranslate(String translate) {
                    this.translate = translate;
                }

                public String getWorks() {
                    return works;
                }

                public void setWorks(String works) {
                    this.works = works;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getSpeech() {
                    return speech;
                }

                public void setSpeech(String speech) {
                    this.speech = speech;
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
                    dest.writeString(this.explain);
                    dest.writeString(this.recite);
                    dest.writeString(this.translate);
                    dest.writeString(this.works);
                    dest.writeString(this.author);
                    dest.writeString(this.speech);
                }

                public KkkBean() {
                }

                protected KkkBean(Parcel in) {
                    this.id = in.readString();
                    this.name = in.readString();
                    this.article = in.readString();
                    this.explain = in.readString();
                    this.recite = in.readString();
                    this.translate = in.readString();
                    this.works = in.readString();
                    this.author = in.readString();
                    this.speech = in.readString();
                }

                public static final Creator<KkkBean> CREATOR = new Creator<KkkBean>() {
                    @Override
                    public KkkBean createFromParcel(Parcel source) {
                        return new KkkBean(source);
                    }

                    @Override
                    public KkkBean[] newArray(int size) {
                        return new KkkBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeTypedList(this.kkk);
            }

            public DetailBean() {
            }

            protected DetailBean(Parcel in) {
                this.kkk = in.createTypedArrayList(KkkBean.CREATOR);
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
            dest.writeTypedList(this.detail);
        }

        public QmdwBean() {
        }

        protected QmdwBean(Parcel in) {
            this.mulu = in.readString();
            this.detail = in.createTypedArrayList(DetailBean.CREATOR);
        }

        public static final Creator<QmdwBean> CREATOR = new Creator<QmdwBean>() {
            @Override
            public QmdwBean createFromParcel(Parcel source) {
                return new QmdwBean(source);
            }

            @Override
            public QmdwBean[] newArray(int size) {
                return new QmdwBean[size];
            }
        };
    }
}
