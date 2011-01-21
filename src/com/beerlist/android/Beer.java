/****************************************************************************
 * Application in order to pull beers off of our google docs beer lists
 * to our evos. 
 * @author mgillmann
 * @version 1.0a (Alpha Version)
 * @date 1/19/2011
 * 
 * TODO
 * 	Pull tables from gdocs 
 *	Tables editable, filterable, searchable
 *	Tables sync to server
 *	New template?  Select user(s) -> select list
 *		- Possibility to sync with multiple users
 *		- Select user or group of who you are synced with
 *	Random extra features?
 *****************************************************************************/

package com.beerlist.android;

import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class Beer extends ListActivity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	final int CHOICE_MODE_SINGLE = 1;
        super.onCreate(savedInstanceState);
        String[] lists = getResources().getStringArray(R.array.beer_lists_array);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, lists));

        ListView lv = getListView();
        lv.setChoiceMode(CHOICE_MODE_SINGLE);
        lv.setTextFilterEnabled(true);
        
        lv.setOnItemClickListener(new OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
          {
            // When clicked, show a toast with the TextView text
            Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            
            String selection = ((TextView) view).getText().toString();
            if(selection.equals("Misc Beers"))
            {
            	//TODO Pull server data
            	Intent nextAct = new Intent(Beer.this, MiscBeer.class);
            	startActivity(nextAct);
            }
            else if(selection.equals("2010 Beers"))
            {
            	//TODO Pull server data
            	Intent nextAct = new Intent(Beer.this, Beer2010.class);
            	startActivity(nextAct);
            }
            else if(selection.equals("2011 Beers"))
            {
            	//TODO Pull server data
            	Intent nextAct = new Intent(Beer.this, Beer2011.class);
            	startActivity(nextAct);
            }
            else if(selection.equals("Liquors"))
            {
            	//TODO Pull server data
            	Intent nextAct = new Intent(Beer.this, Liquors.class);
            	startActivity(nextAct);
            }
            
          }
        });
    }
}