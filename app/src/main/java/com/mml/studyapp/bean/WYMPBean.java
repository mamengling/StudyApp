package com.mml.studyapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLing on 2018/4/25 0025.
 */

public class WYMPBean {

    private ArrayList<GwrmBean> gwrm;
    private ArrayList<GwrmBean> bpbb;
    private ArrayList<GwrmBean> kzts;
    private ArrayList<GwrmBean> nlxl;

    public ArrayList<GwrmBean> getGwrm() {
        return gwrm;
    }

    public void setGwrm(ArrayList<GwrmBean> gwrm) {
        this.gwrm = gwrm;
    }

    public ArrayList<GwrmBean> getBpbb() {
        return bpbb;
    }

    public void setBpbb(ArrayList<GwrmBean> bpbb) {
        this.bpbb = bpbb;
    }

    public ArrayList<GwrmBean> getKzts() {
        return kzts;
    }

    public void setKzts(ArrayList<GwrmBean> kzts) {
        this.kzts = kzts;
    }

    public ArrayList<GwrmBean> getNlxl() {
        return nlxl;
    }

    public void setNlxl(ArrayList<GwrmBean> nlxl) {
        this.nlxl = nlxl;
    }

    public static class GwrmBean implements Parcelable {
        private List<KkkBean> kkk;

        public List<KkkBean> getKkk() {
            return kkk;
        }

        public void setKkk(List<KkkBean> kkk) {
            this.kkk = kkk;
        }

        public static class KkkBean implements Parcelable {
            /**
             * id : 1
             * name : 两小儿辩日
             * article : http://121.42.12.218/guoxue/wymp/article/320001/article.html
             * explain : http://121.42.12.218/guoxue/wymp/article/320001/explain.html
             * recite : http://121.42.12.218/guoxue/wymp/article/320001/recite.html
             * translate : http://121.42.12.218/guoxue/wymp/article/320001/translate.html
             * story : http://121.42.12.218/guoxue/wymp/kuozhan/kz_index1_1/320001.html
             * knowledge : http://121.42.12.218/guoxue/wymp/kuozhan/kz_index1_2/320001-1.html
             * practise : http://121.42.12.218/guoxue/wymp/kuozhan/kz_index1_3/320001-1.html
             * speech : http://121.42.12.218/guoxue/wymp/speech/320001.swa
             */

            private String id;
            private String name;
            private String article;
            private String explain;
            private String recite;
            private String translate;
            private String story;
            private String knowledge;
            private String practise;
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

            public String getStory() {
                return story;
            }

            public void setStory(String story) {
                this.story = story;
            }

            public String getKnowledge() {
                return knowledge;
            }

            public void setKnowledge(String knowledge) {
                this.knowledge = knowledge;
            }

            public String getPractise() {
                return practise;
            }

            public void setPractise(String practise) {
                this.practise = practise;
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
                dest.writeString(this.story);
                dest.writeString(this.knowledge);
                dest.writeString(this.practise);
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
                this.story = in.readString();
                this.knowledge = in.readString();
                this.practise = in.readString();
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

        public GwrmBean() {
        }

        protected GwrmBean(Parcel in) {
            this.kkk = in.createTypedArrayList(KkkBean.CREATOR);
        }

        public static final Creator<GwrmBean> CREATOR = new Creator<GwrmBean>() {
            @Override
            public GwrmBean createFromParcel(Parcel source) {
                return new GwrmBean(source);
            }

            @Override
            public GwrmBean[] newArray(int size) {
                return new GwrmBean[size];
            }
        };
    }


}
