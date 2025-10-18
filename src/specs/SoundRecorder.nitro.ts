import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface SoundRecorder
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<SoundRecorder>('SoundRecorder')
