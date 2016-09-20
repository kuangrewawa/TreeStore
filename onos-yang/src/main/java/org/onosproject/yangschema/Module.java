/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.onosproject.yangschema;

import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

import org.onosproject.yangtreestore.ModuleKey;

/**
 * This interface contains the methods for getting the data from the YANG module.
 * 
 * <br>
 * <i>Example of YANG module</i> <code><br>
 * module l3-device {
 *  yang-version 1;
 * namespace "urn:onosproject:yang:shell:l3device:def";
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
@Immutable
public interface Module {
	/**
     * Returns the key of the module.
     *
     * @return 
     */
	ModuleKey getModuleKey();
    /**
     * Returns the prefix of the module
     *
     * @return string with the module prefix which is specified as argument of
     *         YANG {@link Module <b><font color="#0000FF">prefix</font></b>}
     *         keyword
     */
    String getPrefix();

    /**
     * Returns the YANG version which is specified as
     *         argument of YANG {@link Module <b> <font
     *         color="#8b4513">yang-version</font></b>} keyword
     *
     * Default value is 1.
     *
     * @return string
     */
    String getYangVersion();

    /**
     * Returns the module description which is specified as argument
     *         of YANG {@link Module <b><font
     *         color="#b8860b">description</font></b>} keyword.
     *
     * @return string
     */
    String getDescription();

    /**
     * Returns the module reference which is specified as argument
     *         of YANG {@link Module <b><font
     *         color="#008b8b">reference</font></b>} keyword.
     *
     * @return string 
     */
    String getReference();

    /**
     * Returns the module organization as the argument of YANG {@link Module <b><font
     *         color="#606060">organization</font></b>} keyword
     *
     * @return string
     */
    String getOrganization();

    /**
     * Returns the module contact.
     *
     * The contact represents the person or persons to whom technical queries
     * concerning this module should be sent, such as their name, postal
     * address, telephone number, and electronic mail address as the
     *         argument of YANG {@link Module <b><font
     *         color="#FF9900">contact</font></b>} keyword.
     *
     * @return string
     */
    String getContact();

    /**
     * Returns imports which represents YANG modules which are imported to this
     * module via <b>import</b> statement which are specified in the module as the
     *         argument of YANG {@link Module <b><font
     *         color="#9400d3">import</font></b>} keywords.
     *
     * @return set of module imports
     */
    Set<ModuleImport> getImports();

    Set<Module> getSubmodules();

//    /**
//     * Returns <code>NotificationDefinition</code> instances which contain data
//     * from <b>notification</b> statements defined in the module.
//     *
//     * @return notification statements 
//     */
//    Set<NotificationDefinition> getNotifications();
//
//    /**
//     * Returns <code>AugmentationSchema</code> instances which contain data from
//     * <b>augment</b> statements defined in the module.
//     *
//     * @return set of the augmentation schema instances
//     */
//    Set<AugmentationSchema> getAugmentations();
//
//    /**
//     * Returns <code>RpcDefinition</code> instances which contain data from
//     * <b>rpc</b> statements defined in the module.
//     *
//     * @return set of the rpc definition instances 
//     */
//    Set<RpcDefinition> getRpcs();
//
//    /**
//     * Returns <code>Deviation</code> instances which contain data from
//     * <b>deviation</b> statements defined in the module.
//     *
//     * @return set of the deviation instances
//     */
//    Set<Deviation> getDeviations();
//
//    /**
//     * Returns <code>IdentitySchemaNode</code> instances which contain data from
//     * <b>identity</b> statements defined in the module.
//     *
//     * @return set of identity schema node instances
//     */
//    Set<IdentitySchemaNode> getIdentities();
//
//    /**
//     * Returns <code>ExtensionDefinition</code> instances which contain data
//     * from <b>extension</b> statements defined in the module.
//     *
//     * @return set of extension definition instances
//     */
//    List<ExtensionDefinition> getExtensionSchemaNodes();

    

    /**
     * Get yang source.
     */
    String getSource();

}
