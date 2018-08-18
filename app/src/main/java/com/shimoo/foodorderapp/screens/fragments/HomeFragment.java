package com.shimoo.foodorderapp.screens.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;

import com.shimoo.foodorderapp.R;
import com.shimoo.foodorderapp.adapters.AdaptersRestaurant;
import com.shimoo.foodorderapp.components.DaggerHomeActivityComponent;
import com.shimoo.foodorderapp.components.HomeActivityComponent;
import com.shimoo.foodorderapp.controls.MyApplicationClass;
import com.shimoo.foodorderapp.helper.BottomNavigationViewHelper;
import com.shimoo.foodorderapp.helper.IFragmentToActivity;
import com.shimoo.foodorderapp.models.Restaurants;
import com.shimoo.foodorderapp.modules.MainHomeActivityModule;
import com.shimoo.foodorderapp.network.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    @BindView(R.id.toolbar_layout)CollapsingToolbarLayout collapsingToolbar ;
    @BindView(R.id.app_bar)AppBarLayout appBarLayout ;
    @BindView(R.id.layoutButton)LinearLayout layoutButton ;
    @BindView(R.id.SearchEditText)EditText SearchEditText ;
    @BindView(R.id.SearchBt)ImageView SearchBt ;
    @Inject
    ApiService githubService;
    @Inject
    Picasso mPicasso;
    @Inject
    AdaptersRestaurant adapterRepos;
    HomeActivityComponent component ;
    TabLayout tabLayout ;
    private FragmentTabHost mTabHost;
    private int[] tabIcons = {
            R.drawable.ic_noodles,
            R.drawable.ic_pizza,
            R.drawable.ic_pizza,
            R.drawable.ic_fish_and_lemon,
            R.drawable.ic_hamburger_with_bacoon
    };




    @SuppressLint({"ClickableViewAccessibility", "ResourceType"})
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View root=inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, root);
        getActivity().setTitle("Home");
        getActivity().findViewById(R.id.toolbar).setBackgroundColor(Color.parseColor("#31D896"));
        component= DaggerHomeActivityComponent.builder().mainHomeActivityModule(new MainHomeActivityModule(getActivity(),"Home")).componentInterFace(MyApplicationClass.get(getActivity()).getComponent()).build();
        component.injecHomeFragment(this);
        component.getAdaptersRestaurant();
        component.getApiService();

        SearchEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return false;
            }
        });
        SearchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearBackSta();
                SearchEditText.setText("");
                getActivity().getFragmentManager().beginTransaction().add(R.id.mainHomeFragment, new SearchFragment(SearchEditText.getText().toString())).addToBackStack(null).commit();

            }
        });

          tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#31D896"));
        tabLayout.setSelectedTabIndicatorHeight((int) (2 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#2cbc83"));
        tabLayout.addTab(tabLayout.newTab().setText(getActivity().getString(R.string.Chinese)));
        tabLayout.addTab(tabLayout.newTab().setText(getActivity().getString(R.string.pizza)));
        tabLayout.addTab(tabLayout.newTab().setText(getActivity().getString(R.string.Seafood)));
        tabLayout.addTab(tabLayout.newTab().setText(getActivity().getString(R.string.Burger)));

        ColorStateList colors;
//        if (Build.VERSION.SDK_INT >= 23) {
//            colors = getResources().getColorStateList(R.drawable.tab_icon, getTheme());
//        }
//        else {
            colors = getResources().getColorStateList(R.drawable.tab_icon);
//        }

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            Drawable icon = tab.getIcon();

            if (icon != null) {
                icon = DrawableCompat.wrap(icon);
                DrawableCompat.setTintList(icon, colors);
            }
        }



        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupTabIcons();



        final ViewPager viewPager = (ViewPager) root.findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
//                        int tabIconColor = ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark);
//                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
//                        tab.getPosition();

                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
//                        int tabIconColor = ContextCompat.getColor(getActivity(), R.color.colorAccent);
//                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );

//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

//        mTabHost = (FragmentTabHost) root.findViewById(R.id.tabhost);
//        mTabHost.setup(getActivity(), getActivity().getSupportFragmentManager(), R.id.tabFrameLayout);
//
//        mTabHost.addTab(
//                mTabHost.newTabSpec("tab1").setIndicator(getTabIndicator(mTabHost.getContext(), R.string.Chinese, android.R.drawable.star_on)),
//                ChineseFragment.class, null);
//        mTabHost.addTab(
//                mTabHost.newTabSpec("tab2").setIndicator(getTabIndicator(mTabHost.getContext(), R.string.pizza, android.R.drawable.star_on)),
//                PizzaFragment.class, null);
//        mTabHost.addTab(
//                mTabHost.newTabSpec("tab3").setIndicator(getTabIndicator(mTabHost.getContext(), R.string.Chinese, android.R.drawable.star_on)),
//                ChineseFragment.class, null);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    layoutButton.setPadding(0, 0, 0, 0);
                    collapsingToolbar.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD);
                    collapsingToolbar.setExpandedTitleTextAppearance(R.style.TransparentText);
                    isShow = true;
                } else if (isShow) {
                    layoutButton.setPadding(0, 40, 0, 0);
                    collapsingToolbar.setTitle("" + "   ");
                    collapsingToolbar.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD);
                    collapsingToolbar.setExpandedTitleTextAppearance(R.style.TransparentText);
                    isShow = false;
                }
            }
        });




        return root;
    }
    private void clearBackSta() {
        getFragmentManager().popBackStack();

    }

    private View getTabIndicator(Context context, int title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        ImageView iv = (ImageView) view.findViewById(R.id.imageView);
        iv.setImageResource(icon);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(title);
        return view;
    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
      }


    class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    ChineseFragment tab1 = new ChineseFragment();
                    return tab1;
                case 1:
                    PizzaFragment tab2 = new PizzaFragment();
                    return tab2;
                case 2:
                    ChineseFragment tab3 = new ChineseFragment();
                    return tab3;
                case 3:
                    BurgerFragment tab4 = new BurgerFragment();
                    return tab4;


                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}