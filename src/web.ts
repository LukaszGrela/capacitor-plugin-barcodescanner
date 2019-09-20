import { WebPlugin } from '@capacitor/core';
import { BarcodeScannerPlugin } from './definitions';

export class BarcodeScannerWeb extends WebPlugin implements BarcodeScannerPlugin {
  constructor() {
    super({
      name: 'BarcodeScanner',
      platforms: ['web']
    });
  }

  async echo(options: { value: string }): Promise<{value: string}> {
    console.log('ECHO', options);
    return options;
  }
}

const BarcodeScanner = new BarcodeScannerWeb();

export { BarcodeScanner };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(BarcodeScanner);
