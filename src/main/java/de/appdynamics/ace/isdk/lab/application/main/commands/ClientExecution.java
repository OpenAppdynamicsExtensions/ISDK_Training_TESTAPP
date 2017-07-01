package de.appdynamics.ace.isdk.lab.application.main.commands;

import com.appdynamics.ace.util.cli.api.api.Command;
import com.appdynamics.ace.util.cli.api.api.CommandException;
import com.appdynamics.ace.util.cli.api.api.OptionWrapper;
import de.appdynamics.ace.isdk.lab.application.main.jobs.*;
import de.appdynamics.ace.isdk.lab.application.runtime.SandboxExecution;
import org.apache.commons.cli.Option;

import java.util.List;

/**
 * Created by stefan.marx on 01.07.17.
 */
public class ClientExecution extends SandboxExecution {

    public static int gs_TCPClientPort;

    @Override
    protected List<Option> getCLIOptionsImpl() {
        List<Option> opts = super.getCLIOptionsImpl();

        Option o;
        opts.add(o= new Option("tcpServerPort",true,"Server port number."));
        o.setRequired(false);

        opts.add(o= new Option("enableTCP",false,"EnableTCPWorkload"));
        o.setRequired(false);
        return opts;
    }

    @Override
    protected int executeImpl(OptionWrapper optionWrapper) throws CommandException {
        gs_TCPClientPort = Integer.parseInt(optionWrapper.getOptionValue("tcpServerPort", "8989"));

        try {
            this.addJob(new SimpleLocalExecution("Business Calls",10,2000,200));
            this.addJob(new SimpleLocalExecution("Business Backends",9,215,20));

            if(optionWrapper.hasOption("enableTCP")) this.addJob(new TCPClientSimple("localhost",gs_TCPClientPort));

            this.addJob(new GoogleBackendCall("SearchCustomerDetail","Customer","de"));
            this.addJob(new AsyncCallback("SimpleAsync",5,30,45,true));
            this.addJob(new AsyncCallback("SimpleAsyncDirectReturn",5,50,150,false));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.executeImpl(optionWrapper);
    }



    public ClientExecution(String title)  {
        super(title);


    }
}
