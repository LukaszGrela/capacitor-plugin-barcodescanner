package co.greladesign.plugins.capacitor.BarcodeScanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;

import java.util.Random;

import co.greladesign.plugins.capacitor.BarcodeScanner.capacitorpluginbarcodescanner.R;

public class ScannerActivity extends AppCompatActivity {

  private CaptureManager capture;
  private DecoratedBarcodeView barcodeScannerView;
  private ViewfinderView viewfinderView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scanner);

    barcodeScannerView = findViewById(R.id.zxing_barcode_scanner);

    viewfinderView = findViewById(R.id.zxing_viewfinder_view);

    capture = new CaptureManager(this, barcodeScannerView);
    capture.initializeFromIntent(getIntent(), savedInstanceState);
    capture.setShowMissingCameraPermissionDialog(true, getString(R.string.barcode_camera_permission_reason));
    capture.decode();

    changeMaskColor(null);
    changeLaserVisibility(true);
  }

  @Override
  protected void onResume() {
    super.onResume();
    capture.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    capture.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    capture.onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    capture.onSaveInstanceState(outState);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
  }


  public void changeMaskColor(View view) {
    Random rnd = new Random();
    int color = Color.argb(100, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    viewfinderView.setMaskColor(color);
  }

  public void changeLaserVisibility(boolean visible) {
    viewfinderView.setLaserVisibility(visible);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    capture.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }
}