package com.example.testconectdata.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.testconectdata.R;
import com.example.testconectdata.activity.GioHangActivity;
import com.example.testconectdata.activity.MenuActivity;
import com.example.testconectdata.model.Giohang;
import com.example.testconectdata.model.Sanpham;

import java.text.DecimalFormat;
import java.util.ArrayList;
public class GiohangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arraygiohang;

    public GiohangAdapter(Context context, ArrayList<Sanpham> arraygiohang) {
        this.context = context;
        this.arraygiohang = arraygiohang;
    }

    @Override
    public int getCount() {
        return arraygiohang.size();
    }

    @Override
    public Object getItem(int i) {
        return arraygiohang.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
    public TextView txttengiohang,txtgiagiohang,txtdungtichgiohang;
    public Button btnminus,btnvalues,btnplus;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup)
    {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_giohang,null);
            viewHolder.txttengiohang = view.findViewById(R.id.textviewtengiohang);
            viewHolder.txtgiagiohang = view.findViewById(R.id.textviewgiagiohang);
            viewHolder.txtdungtichgiohang = view.findViewById(R.id.textviewdungtichgiohang);
            viewHolder.btnminus = view.findViewById(R.id.buttonminus);
            viewHolder.btnvalues = view.findViewById(R.id.buttonvalues);
            viewHolder.btnplus = view.findViewById(R.id.buttonplus);
            view.setTag(viewHolder);
        }
        else
            {
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham giohang = (Sanpham) getItem(i);
        viewHolder.txttengiohang.setText(giohang.getTendouong());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText("Giá :" + decimalFormat.format(giohang.getGiasanpham()) + " Đ");
        viewHolder.txtdungtichgiohang.setText(String.valueOf("Loại " + giohang.getDungtich()) + "ml");
        int sl = Integer.parseInt(viewHolder.btnvalues.getText().toString());
        if(sl >= 10){
            viewHolder.btnplus.setVisibility(View.INVISIBLE);
        }
        else if (sl <= 1){
        viewHolder.btnminus.setVisibility(View.INVISIBLE);
        }
        else if (sl >= 1){
            viewHolder.btnplus.setVisibility(View.VISIBLE);
            viewHolder.btnminus.setVisibility(View.VISIBLE);
        }
//        viewHolder.btnplus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            int slmoinhat = Integer.parseInt(viewHolder.btnvalues.getText().toString()) + 1 ;
//            int slht = MenuActivity.manggiohang.get(i).getSoluongsp();
//            long giaht = MenuActivity.manggiohang.get(i).getGiasp();
//            MenuActivity.manggiohang.get(i).setSoluongsp(slmoinhat);
//            long giamoinhat = ( giaht * slmoinhat) / slht ;
//            MenuActivity.manggiohang.get(i).setGiasp(giamoinhat);
//            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//            viewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat) + "Đ");
//            com.example.testconectdata.activity.GioHangActivity.EvenUltil();
//            if (slmoinhat > 9){
//                viewHolder.btnplus.setVisibility(View.INVISIBLE);
//                viewHolder.btnminus.setVisibility(View.VISIBLE);
//                viewHolder.btnvalues.setText(String.valueOf(slmoinhat));
//            }
//            else {
//                    viewHolder.btnplus.setVisibility(View.VISIBLE);
//                    viewHolder.btnminus.setVisibility(View.VISIBLE);
//                    viewHolder.btnvalues.setText(String.valueOf(slmoinhat));
//                }
//            }
//        });
//        viewHolder.btnminus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int slmoinhat = Integer.parseInt(viewHolder.btnvalues.getText().toString()) - 1 ;
//                int slht = MenuActivity.manggiohang.get(i).getSoluongsp();
//                long giaht = MenuActivity.manggiohang.get(i).getGiasp();
//                MenuActivity.manggiohang.get(i).setSoluongsp(slmoinhat);
//                long giamoinhat = ( giaht * slmoinhat) / slht ;
//                MenuActivity.manggiohang.get(i).setGiasp(giamoinhat);
//                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//                viewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat) + "Đ");
//                com.example.testconectdata.activity.GioHangActivity.EvenUltil();
//                if (slmoinhat < 2){
//                    viewHolder.btnminus.setVisibility(View.INVISIBLE);
//                    viewHolder.btnplus.setVisibility(View.VISIBLE);
//                    viewHolder.btnvalues.setText(String.valueOf(slmoinhat));
//                }
//                else {
//                    viewHolder.btnplus.setVisibility(View.VISIBLE);
//                    viewHolder.btnminus.setVisibility(View.VISIBLE);
//                    viewHolder.btnvalues.setText(String.valueOf(slmoinhat));
//                }
//            }
//        });
        return view;
    }
}
