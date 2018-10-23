/**
 *  Application: Bon Appetit
 *  Team Name: Team Slavick
 */
package ca.humber.bonappetit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {

    int numberOfTabs;

    public pagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.numberOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                tab1 tab1 = new tab1();
                return tab1;
            case 1:
                tab2 tab2 = new tab2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
