import { WebPlugin } from "@capacitor/core";
import { BarcodeScannerPlugin } from "./definitions";

export class BarcodeScannerWeb extends WebPlugin
  implements BarcodeScannerPlugin {
  constructor() {
    super({
      name: "BarcodeScanner",
      platforms: ["web"],
    });
  }

  scan(): void {
    console.log("BarcodeScannerWeb.scan");
  }
}

const BarcodeScanner = new BarcodeScannerWeb();

export { BarcodeScanner };

import { registerWebPlugin } from "@capacitor/core";
registerWebPlugin(BarcodeScanner);
