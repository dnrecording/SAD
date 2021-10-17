package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator{

    TaxPayingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate " + worker.getName() + " with TaxPaying.");
        //TODO Auto-generated constructor stub
    }
    
    public double getPrice(){
        return worker.getPrice();
    }
}
