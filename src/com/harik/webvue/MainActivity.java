package com.harik.webvue;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
private Button bback,bforward;
private WebView wb=null;
private ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bback=(Button)findViewById(R.id.button1);
		bback.setEnabled(false);
		
		bback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wb.goBack();
				
			}
		});
		bforward=(Button)findViewById(R.id.button2);
		bforward.setEnabled(false);
		bforward.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wb.goForward();
				
			}
		});
		pb=(ProgressBar) findViewById(R.id.progressBar1);
		wb=(WebView)findViewById(R.id.webView1);
		
		wb.setWebViewClient(new WebViewClient(){
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				pb.setVisibility(view.VISIBLE);
				
			}
			@Override
			public void onPageFinished(WebView view, String url) {
				bback.setEnabled(wb.canGoBack());
				bforward.setEnabled(wb.canGoForward());
				pb.setVisibility(view.GONE);
			
			}
		});
		wb.loadUrl("http://www.google.fr");
		wb.getSettings().setJavaScriptEnabled(true);
		wb.getSettings().setDomStorageEnabled(true);
	}
}
