/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.temp2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.temp2.LauncherPageFragment;

public class LauncherPagerAdapter extends FragmentPagerAdapter {
    public LauncherPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return LauncherPageFragment.NUM_PAGES;
    }

    @Override
    public Fragment getItem(int position) {
        return LauncherPageFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return LauncherPageFragment.getPageTitle(position);
    }
}
