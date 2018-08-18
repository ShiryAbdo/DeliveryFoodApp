package com.shimoo.foodorderapp.modules;

import android.content.Context;

import com.shimoo.foodorderapp.annotations.ApiServiceScope;
import com.shimoo.foodorderapp.annotations.ApplicationContextQualifier;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context){
        this.context=context.getApplicationContext();
    }
    @Provides
    @ApiServiceScope
    @ApplicationContextQualifier  /* replace @Named("application_context") */// add a qualifier  with that annotation do the same of@named
    public Context context(){
        return context;
    }
}
