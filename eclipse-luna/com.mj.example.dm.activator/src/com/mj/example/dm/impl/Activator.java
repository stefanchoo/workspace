package com.mj.example.dm.impl;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import com.mj.example.dm.Greeting;

public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext bc, DependencyManager dm) throws Exception {
           dm.add(createComponent()
               .setInterface(Greeting.class.getName(), null)
               .setImplementation(GreeterImpl.class)
               );
    }

    @Override
    public void destroy(BundleContext bc, DependencyManager dm) throws Exception {
        System.out.println(bc.getBundle().getSymbolicName() + " has destroyed !");
    }

}
