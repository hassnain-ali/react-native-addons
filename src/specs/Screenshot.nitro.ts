import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface Screenshot
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<Screenshot>('Screenshot')
