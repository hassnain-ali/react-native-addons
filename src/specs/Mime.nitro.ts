import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface Mime
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<Mime>('Mime')
