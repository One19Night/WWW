package com.example.testconectdata.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.testconectdata.R;
import com.example.testconectdata.adapter.NuocuongAdapter;
import com.example.testconectdata.model.Giohang;
import com.example.testconectdata.model.Sanpham;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MenuActivity extends AppCompatActivity {

    String urlGetData = "http://192.168.100.6/server/test.php";
    String urlPostData = "http://192.168.100.6/server/customer.php";
    ListView lvSanpham;
    ArrayList<Sanpham>  arraySanpham;
    NuocuongAdapter adapter;
    ImageView imggiohang;
    public static ArrayList<Giohang> manggiohang ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        imggiohang = (ImageView) findViewById(R.id.img_giohang);
//        imggiohang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MenuActivity.this,GioHangActivity.class);
//                startActivity(intent);
//            }
//        });


        lvSanpham =  findViewById(R.id.listviewMenu);
        arraySanpham = new ArrayList<>();
        adapter = new NuocuongAdapter(MenuActivity.this, R.layout.dong_menu, arraySanpham);
        lvSanpham.setAdapter(adapter);
        GetData(urlGetData);
        manggiohang = new ArrayList<>();
//        if(manggiohang != null)
//        {
//
//        }
//        else {
//            manggiohang = new ArrayList<>();
//        }
   }


//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            getMenuInflater().inflate(R.menu.menu,menu);
//            return true;
//        }
//    @Override
//    public boolean onOptionsItemSelected(String urlPostData) {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlPostData,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String s) {
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//
//                    }
//                }
//        ){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("tendouong" , "");
//                params.put("giasanpham" , "");
//                params.put("dungtich" , "");
//                params.put("soluong" , "");
//                return params;
//            }
//        };
//        requestQueue.add(stringRequest);
//        return false;
//    }
//private void CactchOnItemListView() {
//    lvgiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//        @Override
//        public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(GioHangActivity.this);
//            builder.setTitle("Xác nhận mua sản phẩm");
//            builder.setMessage("Bạn có chắc muốn xóa sản phẩm này !");
//            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    if (MenuActivity.manggiohang.size() <=0){
//                        txtthongbao.setVisibility(View.VISIBLE);
//                    }
//                    else {
//                        MenuActivity.manggiohang.remove(position);
//                        giohangAdapter.notifyDataSetChanged();
//                        EvenUltil();
//                        if (MenuActivity.manggiohang.size() <=0 ){
//                            txtthongbao.setVisibility(View.VISIBLE);
//                        }
//                        else {
//
//                            txtthongbao.setVisibility(View.INVISIBLE);
//                            giohangAdapter.notifyDataSetChanged();
//                            EvenUltil();
//                        }
//                    }
//                }
//            });
//            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    giohangAdapter.notifyDataSetChanged();
//                    EvenUltil();
//                }
//            });
//            builder.show();
//            return true;
//        }
//    });
//}
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void  GetData(String urlGetData)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i =0; i<response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arraySanpham.add(new Sanpham(
                                        object.getInt("ID"),
                                        object.getString("TenDoUong"),
                                        object.getInt("GiaSanPham"),
                                        object.getInt("DungTich")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MenuActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
