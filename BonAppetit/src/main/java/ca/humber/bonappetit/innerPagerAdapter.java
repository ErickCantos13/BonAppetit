/**
 *  Application: Bon Appetit
 *  Team Name: Team Slavick
 */
package ca.humber.bonappetit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class innerPagerAdapter extends FragmentPagerAdapter {

    int numberOfTabs;

    public innerPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.numberOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                vegetableTab tab1 = new vegetableTab();
                return tab1;
            case 1:
                dairyTab tab2 = new dairyTab();
                return tab2;
            case 2:
                grainTab tab3 = new grainTab();
                return tab3;
            case 3:
                proteinTab tab4 = new proteinTab();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
