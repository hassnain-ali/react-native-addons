import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface Compressor
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<Compressor>('Compressor')
