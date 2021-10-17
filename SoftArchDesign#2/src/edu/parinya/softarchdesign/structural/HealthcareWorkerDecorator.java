package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker {
    protected HealthcareServiceable worker;

    public HealthcareWorkerDecorator(HealthcareWorker worker) {
        super(worker);
        this.worker = worker;
        // TODO Auto-generated constructor stub
    }

    public void service(){
        worker.service();
    }

    public double getPrice(){
        return worker.getPrice();
    }
}
