import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface FileSystem
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<FileSystem>('FileSystem')
