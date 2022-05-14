package com.utsuk.merotodolist;
/*
 * Utsuk Paudayal
 * C7227233
 */
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numofTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numofTabs=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new AboutUsFragment();

            case 1:
                return new GithubFragment();

            case 2:
                return new ToastFragment();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numofTabs;
    }
}
