package com.app.model;


/**
 *
 */
public class Products_Pojo
{


    private String title,desc,id,img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDesc() {
    return desc;
}

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Products_Pojo(String id1, String t1, String d1,String img1)    {
        id=id1;
        title=t1;
        desc=d1;
       img =img1;
    }

    public String getImage() {
       return img;
    }
}
