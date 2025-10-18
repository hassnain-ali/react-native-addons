import { NitroModules, type HybridObject } from 'react-native-nitro-modules'

export interface Contacts
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {}

export default NitroModules.createHybridObject<Contacts>('Contacts')
