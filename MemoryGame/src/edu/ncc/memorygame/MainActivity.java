package edu.ncc.memorygame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements View.OnClickListener{

	private ImageButton[] buttons;
	private Button reset;
	private int numClicked;
	private int[] imageNums;
	private int[]buttonsClicked;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// create the array to store references to the buttons
		buttons = new ImageButton[12];

		// get the id of the first button
		int idIndex = R.id.button0;

		// store the references into the array by cycling through the id indices & set the listener
		for (int i=0; i<buttons.length; i++) 
		{
			buttons[i] = (ImageButton)findViewById(idIndex++);
			buttons[i].setOnClickListener(this);
		}

		//get the id's for the images and store 2 of each
		imageNums = new int[12];
		imageNums[0] = R.drawable.angry;
		imageNums[1] = R.drawable.angry;
		imageNums[2] = R.drawable.blushing;
		imageNums[3] = R.drawable.blushing;
		imageNums[4] = R.drawable.crying;
		imageNums[5] = R.drawable.crying;
		imageNums[6] = R.drawable.haha;
		imageNums[7] = R.drawable.haha;
		imageNums[8] = R.drawable.sad;
		imageNums[9] = R.drawable.sad;
		imageNums[10] = R.drawable.smile;
		imageNums[11] = R.drawable.smile;

		// randomize the values
		int r1, r2;
		int temp;
		for (int i=0; i<20; i++)
		{
			r1 = (int)(Math.random()*12);
			r2 = (int)(Math.random()*12);
			temp = imageNums[r1];
			imageNums[r1] = imageNums[r2];
			imageNums[r2]= temp;
		}

		reset = (Button)findViewById(R.id.reset_button);
		reset.setOnClickListener(this);

		numClicked = 0;
		buttonsClicked = new int[2];
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
	@Override
	public void onClick(View view) {
	
	}
}
