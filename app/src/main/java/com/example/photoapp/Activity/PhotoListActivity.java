package com.example.photoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.photoapp.Modal.PhotoList;
import com.example.photoapp.Adapter.PhotoListAdapter;
import com.example.photoapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhotoListActivity extends AppCompatActivity {
    List<PhotoList> list;
    PhotoListAdapter adapter;
    RecyclerView recyclerView;
    Context ctx;
    String url="https://jsonplaceholder.typicode.com/photos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
        ctx =  getApplicationContext();
        list=new ArrayList<>(); //intializing a list

        // intializing recyclerView
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //function call for fetching photos
        getPhoto();
    }

    public void getPhoto(){
        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                    for(int i=0;i<response.length();i++){
                        JSONObject o = response.getJSONObject(i);
                        PhotoList l = new PhotoList(
                                o.getString("albumId"),
                                o.getString("title"),
                                o.getString("thumbnailUrl"),
                                o.getString("url")
                        );
                        list.add(l);
                    }
                    adapter = new PhotoListAdapter(list,ctx);
                    recyclerView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}