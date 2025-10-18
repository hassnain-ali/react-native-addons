import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface SoundPlayer
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<SoundPlayer>('SoundPlayer')
