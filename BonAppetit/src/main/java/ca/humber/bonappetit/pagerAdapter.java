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
                foodTab tab1 = new foodTab();
                return tab1;
            case 1:
                favouritesTab tab2 = new favouritesTab();
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
