/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.response;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import server.request.AbstractRequest;

/**
 *
 * @author lukas
 */
public class ResponseStop extends AbstractResponse{

    public ResponseStop(AbstractRequest request) {
        super(request);
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        
        b.add("command", request.getCommand());
        
        return b.build();
    }
    
}
