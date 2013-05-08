

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorFightersInformation extends NetworkType {
    public static final short TYPE_ID = 169;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int collectorId;
    public CharacterMinimalPlusLookInformations[] allyCharactersInformations;
    public CharacterMinimalPlusLookInformations[] enemyCharactersInformations;
    
    public TaxCollectorFightersInformation() { }
    
    public TaxCollectorFightersInformation(int collectorId, CharacterMinimalPlusLookInformations[] allyCharactersInformations, CharacterMinimalPlusLookInformations[] enemyCharactersInformations) {
        this.collectorId = collectorId;
        this.allyCharactersInformations = allyCharactersInformations;
        this.enemyCharactersInformations = enemyCharactersInformations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(collectorId);
        buf.writeUShort(allyCharactersInformations.length);
        for (CharacterMinimalPlusLookInformations entry : allyCharactersInformations) {
            entry.serialize(buf);
        }
        buf.writeUShort(enemyCharactersInformations.length);
        for (CharacterMinimalPlusLookInformations entry : enemyCharactersInformations) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        collectorId = buf.readInt();
        int limit = buf.readUShort();
        allyCharactersInformations = new CharacterMinimalPlusLookInformations[limit];
        for (int i = 0; i < limit; i++) {
            allyCharactersInformations[i] = new CharacterMinimalPlusLookInformations();
            allyCharactersInformations[i].deserialize(buf);
        }
        limit = buf.readUShort();
        enemyCharactersInformations = new CharacterMinimalPlusLookInformations[limit];
        for (int i = 0; i < limit; i++) {
            enemyCharactersInformations[i] = new CharacterMinimalPlusLookInformations();
            enemyCharactersInformations[i].deserialize(buf);
        }
    }
    
}
