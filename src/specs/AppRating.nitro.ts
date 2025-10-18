import { NitroModules, type HybridObject } from 'react-native-nitro-modules';

export interface AppRating
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<AppRating>('AppRating')
