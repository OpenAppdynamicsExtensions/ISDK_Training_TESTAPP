package de.appdynamics.ace.isdk.lab.application.main.jobs;

import de.appdynamics.ace.isdk.lab.application.main.jobs.util.GoogleSearcher;
import de.appdynamics.ace.isdk.lab.application.runtime.Job;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.marx
 * Date: 08.11.13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class GoogleBackendCall extends Job {
    private final String _name;
    private final String _search;
    private String _local;

    public GoogleBackendCall(String name, String search,String local) {
        _search = search;
        _name = name ;
        _local = local;
    }

    @Override
    protected String callJob() {


        return GoogleSearcher.searchGoogle("www.google."+_local,_search);



    }

    @Override
    public String getName() {
        return _name;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
