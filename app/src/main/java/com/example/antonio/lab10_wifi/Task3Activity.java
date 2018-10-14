package com.example.antonio.lab10_wifi;

import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Task3Activity extends AppCompatActivity {
    private TextView textView;
    private WifiManager mWifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_task3 );
        textView = findViewById( R.id.textView3 );
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        if(!mWifiManager.isWifiEnabled() && mWifiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLING) {
            mWifiManager.setWifiEnabled( true );
        }

        WifiInfo connectionInfo = mWifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            int birate = connectionInfo.getLinkSpeed();
            float frequency = connectionInfo.getLinkSpeed() / 1000f;
            mWifiManager.getConfiguredNetworks();

            textView.setText( "Frequency: "+frequency +"GHz\nBitRate: " + birate +"Mbps" );

            if ((birate == 1 || birate == 2 ) && frequency < 5f) {
                textView.setText( "802.11-1997" );
            } else if ((birate == 6 || birate == 9 || birate == 12 || birate == 12 || birate == 18 || birate == 24 || birate == 36 || birate == 48 || birate == 54) && (frequency == 5f || frequency == 3.7)) {
                textView.setText( "802.11a" );

            } else if ((birate == 1 || birate == 2 || birate == 5.5 || birate == 11 ) && frequency < 5f) {
                textView.setText( "802.11b" );
            } else if ((birate == 6 || birate == 9 || birate == 12 || birate == 12 || birate == 18 || birate == 24 || birate == 36 || birate == 48 || birate == 54) && frequency < 5f) {
                textView.setText( "802.11g" );
            } else if ( birate <= 600 && (frequency == 5f || frequency <= 2.4f) ){
                textView.setText( "802.11n" );
            } else if (birate <= 3466.8 && frequency == 5f) {
                textView.setText( "802.11ac" );

            }


        }
    }
}
