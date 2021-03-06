package com.example.kaushiknsanji.bookslibrary.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kaushiknsanji.bookslibrary.R;
import com.example.kaushiknsanji.bookslibrary.adapterviews.KeywordFiltersDialogFragment;
import com.example.kaushiknsanji.bookslibrary.models.KeywordFilter;

import java.util.List;

/**
 * An {@link ArrayAdapter} class of {@link KeywordFilter} objects
 * used in {@link KeywordFiltersDialogFragment} AdapterView
 * class
 *
 * @author Kaushik N Sanji
 */
public class KeywordFiltersAdapter extends ArrayAdapter<KeywordFilter> {

    //Stores the layout resource of the list item that needs to be inflated manually
    private final int mLayoutRes;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file used as list item ('R.layout.keyword_filter_list_item')
     * @param objects  The KeywordFilters{@link KeywordFilter} to represent in the ListView.
     */
    public KeywordFiltersAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<KeywordFilter> objects) {
        //Passing the layout resource as 0 since we are inflating the layout manually
        super(context, 0, objects);
        mLayoutRes = resource;
    }

    /**
     * Method that prepares and returns the List Item View
     **/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Retrieving the current item at position
        KeywordFilter keywordFilter = getItem(position);

        //Declaring the ViewHolder
        KeywordFilterItemViewHolder viewHolder = null;

        //Checking for existing view if any for reuse; inflating otherwise
        if (convertView == null) {
            //Inflating the view
            convertView = LayoutInflater.from(getContext()).inflate(mLayoutRes, parent, false);

            //Retrieving the View Components : START
            viewHolder = new KeywordFilterItemViewHolder();
            viewHolder.keywordFilterNameTextView = (TextView) convertView.findViewById(R.id.keyword_filter_name_text_id);
            viewHolder.keywordFilterDescTextView = (TextView) convertView.findViewById(R.id.keyword_filter_desc_text_id);
            //Retrieving the View Components : END

            //Saving all the Components as a ViewHolder in the View's tag for future reuse
            convertView.setTag(viewHolder);
        } else {
            //Retrieving the ViewHolder from the View's Tag when the View exists
            viewHolder = (KeywordFilterItemViewHolder) convertView.getTag();
        }

        //Populating the data onto the Template View using the KeywordFilter object: START
        viewHolder.keywordFilterNameTextView.setText(keywordFilter.getFilterName());
        viewHolder.keywordFilterDescTextView.setText(keywordFilter.getFilterDesc());
        //Populating the data onto the Template View using the KeywordFilter object: END

        //Returning the prepared List Item View
        return convertView;
    }

    /**
     * ViewHolder class for caching View Components of the template view
     */
    private static class KeywordFilterItemViewHolder {
        private TextView keywordFilterNameTextView;
        private TextView keywordFilterDescTextView;
    }
}
