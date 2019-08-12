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

            Products_Pojo products_pojo = new Products_Pojo();
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
                        String revisions = objPagesNo.getString("revisions");
                        JSONArray ja = new JSONArray(revisions);
                        JSONObject jo1 = ja.getJSONObject(0);
                        Log.d("rahul", "title : " + title + "pageid " + page_id);
                        Log.d("rahul", "revisionsjson " + jo1.getString("*"));
                        String desc =jo1.getString("*");
                        products_pojo.setTitle(title);
                        products_pojo.setDesc(desc);
                        products_pojo.setId(page_id);
                    }


                } catch (JSONException e) {
                    Log.d("rahulerror",""+e.getMessage()+""+e.toString());

                    e.printStackTrace();
                }

                products_arrayList.add(products_pojo);
                mactView.updateData(products_arrayList);
            }

   }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
