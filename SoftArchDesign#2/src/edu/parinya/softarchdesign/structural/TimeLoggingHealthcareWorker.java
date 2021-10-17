package edu.parinya.softarchdesign.structural;

import java.sql.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{

    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate " + worker.getName() + " with TimeLogging.");
        //TODO Auto-generated constructor stub
    }

    @Override
    public void service(){
        java.util.Date timeLog = new java.util.Date();
        System.out.print(timeLog + ": ");
        worker.service();
    }
    
}
