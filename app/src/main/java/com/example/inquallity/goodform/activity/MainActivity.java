package com.example.inquallity.goodform.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.inquallity.goodform.R;
import com.example.inquallity.goodform.fragment.DayFiveFragment;
import com.example.inquallity.goodform.fragment.DayFourFragment;
import com.example.inquallity.goodform.fragment.DayOneFragment;
import com.example.inquallity.goodform.fragment.DayThreeFragment;
import com.example.inquallity.goodform.fragment.DayTwoFragment;
import com.example.inquallity.goodform.fragment.TechniqueFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.inquallity.goodform.fragment.SimpleExercisesFragment;

/**
 * Created by Olga Aleksandrova on 15-Jan-18.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout_main_menu) DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation) NavigationView mNavigationView;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.fl_for_fragment) FrameLayout mFrameLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            showToast();
        }
        back_pressed = System.currentTimeMillis();
    }

    private void showToast() {
        Toast toast = Toast.makeText(this, R.string.press_back, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment targetFragment;
        switch (item.getItemId()) {
            case R.id.menu_about_app:
                targetFragment = new TechniqueFragment();
                getSupportActionBar().setTitle(R.string.mi_technique);
                mFrameLayout.setBackgroundResource(R.drawable.main_back);
                break;
            case R.id.menu_item_day_first:
                targetFragment = new DayOneFragment();
                getSupportActionBar().setTitle(R.string.mi_first_day);
                mFrameLayout.setBackgroundResource(R.color.colorPrimary);
                break;
            case R.id.menu_item_day_second:
                targetFragment = new DayTwoFragment();
                getSupportActionBar().setTitle(R.string.mi_second_day);
                mFrameLayout.setBackgroundResource(R.color.colorPrimary);
                break;
            case R.id.menu_item_day_third:
                targetFragment = new DayThreeFragment();
                getSupportActionBar().setTitle(R.string.mi_third_day);
                mFrameLayout.setBackgroundResource(R.color.colorPrimary);
                break;
            case R.id.menu_item_day_fourth:
                targetFragment = new DayFourFragment();
                getSupportActionBar().setTitle(R.string.mi_fourth_day);
                mFrameLayout.setBackgroundResource(R.color.colorPrimary);
                break;
            case R.id.menu_item_day_fifth:
                targetFragment = new DayFiveFragment();
                getSupportActionBar().setTitle(R.string.mi_fifth_day);
                mFrameLayout.setBackgroundResource(R.color.colorPrimary);
                break;
            case R.id.menu_item_simple_exercises:
                targetFragment = new SimpleExercisesFragment();
                getSupportActionBar().setTitle(R.string.mi_exercises);
                mFrameLayout.setBackgroundResource(R.color.colorPrimary);
                break;
            default:
                targetFragment = null;
                break;
        }
        if (targetFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_for_fragment, targetFragment)
                    .commit();
        }

        mDrawerLayout.closeDrawers();
        return targetFragment != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);

        mFrameLayout.setBackgroundResource(R.drawable.main_back);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.mi_technique);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.drawer_opened, R.string.drawer_closed);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        if (savedInstanceState == null) {
            Fragment fragment = new TechniqueFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_for_fragment, fragment)
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActionBarDrawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }
}
