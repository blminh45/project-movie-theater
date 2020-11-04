package com.example.movieapp.Profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {

    public ProfileViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ProfileFragment();
            case 1:
                return new Profile_DealFragment();
            default:
                return new ProfileFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position)
        {
            case 0:
                title="Thong tin";
                break;
            case 1:
                title="Giao Dich";
        }
        return title;
    }
}
