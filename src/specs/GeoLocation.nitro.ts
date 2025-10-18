import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface GeoLocation
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<GeoLocation>('GeoLocation')
