package com.nghia.pvn.tuan_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class ChiTieuAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<ChiTieu> arrayChiTieu;

    public ChiTieuAdapter(Context myContext, int myLayout, List<ChiTieu> arrayChiTieu) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayChiTieu = arrayChiTieu;
    }

    @Override
    public int getCount() {
        return arrayChiTieu.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayChiTieu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class  ViewHolder{
        TextView txtTen,txtPhi, txtGhiChu;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview=convertView;
        ViewHolder holder=new ViewHolder();

        if (rowview==null){
            rowview=inflater.inflate(myLayout,null);
            holder.txtTen=(TextView) rowview.findViewById(R.id.textviewTen);
            holder.txtPhi=(TextView) rowview.findViewById(R.id.textviewChiPhi);
            holder.txtGhiChu=(TextView) rowview.findViewById(R.id.textviewGhiChu);
            rowview.setTag(holder);

        }else {
            holder= (ViewHolder) rowview.getTag();
        }

        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");

        holder.txtTen.setText(arrayChiTieu.get(position).Ten);
        holder.txtPhi.setText(decimalFormat.format(arrayChiTieu.get(position).ChiPhi)+"VDN");
        holder.txtGhiChu.setText(arrayChiTieu.get(position).GhiChu);


        return rowview;
    }
}
