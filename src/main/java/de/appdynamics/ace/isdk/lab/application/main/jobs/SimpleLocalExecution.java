package de.appdynamics.ace.isdk.lab.application.main.jobs;

import de.appdynamics.ace.isdk.lab.application.main.jobs.util.BusinessCalltree;
import de.appdynamics.ace.isdk.lab.application.runtime.Job;

/**
 * Created by stefan.marx on 01.07.17.
 */
public class SimpleLocalExecution extends Job {
    private final String _name;
    private final BusinessCalltree _tree;

    public SimpleLocalExecution(String name, int depth, int avgDuration, int variation) {
        super();
        _name = name;
        _tree = new BusinessCalltree(depth,avgDuration,variation);
    }


    @Override
    protected String callJob() {
        _tree.callMyBusiness();
        return "finished";
    }

    @Override
    public String getName() {
        return _name;
    }
}