declare module "@capacitor/core" {
  interface PluginRegistry {
    BarcodeScanner: BarcodeScannerPlugin;
  }
}

export interface BarcodeScannerPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
}
