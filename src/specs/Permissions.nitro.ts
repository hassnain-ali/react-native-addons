import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface Permissions
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<Permissions>('Permissions')
