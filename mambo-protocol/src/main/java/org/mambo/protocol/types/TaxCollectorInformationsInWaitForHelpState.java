

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorInformationsInWaitForHelpState extends TaxCollectorInformations {
    public static final short TYPE_ID = 166;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ProtectedEntityWaitingForHelpInfo waitingForHelpInfo;
    
    public TaxCollectorInformationsInWaitForHelpState() { }
    
    public TaxCollectorInformationsInWaitForHelpState(int uniqueId, short firtNameId, short lastNameId, AdditionalTaxCollectorInformations additionalInfos, short worldX, short worldY, short subAreaId, byte state, EntityLook look, int kamas, double experience, int pods, int itemsValue, ProtectedEntityWaitingForHelpInfo waitingForHelpInfo) {
        super(uniqueId, firtNameId, lastNameId, additionalInfos, worldX, worldY, subAreaId, state, look, kamas, experience, pods, itemsValue);
        this.waitingForHelpInfo = waitingForHelpInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        waitingForHelpInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
        waitingForHelpInfo.deserialize(buf);
    }
    
}
