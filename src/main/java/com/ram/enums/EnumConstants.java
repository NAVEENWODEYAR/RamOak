package com.ram.enums;
/**
 * @author NaveenWodeyar
 * @date 19-Sept-2024
 */
public enum EnumConstants {

	DEFAULT_AMOUNT(10.0);

    public final double value; // Make it public and final for direct access

	EnumConstants(double value) {
        this.value = value;
    }
}
