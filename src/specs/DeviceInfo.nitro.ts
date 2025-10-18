import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface DeviceInfo
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<DeviceInfo>('DeviceInfo')
