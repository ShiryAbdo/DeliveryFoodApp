package com.shimoo.foodorderapp.modules;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.shimoo.foodorderapp.annotations.ApplicationContextQualifier;
import com.shimoo.foodorderapp.annotations.ApiServiceScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = ContextModule.class)
public class PicassoModule {
    @Provides
    @ApiServiceScope
    public Picasso picasso(@ApplicationContextQualifier Context context, OkHttpClient okHttpClient, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }
    @Provides
    @ApiServiceScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
