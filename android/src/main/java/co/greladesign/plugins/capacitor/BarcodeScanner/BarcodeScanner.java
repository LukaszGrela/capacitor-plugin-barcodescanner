package co.greladesign.plugins.capacitor.BarcodeScanner;

import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

@NativePlugin()
public class BarcodeScanner extends Plugin {

    private static final String SCANNER_EVENT_PAYLOAD_PARAM_BARCODE = "barcode";
    private static final String SCANNER_EVENT_PAYLOAD_PARAM_ERROR = "error";
    private static final String SCANNER_EVENT_PAYLOAD_PARAM_CANCELLED = "cancelled";

    private static final String SCANNER_EVENT_NAME =
        "co.greladesign.plugins.capacitor.event.EVENT_BARCODE_SCANNED";

    @PluginMethod()
    public void scan() {
        new IntentIntegrator(this.getBridge().getActivity()).initiateScan();
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        final JSObject message = new JSObject();
        if(result != null) {
            if(result.getContents() == null) {
                // cancelled
                message.put(SCANNER_EVENT_PAYLOAD_PARAM_CANCELLED, true);
            } else {
                String st_scanned_result = result.getContents();
                message.put(SCANNER_EVENT_PAYLOAD_PARAM_BARCODE, st_scanned_result);
            }
        } else {
            // no results
            message.put(SCANNER_EVENT_PAYLOAD_PARAM_ERROR, "NO_RESULTS_RETURNED");
        }
        notifyListeners(SCANNER_EVENT_NAME, message);
    }
}
