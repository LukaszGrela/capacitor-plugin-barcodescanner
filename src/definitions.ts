import { PluginListenerHandle } from "@capacitor/core";

declare module "@capacitor/core" {
  interface PluginRegistry {
    BarcodeScanner: BarcodeScannerPlugin;
  }
}

export const EVENT_BARCODE_SCANNED =
  "co.greladesign.plugins.capacitor.event.EVENT_BARCODE_SCANNED";

export interface IBarcodeScannerEventPayload {
  barcode?: string;
  error?: string;
  cancelled?: boolean;
}
export type TBarcodeScannerListenerHandler = (
  state: IBarcodeScannerEventPayload
) => void;

export interface BarcodeScannerPlugin {
  scan(): void;

  addListener(
    eventName: typeof EVENT_BARCODE_SCANNED,
    listenerFunc: TBarcodeScannerListenerHandler
  ): PluginListenerHandle;
}
