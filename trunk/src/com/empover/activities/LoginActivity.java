package com.empover.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener
{
	
	private EditText loginId;
	private EditText pasword;
	private Button loginBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		
		// Just To demonstrate the reading the value passed from previous Activity Bc5sp8qQ5nJ7
		Intent intent =   getIntent();
		System.out.println(intent.getStringExtra("RAJESH"));
		
		
		loginId		=	(EditText)findViewById(R.id.username);
		pasword		=	(EditText)findViewById(R.id.password);
		loginBtn	=	(Button)findViewById(R.id.lognBtn);
		
		loginBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		System.out.println(loginId.getText()+"---------"+pasword.getText());
		Toast.makeText(this, loginId.getText()+"---------"+pasword.getText(), Toast.LENGTH_SHORT).show();
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		menu.add(0,1,0,"Test");
		return super.onCreateOptionsMenu(menu);
	}
}
