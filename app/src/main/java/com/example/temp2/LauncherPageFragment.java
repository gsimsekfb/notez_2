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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.temp2.DraggableGridExampleActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LauncherPageFragment extends Fragment {
    private static final String ARG_PAGE_NO = "page no";

    public static final int PAGE_DRAG = 0;
    public static final int PAGE_SWIPE = 1;
    public static final int PAGE_EXPAND = 2;
    public static final int PAGE_HEADER = 3;
    public static final int PAGE_ADAPTER = 4;
    public static final int PAGE_ADVANCED = 5;

    public static final int NUM_PAGES = 6;


    public static LauncherPageFragment newInstance(int pageNo) {
        LauncherPageFragment fragment = new LauncherPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NO, pageNo);
        fragment.setArguments(args);
        return fragment;
    }

    public LauncherPageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        int pageNo = getArguments().getInt(ARG_PAGE_NO);

        LauncherButtonsAdapter adapter = createAdapter(pageNo);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    public static String getPageTitle(int pageNo) {
        switch (pageNo) {
            case PAGE_DRAG:
                return "Drag";
            case PAGE_SWIPE:
                return "Swipe";
            case PAGE_EXPAND:
                return "Expand";
            case PAGE_HEADER:
                return "Header";
            case PAGE_ADAPTER:
                return "Adapter";
            case PAGE_ADVANCED:
                return "Advanced";
            default:
                throw new IllegalArgumentException();
        }
    }

    private LauncherButtonsAdapter createAdapter(int pageNo) {
        LauncherButtonsAdapter adapter = new LauncherButtonsAdapter(this);

        pageNo = PAGE_DRAG;

        switch (pageNo) {
            case PAGE_DRAG:
                // Drag
                adapter.put(DraggableGridExampleActivity.class, R.string.activity_title_demo_d_grid);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return adapter;
    }
}
