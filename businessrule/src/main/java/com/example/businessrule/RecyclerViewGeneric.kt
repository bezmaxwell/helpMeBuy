package com.example.businessrule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**@see
 *  When we instantiate the adapter in view we need use this way
 *  rv.adapter == recyclerView from XML
 * rv.adapter = RecyclerViewGeneric<BaseViewHolder>()
 *  rv.adapter = RecyclerViewGeneric { view ->
 *      GreenView(view)
 *  }
 */
class RecyclerViewGeneric<T : BaseViewHolder>(
    private val viewHolderLaunch: (View) -> T
) : RecyclerView.Adapter<T>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {

        /**@exception This can return an exception
         *  Try to change the layout to the correct one.
         */
        val view = LayoutInflater.from(parent.context).inflate(
            androidx.constraintlayout.widget.R.layout.abc_action_bar_title_item, parent, false)

        return viewHolderLaunch(view)
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        /** @see
         *  Here we need to get the specific item and attribute the position for example
         */
    }

    override fun getItemCount(): Int {
        return 100
    }

}

open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /**@see
     *  Here we need to create a variable and pass the value that came through findviewbyId
     *  Example: val title = findviewbyId(R.id.titleExampleName)
     */
}

class GreenView(itemView: View): BaseViewHolder(itemView)
