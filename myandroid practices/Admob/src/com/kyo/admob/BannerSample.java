package com.kyo.admob;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * A simple {@link Activity} that embeds an AdView.
 */
public class BannerSample extends Activity {
  /** The view to show the ad. */
  private AdView adView;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Create an ad. testApp(a150f783a1563c)
    adView = new AdView(this, AdSize.BANNER, "27a4571921c84369" );//AD_UNIT_ID_GOES_HERE);

    // Add the AdView to the view hierarchy. The view will have no size
    // until the ad is loaded.
    LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
    layout.addView(adView);

    // Create an ad request. Check logcat output for the hashed device ID to
    // get test ads on a physical device.
    AdRequest adRequest = new AdRequest();
    adRequest.addTestDevice(AdRequest.TEST_EMULATOR);

    // Start loading the ad in the background.
    adView.loadAd(adRequest);
  }

  /** Called before the activity is destroyed. */
  @Override
  public void onDestroy() {
    // Destroy the AdView.
    if (adView != null) {
      adView.destroy();
    }

    super.onDestroy();
  }
}
