

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum SubEntityBindingPointCategoryEnum {
    HOOK_POINT_CATEGORY_UNUSED(0),
    HOOK_POINT_CATEGORY_PET(1),
    HOOK_POINT_CATEGORY_MOUNT_DRIVER(2),
    HOOK_POINT_CATEGORY_LIFTED_ENTITY(3),
    HOOK_POINT_CATEGORY_BASE_BACKGROUND(4),
    HOOK_POINT_CATEGORY_MERCHANT_BAG(5),
    HOOK_POINT_CATEGORY_BASE_FOREGROUND(6);
    
    private int value;
    SubEntityBindingPointCategoryEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static SubEntityBindingPointCategoryEnum valueOf(int value) {
    	for (SubEntityBindingPointCategoryEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
