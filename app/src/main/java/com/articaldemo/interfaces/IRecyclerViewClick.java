package com.articaldemo.interfaces;

/**
 *  interface for Recylcer view item click
 */
public interface IRecyclerViewClick {
    /**
     *   method will supply item data to calling class
     * @param position  position on which list item clicked
     * @param obj   any data want to trasfer
     */
    void onItemClick(int position,Object obj);
}
