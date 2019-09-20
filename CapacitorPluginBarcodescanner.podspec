
  Pod::Spec.new do |s|
    s.name = 'CapacitorPluginBarcodescanner'
    s.version = '0.0.1'
    s.summary = 'Capacitor Plugin to add barcode scanner capabilities'
    s.license = 'MIT'
    s.homepage = 'https://github.com/LukaszGrela/capacitor-plugin-barcodescanner.git'
    s.author = 'Lukasz 'Severiaan' Grela'
    s.source = { :git => 'https://github.com/LukaszGrela/capacitor-plugin-barcodescanner.git', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
  end