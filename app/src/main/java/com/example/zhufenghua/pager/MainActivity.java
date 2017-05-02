package com.example.zhufenghua.pager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    int pointWidth;
    private ViewPager viewPager;
    private LinearLayout ll;
    private View redPoint;
    private RadioGroup radioGroup;
    private RadioButton radioBtnFirst;
    private RadioButton radioBtnSecond;
    private RadioButton radioBtnThree;
    private RadioButton radioBtnFour;
    private List<View> listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ll = (LinearLayout) findViewById(R.id.ll);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioBtnFirst = (RadioButton) findViewById(R.id.raidoBtnFirst);
        radioBtnSecond = (RadioButton) findViewById(R.id.radioBtnSecond);
        radioBtnThree = (RadioButton) findViewById(R.id.radioBtnThree);
        radioBtnFour = (RadioButton) findViewById(R.id.radioBtnFour);
        redPoint = (View) findViewById(R.id.redpoint);
        initpager();
        initRedPoint();
    }


    private void initRedPoint() {

        //红点移动，ViewPager加入页面改变事件

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) redPoint.getLayoutParams();

                params.leftMargin = (int) (((float) position + positionOffset) * (float) pointWidth);
                redPoint.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    private void initpager() {
        //   viewPager = new ViewPager(this);
        viewPager.setAdapter(new welcomePagerAdapter());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("position ", position + "");
                ((RadioButton) (radioGroup.getChildAt(position))).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("CheckID", " " + checkedId);
                int ids[] = new int[]{R.id.raidoBtnFirst, R.id.radioBtnSecond, R.id.radioBtnThree, R.id.radioBtnFour};
                for (int i = 0; i < ids.length; i++) {
                    if (checkedId == ids[i]) {
                        viewPager.setCurrentItem(i);
                        Log.i("posidtion" + i, "  " + ids[i] + "checkId " + checkedId);
                        break;
                    }
                }

            }
        });


        for (int i = 0; i < listview.size(); i++) {
            View view = new View(this);
            view.setBackgroundResource(R.drawable.gray_point_shape);


            Log.i("redpoint width ", redPoint.getWidth() + "");
            int px = DensityUtils.dpi2px(this, 20);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(px, px);
            view.setLayoutParams(params);
            if (i > 0) {
                params.leftMargin = px;
                pointWidth = px + px;//前一个px是小圆的直径,后一个小圆是间距
            }

            ll.addView(view);
        }
    }

    public void gofirst(View view) {
        //  viewPager.setCurrentItem(0);

    }

    public void goSecond(View view) {
        //   viewPager.setCurrentItem(1);

    }

    public void goThree(View view) {
        // viewPager.setCurrentItem(2);
    }

    public void goFour(View view) {
        //   viewPager.setCurrentItem(3);
    }


    private class welcomePagerAdapter extends PagerAdapter {
        int[] ids = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};

        public welcomePagerAdapter() {
            listview = new ArrayList<View>();
            for (int i = 0; i < ids.length; i++) {
                View view = new View(MainActivity.this);
                view.setBackgroundResource(ids[i]);
                listview.add(view);
            }
            MyView view = new MyView(MainActivity.this);
            //View view=View.inflate(MainActivity.this,R.layout.activity_startbtn,null);
            listview.add(view);

        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = listview.get(position);
            container.addView(view);




        /*    switch (position){
                case 0: radioBtnFirst.setChecked(true);
                case 1: radioBtnSecond.setChecked(true);
                case 2:radioBtnThree.setChecked(true);
                case 4:radioBtnFour.setChecked(true);

            }*/

            return view;
            //return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return listview.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


}
