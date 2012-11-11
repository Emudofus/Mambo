

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        waitingForHelpInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
        waitingForHelpInfo.deserialize(reader);
    }
    
}
