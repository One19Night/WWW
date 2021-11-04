package com.example.testconectdata.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.testconectdata.R;
import com.example.testconectdata.activity.GioHangActivity;
import com.example.testconectdata.activity.MenuActivity;
import com.example.testconectdata.model.Giohang;
import com.example.testconectdata.model.Sanpham;
import java.text.DecimalFormat;
import java.util.List;

public class NuocuongAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Sanpham> SanphamList;

    public NuocuongAdapter(MenuActivity context, int layout, List<Sanpham> sanphamList) {
        this.context = context;
        this.layout = layout;
        SanphamList = sanphamList;
    }

    @Override
    public int getCount() {
        return SanphamList.size();
    }

    @Override
    public Object getItem(int position) {
       return SanphamList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        public TextView txtTenDoUong, txtGiaSanPham, txtDungTich;
        RelativeLayout listsp;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.txtTenDoUong = view.findViewById(R.id.textviewnuocuong);
            viewHolder.txtGiaSanPham = view.findViewById(R.id.textviewgianuocuong);
            viewHolder.txtDungTich =  view.findViewById(R.id.textviewdungtich);
            viewHolder.listsp =  view.findViewById(R.id.listsp);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
            final Sanpham sanpham = (Sanpham) getItem(i);
            viewHolder.txtTenDoUong.setText(sanpham.getTendouong());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            viewHolder.txtGiaSanPham.setText(decimalFormat.format(sanpham.getGiasanpham()) + " Đ");
            viewHolder.txtDungTich.setText(String.valueOf(sanpham.getDungtich()));
            viewHolder.listsp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(context, GioHangActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("thongtinsanpham",SanphamList.get(i));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

            return view;
        }
    }