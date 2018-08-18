package com.shimoo.foodorderapp.screens.activities;

 import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.shimoo.foodorderapp.R;
 import com.shimoo.foodorderapp.helper.IFragmentToActivity;
import com.shimoo.foodorderapp.menu.DrawerAdapter;
import com.shimoo.foodorderapp.menu.DrawerItem;
import com.shimoo.foodorderapp.menu.SimpleItem;
import com.shimoo.foodorderapp.models.Restaurants;
 import com.shimoo.foodorderapp.screens.fragments.DealsFragment;
 import com.shimoo.foodorderapp.screens.fragments.MyOrderFragment;
import com.shimoo.foodorderapp.screens.fragments.InfoFragment;
import com.shimoo.foodorderapp.screens.fragments.MapFragment;
import com.shimoo.foodorderapp.screens.fragments.HomeFragment;
 import com.shimoo.foodorderapp.screens.fragments.MyAcountFragment;
 import com.shimoo.foodorderapp.screens.fragments.PayMentFragment;
import com.shimoo.foodorderapp.screens.fragments.RestaurantsFragment;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainHomeActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener  ,IFragmentToActivity{

    private String[] screenTitles;
    private Drawable[] screenIcons;
    private SlidingRootNav slidingRootNav;
    String lang = Locale.getDefault().getDisplayLanguage();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_messages);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         if(lang.equals("English")){
            slidingRootNav = new SlidingRootNavBuilder(this)
                    .withToolbarMenuToggle(toolbar)
                    .withMenuOpened(false)
                    .withContentClickableWhenMenuOpened(false)
                    .withSavedState(savedInstanceState)
                    .withMenuLayout(R.layout.menu_left_drawer)
                    .withDragDistance(110)
                    .withGravity(SlideGravity.LEFT)
                    .inject();


        }else {
            slidingRootNav = new SlidingRootNavBuilder(this)
                    .withToolbarMenuToggle(toolbar)
                    .withMenuOpened(false)
                    .withContentClickableWhenMenuOpened(false)
                    .withSavedState(savedInstanceState)
                    .withMenuLayout(R.layout.menu_left_drawer)
                    .withDragDistance(110)
                    .withGravity(SlideGravity.RIGHT)
                    .inject();

        }



        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(0).setChecked(true),
                createItemFor(1),
                createItemFor(2),
                createItemFor(3),
                createItemFor(4),
                createItemFor(5),
                createItemFor(6),
                createItemFor(7),
                createItemFor(8)));
        adapter.setListener(this);
//          new SpaceItem(48),

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(0);
//        HomeActivityComponent component= DaggerHomeActivityComponent.builder()
//             .mainHomeActivityModule(new MainHomeActivityModule(this))
//                .componentInterFace(MyApplicationClass.get(this).getComponent())
//                .build();

    }

    @Override
    public void onItemSelected(int position) {
        slidingRootNav.closeMenu();
        switch (position) {

            case 0:
                  getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();

                break;
            case 1:

                getSupportFragmentManager().beginTransaction().add(R.id.container, new MapFragment()).addToBackStack(null).commit();

                break;
            case 2:

                getSupportFragmentManager().beginTransaction().add(R.id.container, new RestaurantsFragment()).addToBackStack(null).commit();
                break;
            case 3:

//                MyAcountFragment
                getSupportFragmentManager().beginTransaction().add(R.id.container, new DealsFragment()).addToBackStack(null).commit();
                break;
            case 4:

//                MyAcountFragment
                getSupportFragmentManager().beginTransaction().add(R.id.container, new MyOrderFragment()).addToBackStack(null).commit();
                break;
            case 5:

                getSupportFragmentManager().beginTransaction().add(R.id.container, new MyAcountFragment()).addToBackStack(null).commit();
                break;
             case 6:

                getSupportFragmentManager().beginTransaction().add(R.id.container, new PayMentFragment()).addToBackStack(null).commit();
                break;
            case 7:

                getSupportFragmentManager().beginTransaction().add(R.id.container, new InfoFragment()).addToBackStack(null).commit();
                break;

        }

    }



    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorSecondary))
                .withTextTint(color(R.color.textColorPrimary))
                .withSelectedIconTint(color(R.color.colorPrimary))
                .withSelectedTextTint(color(R.color.colorPrimary));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    @Override
    public void sedData(List<Restaurants.RestaurantsBean> githubRepos) {

    }
}