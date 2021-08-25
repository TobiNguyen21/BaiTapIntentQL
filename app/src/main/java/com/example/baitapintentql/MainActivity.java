package com.example.baitapintentql;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSp;
    ArrayList<SanPham> dsSp;
    ArrayAdapter<SanPham> sanPhamArrayAdapter;
    int maGui = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSp = (ListView) findViewById(R.id.lvSp);
        dsSp = new ArrayList<>();
        dsSp.add(new SanPham("Coca", "co", 10000));
        dsSp.add(new SanPham("Pepsi", "pep", 10000));
        dsSp.add(new SanPham("Sting", "st", 9000));
        dsSp.add(new SanPham("Olong", "ol", 8500));
        dsSp.add(new SanPham("Qui nhon", "qn", 6000));
        dsSp.add(new SanPham("Tiger", "tg", 15000));
        dsSp.add(new SanPham("7up", "7u", 9000));
        dsSp.add(new SanPham("Saigon", "sg", 12000));
        dsSp.add(new SanPham("Ken", "k", 16000));
        dsSp.add(new SanPham("Bo huc", "bh", 12000));
        sanPhamArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsSp);
        lvSp.setAdapter(sanPhamArrayAdapter);

        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuGioiThieu:
                Toast.makeText(MainActivity.this, "Gioi Thieu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuHuongDan:
                Toast.makeText(MainActivity.this, "Huong Dan", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addEvents() {
        lvSp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamArrayAdapter.getItem(i);
                Intent intent = new Intent(MainActivity.this, ChiTietActivity.class);
                intent.putExtra("San Pham", sp);
                startActivityForResult(intent, maGui);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == maGui && resultCode == 115) {
            //lấy dữ liệu trả về
            SanPham sanPham = (SanPham) data.getSerializableExtra("San Pham");
            //tìm kiếm dữ liệu trong adapter để xóa nó
            for (int i = 0; i < sanPhamArrayAdapter.getCount(); i++) {
                SanPham spxoa = sanPhamArrayAdapter.getItem(i);
                if (spxoa.getMaSp().equals(sanPham.getMaSp())) {
                    sanPhamArrayAdapter.remove(spxoa);
                    break;
                }
            }
        }
    }
}