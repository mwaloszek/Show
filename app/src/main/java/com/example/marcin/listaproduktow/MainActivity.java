package com.example.marcin.listaproduktow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcin.listaproduktow.adapter.ShopListAdapter;
import com.example.marcin.listaproduktow.data.Shop;
import com.example.marcin.listaproduktow.data.ShopList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;


import android.app.ProgressDialog;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    ListView list;

    @Bean
    ShopListAdapter adapter;

    ProgressDialog ringProgressDialog;

    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;

    @Click
    void refreshClicked()    {
        ringProgressDialog.show();
        restBackgroundTask.getShopList();
    }

    @Click
    public void addItem() {
        Intent intent = new Intent(this, AddNewItem_.class);
        startActivity(intent);
    }

    @ItemClick
    void listaClicked(Shop shop) {
        ItemDetails_.intent(this).shop(shop).start();
    }

    @AfterViews
    void init() {
        list.setAdapter(adapter);
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Loading...");
            ringProgressDialog.setIndeterminate(true);
    }

    @ItemClick
    void listItemClicked(Shop item) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show();
    }

    public void updateShoplist(ShopList shopList) {
        ringProgressDialog.dismiss();
        adapter.update(shopList);
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }



}





