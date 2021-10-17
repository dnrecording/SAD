package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    private LinkedHashSet<HealthcareServiceable> members;
    public String name;
    public double price;

    HealthcareWorkerTeam() {
        members = new LinkedHashSet<>();
    }

    public void addMember(HealthcareServiceable worker) {
        members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker) {
        members.remove(worker);
    }

    public void service() {
        //return all service
        // Iterator itr = members.iterator();
        // while(itr.hasNext()){
        // System.out.println(itr.next());}
        for(var i : members){
            i.service();
        }
    }

    public double getPrice(){
        //return Price of all members
        int total = 0;
        for(var i : members){
            total += i.getPrice();
        }
        return total;
    }
}
