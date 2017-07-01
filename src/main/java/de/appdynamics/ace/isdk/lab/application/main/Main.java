package de.appdynamics.ace.isdk.lab.application.main;

import com.appdynamics.ace.util.cli.api.api.CommandlineExecution;
import de.appdynamics.ace.isdk.lab.application.main.commands.ClientExecution;
import de.appdynamics.ace.isdk.lab.application.tcpBackend.server.StartBackendServer;

/**
 * Created by stefan.marx on 01.07.17.
 */
public class Main {
    public static void main(String[] args) {
        CommandlineExecution cle = new CommandlineExecution("Sandbox");
        cle.setHelpVerboseEnabled(false);

        cle.addCommand(new ClientExecution("client"));

        cle.addCommand(new StartBackendServer() );

        cle.execute(args);
    }
}
