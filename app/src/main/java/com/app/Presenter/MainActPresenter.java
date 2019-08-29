package com.app.Presenter;

import android.util.Log;

import com.app.View.MainActView;
import com.app.model.Products_Pojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;



public class MainActPresenter
{
    /**
     * ArrayList : products_arrayList
     */

    private ArrayList<Products_Pojo> products_arrayList;

    /**
     * View : MainActView
     */
    private MainActView mactView;

    /*
     * Instantiates a new MainActivity Presenter.
     *
     * @param mactView
     *     the mactView
     */

    public MainActPresenter(MainActView mactView)
    {
        this.mactView = mactView;
        products_arrayList = new ArrayList<>();
    }

    public void setAllData(JSONObject response,int pageIndex)
    {
        try
        {

//            Products_Pojo products_pojo = new Products_Pojo();
            if (response.length() >= 1) {
                if (pageIndex == 0) {
                    products_arrayList.clear();// --> Clear method is used to clear the ArrayList
                }
                try {
                    JSONObject objResult =response;
                    String batchComplete = objResult.getString("continue");
                    JSONObject objQuery=objResult.getJSONObject("query");
                    JSONObject objPages=objQuery.getJSONObject("pages");
                    for(int i = 0; i<objPages.names().length(); i++) {
                        Log.v("rahul", "key = " + objPages.names().getString(i) + " value = " + objPages.get(objPages.names().getString(i)));
                      JSONObject objPagesNo = (JSONObject) objPages.get(objPages.names().getString(i));
                        String page_id = objPagesNo.getString("pageid");
                        int ns = objPagesNo.getInt("ns");
                        String title = objPagesNo.getString("title");
                        String imageinfo = objPagesNo.getString("imageinfo");
                        JSONArray ja = new JSONArray(imageinfo);
                        JSONObject jo1 = ja.getJSONObject(0);
                        String url =jo1.getString("url");
                        String ext = "["+jo1.getString("extmetadata")+"]";
                        JSONArray ja_ext = new JSONArray(ext);
                        JSONObject jo1_ext = ja_ext.getJSONObject(0);
                        String cat = "["+jo1_ext.getString("Categories")+"]";
                        JSONArray ja_cat = new JSONArray(cat);
                        JSONObject jo1_cat = ja_cat.getJSONObject(0);
                        String desc =jo1_cat.getString("value");
                        Log.d("rahul", "title : " + title + "pageid " + page_id);
//                        Log.d("rahul", "revisionsjson " + jo1.getString("*"));
//                        products_pojo.setTitle(title);
//                        products_pojo.setDesc("");
//                        products_pojo.setId(page_id);
                        products_arrayList.add(new Products_Pojo(page_id,title,desc,url));
//                        products_arrayList.add(products_pojo);

                    }


                } catch (JSONException e) {
                    Log.d("rahulerror",""+e.getMessage()+""+e.toString());

                    e.printStackTrace();
                }

                mactView.updateData(products_arrayList);

            }

   }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
