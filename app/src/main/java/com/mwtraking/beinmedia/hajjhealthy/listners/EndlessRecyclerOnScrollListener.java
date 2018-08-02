package com.mwtraking.beinmedia.hajjhealthy.listners;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    public static String TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();
    int visibleItemCount, totalItemCount;
    int[] first;
    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 1; // The minimum amount of items to have below your current scroll position before loading more.
    private int current_page = 1;
    private RecyclerView recyclerView;

    private StaggeredGridLayoutManager mLinearLayoutManager;

    public EndlessRecyclerOnScrollListener(StaggeredGridLayoutManager linearLayoutManager, RecyclerView recyclerView) {
        this.mLinearLayoutManager = linearLayoutManager;
        this.recyclerView = recyclerView;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        int[] firstCompletelyVisibleItemPositions = mLinearLayoutManager.findFirstCompletelyVisibleItemPositions(first);
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstCompletelyVisibleItemPositions[0] + visibleThreshold)) {
            // End has been reached

            // Do something
            current_page++;
            onLoadMore(current_page);
            loading = true;
        }
    }

    public abstract void onLoadMore(int current_page);
}