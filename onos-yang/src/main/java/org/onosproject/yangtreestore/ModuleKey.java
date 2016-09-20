/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.onosproject.yangtreestore;

import java.net.URI;
import java.util.Date;

import org.onosproject.yangschema.Module;

/**
 * A identifier of YANG module.
 * 
 * <br>
 * <i>Example of YANG module</i> <code><br>
 * module l3-device {
 *  yang-version 1;
 * namespace "urn:onos:yang:shell:l3device:def";
 * prefix "l3dev";
 * import core-device {prefix core-dev; revision-date "2015-10-01";}
 * import ietf-inet-types {prefix inet; revision-date "2010-09-24";}
 * import yang-ext {prefix ext; revision-date "2013-07-09";}
 *
 *	revision "2015-10-01" {
 *		description
 *		  "reworked to give modules their own space";
 *	}
 *
 *	container l3-device {
 *		uses core-dev:core-device;
 *	}
 *
 *	augment "/l3dev:l3-device" {
 *	  ext:augment-identifier "l3-device";
 *	  uses connection;
 *	}
 *
 *	grouping connection {
 *	  leaf ip {
 *	  	type inet:ipv4-address;
 *	  }
 *	  leaf user {
 *	    type string;
 *	  }
 *	  leaf password {
 *	    type string;
 *	  }
 *	}
 *}
 *
 * @author j00310553
 */
public interface ModuleKey {
    /**
     * Returns the name of the module which is specified as argument of YANG
     * {@link Module <b><font color="#FF0000">module</font></b>} keyword
     *
     * @return string with the name of the module
     */
    String getName();

    /**
     * Returns the namespace of the module which is specified as argument of
     * YANG {@link Module <b><font color="#00FF00">namespace</font></b>}
     * keyword. 
     * 
     * @return URI format of the namespace of the module
     */
    URI getNamespace();

    /**
     * Returns the revision date for the module. 
     *
     * @return date of the module revision which is specified as argument of
     *         YANG {@link Module <b><font color="#339900">revison</font></b>}
     *         keyword
     */
    Date getRevision();
}
