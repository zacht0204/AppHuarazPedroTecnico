package com.huaraz.luis.apphuarazTecnico.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.huaraz.luis.apphuarazTecnico.Model.Store;
import com.huaraz.luis.apphuarazTecnico.R;

import java.util.List;

/**
 * Created by java on 07/12/2016.
 */

public class StoreAdapter extends ArrayAdapter<Store> {

    String name=null;

    public List<Store> list;

    public StoreAdapter(Context context, List<Store> objects) {
        super(context, 0, objects);
        list = objects;
    }

    @Override
    public Store getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.lista_store,
                    parent,
                    false);


        holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
        holder.phone = (TextView) convertView.findViewById(R.id.phone);
        holder.address = (TextView) convertView.findViewById(R.id.phone0);


        convertView.setTag(holder);
        }else{
            holder= (ViewHolder)convertView.getTag();
        }

        // Lead actual.
        Store pet = getItem(position);


        // Configuracion
        /*
        String foto=pet.getPicture();
        if(foto!=null){
        // Receiving side
        byte[] data1 = Base64.decode(foto, Base64.DEFAULT);
        String text1 = null;
        try {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
            holder.photo.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
        /*
        Picasso.with(getContext())
                .load("http://findmewebapp-eberttoribioupc.c9.io/system/pets/photos/000/000/0"+pet.getId()+"/thumb/"+pet.getPhotoFileName())
                .resize(120, 120)
                .into( holder.photo);*/
        holder.name.setText(pet.getName());
        holder.phone.setText(pet.getPhone());
        holder.address.setText(pet.getAddress());


     /*
        holder.sal_disp.setText(cuenta.getSaldo());
        holder.fecha_aper.setText(cuenta.getFechaApertura());
        holder.fecha_ult.setText(cuenta.getFechaUltimoMovimiento());
        holder.est_cuenta.setText(cuenta.getEstado());*/


        return convertView;
    }

    static class ViewHolder {

        TextView name;
        TextView phone;
        TextView address ;

    }
}
