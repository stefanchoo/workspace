package com.mj.example.dm.tester;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import com.mj.example.dm.Greeting;

/**
 * 通过Activator 来启动 Service
 * @author stefan
 *
 */
public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext bc, DependencyManager dm) throws Exception {
        dm.add(createComponent().setImplementation(Tester.class)
            .add(createServiceDependency().setService(Greeting.class).setRequired(true)));
        
        // if we setRequired(false), after we stop the service in the gogo shell,
        // it will print "Greeting: null"
        
        // Sets the required flag which determines if this service is required or not. 
        // A ServiceDependency is false by default.
        // but when we use annotations, it will be true by default.
        
        // when we stop the bundle, the service which required this bundle could still work.
        // we can demonstrate this point by typing dm notavail in gogo shell after we stop this bundle.
        // so this is an optional bundle.

    }

    @Override
    public void destroy(BundleContext bc, DependencyManager dm) throws Exception {
        System.out.println(bc.getBundle().getSymbolicName() + " has destroyed！");
    }
}
