package com.udinic.mirmudi;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(new MirmursAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, (int) id);
                mediaPlayer.start();
            }
        });

        ImageView bg = (ImageView) findViewById(R.id.bg);
        int colorValue = (int)(255 - 200 * 0.6f);
        bg.setColorFilter(new PorterDuffColorFilter(Color.rgb(colorValue, colorValue, colorValue),
                android.graphics.PorterDuff.Mode.MULTIPLY));

        int bgs[] = new int[] {
                R.drawable.banana_gun,
                R.drawable.cs,
                R.drawable.profile,
                R.drawable.profile3,
                R.drawable.udi,
                R.drawable.water_fight,
                R.drawable.with_devices
        };

        Picasso.with(this).load(bgs[new Random(System.currentTimeMillis()).nextInt(bgs.length)]).
                fit().transform(new BlurTransform(this)).into(bg, new Callback() {
            @Override
            public void onSuccess() {
                grid.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        int num = grid.getCount();
                        for (int i = 0; i < num; i++) {
                            grid.getChildAt(i).animate().alpha(1f).setDuration(400).setStartDelay(i * 100).withLayer().start();
                        }
                        grid.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
