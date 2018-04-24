package com.mml.studyapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/15 11:40
 */

public class TSSCBean {


    private List<MuluBean> mulu;

    public List<MuluBean> getMulu() {
        return mulu;
    }

    public void setMulu(List<MuluBean> mulu) {
        this.mulu = mulu;
    }

    public static class MuluBean {
        private List<KkkBean> kkk;

        public List<KkkBean> getKkk() {
            return kkk;
        }

        public void setKkk(List<KkkBean> kkk) {
            this.kkk = kkk;
        }

        public static class KkkBean implements Serializable {
            /**
             * id : 1
             * name : 七步诗
             * article : http://121.42.12.218/guoxue/tssc/article_explain/240001/article.html
             * explain : http://121.42.12.218/guoxue/tssc/article_explain/240001/explain.html
             * translate : http://121.42.12.218/guoxue/tssc/translate_scene/240001fy.html
             * scene : http://121.42.12.218/guoxue/tssc/translate_scene/240001sx.html
             * kuozhan : http://121.42.12.218/guoxue/tssc/kuozhan/240001/index.html
             * speech : http://121.42.12.218/guoxue/tssc/speech/240001.swa
             */

            private String id;
            private String name;
            private String article;
            private String explain;
            private String translate;
            private String scene;
            private String kuozhan;
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

            public String getTranslate() {
                return translate;
            }

            public void setTranslate(String translate) {
                this.translate = translate;
            }

            public String getScene() {
                return scene;
            }

            public void setScene(String scene) {
                this.scene = scene;
            }

            public String getKuozhan() {
                return kuozhan;
            }

            public void setKuozhan(String kuozhan) {
                this.kuozhan = kuozhan;
            }

            public String getSpeech() {
                return speech;
            }

            public void setSpeech(String speech) {
                this.speech = speech;
            }
        }
    }
}
