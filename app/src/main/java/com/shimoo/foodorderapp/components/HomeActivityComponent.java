package com.shimoo.foodorderapp.components;


import com.shimoo.foodorderapp.adapters.AdaptersRestaurant;
import com.shimoo.foodorderapp.annotations.MainHomeActivityScope;
import com.shimoo.foodorderapp.modules.MainHomeActivityModule;
import com.shimoo.foodorderapp.network.ApiService;
import com.shimoo.foodorderapp.screens.activities.MainHomeActivity;
import com.shimoo.foodorderapp.screens.fragments.BurgerFragment;
import com.shimoo.foodorderapp.screens.fragments.ChineseFragment;
import com.shimoo.foodorderapp.screens.fragments.DealsFragment;
import com.shimoo.foodorderapp.screens.fragments.HomeFragment;
import com.shimoo.foodorderapp.screens.fragments.PizzaFragment;
import com.shimoo.foodorderapp.screens.fragments.RestaurantsFragment;
import com.shimoo.foodorderapp.screens.fragments.SeafoodFragment;
import com.shimoo.foodorderapp.screens.fragments.SearchFragment;

import dagger.Component;

@Component(modules = MainHomeActivityModule.class,
        dependencies = ComponentInterFace.class ) // Tell Dagger to use GithubApplicationComponent as a source for our modules
// (Hey Dagger, if you are looking for some specific dependencies, look into this component as a source for them)
@MainHomeActivityScope
public interface HomeActivityComponent {
     AdaptersRestaurant getAdaptersRestaurant();
     ApiService getApiService();

     // if return type is void, Dagger assumes that he has to inject something somewhere
     // so he will look into method parameters and try to inject there (here - HomeActivity) to @Inject
     void injectHomeActivity(MainHomeActivity homeActivity);
     void injectChineseFragment(ChineseFragment chineseFragment);
     void injecHomeFragment(HomeFragment burgerFragment);
    void injectTacosFragment(PizzaFragment tacosFragment);
    void injectBurgerFragment(BurgerFragment burgerFragment);
    void injectRestaurantsFragment(RestaurantsFragment restaurantsFragment);
    void injectSearchFragment (SearchFragment searchFragment);
    void injectDealsFragment(DealsFragment dealsFragment);
    void injectSeafood(SeafoodFragment seafoodFragment);
}
