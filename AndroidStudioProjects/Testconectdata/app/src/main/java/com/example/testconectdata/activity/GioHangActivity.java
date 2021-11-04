package com.example.testconectdata.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.testconectdata.R;
import com.example.testconectdata.adapter.GiohangAdapter;
import com.example.testconectdata.adapter.NuocuongAdapter;
import com.example.testconectdata.model.Giohang;
import com.example.testconectdata.model.Sanpham;
import com.example.testconectdata.ultil.CheckConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    String urlGetData = "http://192.168.3.161/server/customer.php";
    ListView lvgiohang;
    TextView txtthongbao;
    static TextView txttongtien;
    Button btnthanhtoan,btntieptucmua;
    Toolbar toolbargiohang;
    GiohangAdapter giohangAdapter;
    ArrayList<Sanpham>  manggiohang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        lvgiohang =  findViewById(R.id.listviewgiohang);
        manggiohang = new ArrayList<>();
        giohangAdapter = new GiohangAdapter(GioHangActivity.this, manggiohang);
        lvgiohang.setAdapter(giohangAdapter);
        Anhxa();
        //GetData(urlGetData);
        //CheckData();
        ContinueMenu();
        EvenUltil();
        CactchOnItemListView();
        Sanpham sp = (Sanpham) getIntent().getExtras().getSerializable("thongtinsanpham");
        manggiohang.add(new Sanpham( sp.getId(), sp.getTendouong(), sp.getGiasanpham(), sp.getDungtich()));
        giohangAdapter.notifyDataSetChanged();
    }

//    private void GetData(String urlGetData) {
//        {
//            RequestQueue requestQueue = Volley.newRequestQueue(this);
//            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData, null,
//                    new Response.Listener<JSONArray>() {
//                        @Override
//                        public void onResponse(JSONArray response) {
//                            for (int i =0; i<response.length(); i++){
//                                try {
//                                    JSONObject object = response.getJSONObject(i);
//                                    manggiohang.add(new Sanpham(
//                                            object.getInt("ID"),
//                                            object.getString("TenDoUong"),
//                                            object.getInt("GiaSanPham"),
//                                            object.getInt("DungTich")
//                                    ));
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            giohangAdapter.notifyDataSetChanged();
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(GioHangActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//            );
//            requestQueue.add(jsonArrayRequest);
//        }
//    }
    private void CactchOnItemListView() {
        lvgiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GioHangActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này !");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (MenuActivity.manggiohang.size() <=0){
                            txtthongbao.setVisibility(View.VISIBLE);
                        }
                        else {
                            MenuActivity.manggiohang.remove(position);
                            giohangAdapter.notifyDataSetChanged();
                            EvenUltil();
                            if (MenuActivity.manggiohang.size() <=0 ){
                                txtthongbao.setVisibility(View.VISIBLE);
                            }
                            else {

                                txtthongbao.setVisibility(View.INVISIBLE);
                                giohangAdapter.notifyDataSetChanged();
                                EvenUltil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        giohangAdapter.notifyDataSetChanged();
                        EvenUltil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static void EvenUltil() {
        long tongtien = 0;
        for (int i = 0 ;i<MenuActivity.manggiohang.size();i++)
        {
            tongtien += MenuActivity.manggiohang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien)+ "Đ");
    }

    private void ContinueMenu() {
        btntieptucmua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(GioHangActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
            });
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if ( MenuActivity.manggiohang.size() >0) {
            Log.d("///////",manggiohang.size() + "");
                Intent intent = new Intent(GioHangActivity.this, ThongTinKhachHangActivity.class);
                startActivity(intent);
            }
            else {
                CheckConnection.ShowToast_Short(getApplicationContext(), "Giỏ hàng của bạn đang trống !");
            }
        }
    });
}
    private void CheckData() {
        if(MenuActivity.manggiohang.size() <=0)
        {
            giohangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.VISIBLE);
            lvgiohang.setVisibility(View.INVISIBLE);
        }
        else {
            giohangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.INVISIBLE);
            lvgiohang.setVisibility(View.VISIBLE);
        }
    }


    private void Anhxa() {
        lvgiohang = findViewById(R.id.listviewgiohang);
        txtthongbao = findViewById(R.id.textviewthongbao);
        txttongtien = findViewById(R.id.textviewtongtien);
        btnthanhtoan = findViewById(R.id.buttonthanhtoangiohang);
        btntieptucmua = findViewById(R.id.buttontieptucmuahang);
        giohangAdapter = new GiohangAdapter(GioHangActivity.this,manggiohang);
        lvgiohang.setAdapter(giohangAdapter);
    }
}
