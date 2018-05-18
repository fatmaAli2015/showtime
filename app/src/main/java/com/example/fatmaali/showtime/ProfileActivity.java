package com.example.fatmaali.showtime;


import android.app.SearchManager;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    int images[] = {R.drawable.cimg1, R.drawable.cimg3, R.drawable.cimg5, R.drawable.cimg6,
            R.drawable.cimg7, R.drawable.cimg2, R.drawable.cimg4};
    //  List<Integer> listImage = new ArrayList<>();
    ScrollView scrollView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10.f);
        }

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(images, this);
        gridView.setAdapter(gridViewAdapter);
        setDynamicHeight(gridView);

        scrollView.post(new Runnable() {
            public void run() {
                scrollView.fullScroll(scrollView.FOCUS_UP);
                scrollView.pageScroll(View.FOCUS_UP);
            }
        });


    }

    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "you are pressed back", Toast.LENGTH_LONG);
    }

    private void setDynamicHeight(GridView gridView) {
        ListAdapter gridViewAdapter = gridView.getAdapter();
        if (gridViewAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int items = gridViewAdapter.getCount();
        int rows = 0;

        View listItem = gridViewAdapter.getView(0, null, gridView);
        listItem.measure(0, 0);
        totalHeight = listItem.getMeasuredHeight();

        float x = 1;
        if (items > 5) {
            x = items / 5;
            rows = (int) (x + 1);
            totalHeight *= rows;
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));
//        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) ProfileActivity.this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.app_bar_search) {
            Toast.makeText(this, "hello", Toast.LENGTH_LONG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
