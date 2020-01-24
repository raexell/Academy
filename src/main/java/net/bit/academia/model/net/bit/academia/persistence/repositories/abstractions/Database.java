package net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions;



import net.bit.academia.model.Agent;

import java.util.Map;

public interface Database {
     Map<Integer, Agent> getAgentMap();

     void loadData();

}
