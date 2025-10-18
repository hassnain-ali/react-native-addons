package com.addons

import com.margelo.nitro.addons.HybridAddonsSpec

class HybridAddons: HybridAddonsSpec() {    
    override fun sum(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}
